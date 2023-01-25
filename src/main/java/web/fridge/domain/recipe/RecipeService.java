package web.fridge.domain.recipe;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RecipeService {

    private static String RankedRecipeURL="https://www.10000recipe.com/ranking/home_new.html?rtype=r&dtype=d";

    @PostConstruct
    public List<TopRankedRecipe> crawlRankedRecipe() throws IOException{

        Document doc = Jsoup.connect(RankedRecipeURL).get();

        Elements contents = doc.select("body div div div ul li[class = common_sp_list_li]");
        //System.out.println(contents);

        List<TopRankedRecipe> rankedRecipeList = new ArrayList<>();
        for(Element content : contents){
            Elements imgContents = content.select("div a[class=common_sp_link] img");
            //System.out.println(imgContents.attr("abs:src"));

            Elements rankContents = contents.select("p[class =ranking_num st1] b");
            //System.out.println(rankContents.text()); //??

            Elements nameContents = content.select("div div[class=common_sp_caption_tit line2]");
            //System.out.println(nameContents.text());

            Elements urlContents = content.select("div a[class=common_sp_link]");
            //System.out.println(urlContents.attr("abs:href"));

            TopRankedRecipe topRankedRecipes = TopRankedRecipe.builder()
                    .url(urlContents.attr("abs:href"))
                    .name(nameContents.text())
                    .image(imgContents.attr("abs:src"))
                    .build();
            rankedRecipeList.add(topRankedRecipes); //save로 바꾸기
        }

         return rankedRecipeList;

    }

}
