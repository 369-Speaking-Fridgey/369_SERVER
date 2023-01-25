package web.fridge.domain.recipe;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class TopRankedRecipe {
    private String name;
    private String image;
    private String url;
}
