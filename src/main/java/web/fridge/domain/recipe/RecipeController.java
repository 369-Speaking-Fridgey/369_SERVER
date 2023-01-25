package web.fridge.domain.recipe;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<String> getTopRecipe(){
        return new ResponseEntity<>("레시피 반환 완료(나중에 Dto 반환으로 변경)", HttpStatus.OK);
    }

}
