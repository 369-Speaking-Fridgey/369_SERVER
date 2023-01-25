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

    //서비스단 48번째줄 디버그 찍고 돌려보면 단위별 객체화 잘되는거 확인됨. 이미지 다운로드 때문에 save 처리 아직 안함
   @PostMapping("/top100")
    public ResponseEntity<String> uploadTopRecipe() throws IOException {
        recipeService.crawlRankedRecipe();
        return new ResponseEntity<>("레시피 100위 저장 완료", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> getTopRecipe(){
        return new ResponseEntity<>("레시피 반환 완료(나중에 Dto 반환으로 변경)", HttpStatus.OK);
    }

}
