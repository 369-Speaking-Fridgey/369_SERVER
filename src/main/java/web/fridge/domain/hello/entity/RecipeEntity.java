package web.fridge.domain.hello.entity;

import javax.persistence.*;


@Entity
@Table(name = "recipe")
public class RecipeEntity {
    //recipe 테이블 2023010

    //`recipe_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;

    //`image_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @OneToOne(optional = false)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    //`recipe_name`	VARCHAR(64)	NULL,
    @Column(length = 64)
    private String recipe_name;

    //`url`	VARCHAR(255)	NULL*/
    @Column(length = 225)
    private String url;
}
