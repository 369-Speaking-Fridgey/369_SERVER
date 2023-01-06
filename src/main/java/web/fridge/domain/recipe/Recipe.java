package web.fridge.domain.recipe;

import web.fridge.domain.image.Image;

import javax.persistence.*;


@Entity
@Table(name = "recipe")
public class Recipe {
    //recipe 테이블 2023010

    //`recipe_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    //`image_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @OneToOne(optional = false)
    @JoinColumn(name = "image_id")
    private Image image;

    //`recipe_name`	VARCHAR(64)	NULL,
    @Column(length = 64)
    private String name;

    //`url`	VARCHAR(255)	NULL*/
    @Column(length = 225)
    private String url;
}
