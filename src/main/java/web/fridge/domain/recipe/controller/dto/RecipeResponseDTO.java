package web.fridge.domain.recipe.controller.dto;

import lombok.Builder;
import lombok.Getter;
import web.fridge.domain.recipe.Recipe;

@Getter
public class RecipeResponseDTO {
    private String image;
    private String name;
    private String url;

    @Builder
    public RecipeResponseDTO(Recipe entity) {
        this.image = entity.getImage();
        this.name = entity.getName();
        this.url = entity.getUrl();
    }
}
