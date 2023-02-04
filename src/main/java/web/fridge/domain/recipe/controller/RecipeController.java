package web.fridge.domain.recipe.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.recipe.RecipeService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


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
    public ResponseEntity<?> getTopRecipe(){
        return recipeService.findAllRecipe();
    }

}
