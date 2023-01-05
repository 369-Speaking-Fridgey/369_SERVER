package web.fridge.domain.hello.entity;

import javax.persistence.*;


@Entity
@Table(name = "region")
public class RegionEntity {
    //region 테이블 20230105
    /*  `region_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
        `region_name`	VARCHAR(64)	NULL,
	    `region_group`	BIGINT	NULL*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long region_id;

    @Column(length = 64)
    private String region_name;

    private  Long region_group;
}
