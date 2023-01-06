package web.fridge.domain.region;

import javax.persistence.*;


@Entity
@Table(name = "region")
public class Region {
    //region 테이블 20230105
    /*  `region_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
        `region_name`	VARCHAR(64)	NULL,
	    `region_group`	BIGINT	NULL*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;

    @Column(length = 64)
    private String name;

    private  Long group;
}
