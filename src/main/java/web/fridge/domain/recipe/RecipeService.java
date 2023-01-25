package web.fridge.domain.recipe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private static String RankedRecipeURL="https://www.10000recipe.com/ranking/home_new.html?rtype=r&dtype=d";

    @PostConstruct
    public ResponseEntity<String> crawlRankedRecipe() throws IOException{

        Document doc = Jsoup.connect(RankedRecipeURL).get();

        Elements contents = doc.select("body div div div ul li[class = common_sp_list_li]");

        for(Element content : contents){
            Elements imgContents = content.select("div a[class=common_sp_link] img");
            Elements rankContents = contents.select("p[class =ranking_num st1] b");
            Elements nameContents = content.select("div div[class=common_sp_caption_tit line2]");
            Elements urlContents = content.select("div a[class=common_sp_link]");
            recipeRepository.save(Recipe.builder()
                            .url(urlContents.attr("abs:href"))
                            .name(nameContents.text())
                            .image(imgContents.attr("abs:src")).build());
        }

        return new ResponseEntity<>("레시피 100위 저장 완료", HttpStatus.OK);

    }

    @Transactional
    public ResponseEntity<String> deleteAllRecipe(){
        recipeRepository.deleteAll();
        return new ResponseEntity<>("레시피 전체 삭제 완료", HttpStatus.OK);
    }

}
