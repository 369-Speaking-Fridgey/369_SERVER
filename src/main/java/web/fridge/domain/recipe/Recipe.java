package web.fridge.domain.recipe;

import lombok.Builder;
import lombok.NoArgsConstructor;
import web.fridge.domain.image.Image;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @Column(length = 225)
    private String image;

    @Column(length = 64)
    private String name;

    @Column(length = 225)
    private String url;

    @Builder
    public Recipe(String image, String name, String url) {
        this.image = image;
        this.name = name;
        this.url = url;
    }
}
