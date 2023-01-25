package web.fridge.domain.recipe;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/recipe")
@RestController
public class RecipeController {

    private final RecipeService recipeService;

   @PostMapping("/crawl")
    public ResponseEntity<String> uploadTopRecipe() throws IOException {
        return recipeService.crawlRankedRecipe();
   }

    @DeleteMapping()
    public ResponseEntity<String> removeAllRecipes() {
        return recipeService.deleteAllRecipe();
    }

    @GetMapping
    public ResponseEntity<String> getTopRecipe(){
        return new ResponseEntity<>("레시피 반환 완료(나중에 Dto 반환으로 변경)", HttpStatus.OK);
    }

}
