package web.fridge.domain.image;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    //image 테이블 20230105

    //`image_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    //`image_name`	VARCHAR(64)	NULL,
    @Column(length = 64)
    private String name;

    //`url`	VARCHAR(255)	NULL
    @Column(length = 225)
    private String url;
}
