package web.fridge.domain.region;

import lombok.Getter;
import lombok.ToString;
import org.json.simple.JSONObject;

import javax.persistence.*;


@Getter //log
@ToString //log 
@Entity
@Table(name = "region")
public class Region {
    //region 테이블 20230105
    /*  `region_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
        `region_name`	VARCHAR(64)	NULL,
	    `region_group`	BIGINT	NULL*/

    @Id
    private Long regionId;

    @Column(length = 4)
    private String area0;

    @Column(length = 255)
    private String area1;

    @Column(length = 255)
    private String area2;

    @Column(length = 255)
    private String area3;

    @Column(length = 255)
    private String area4;

    public  Region initRegion(Long id, JSONObject area0, JSONObject area1,JSONObject area2, JSONObject area3 ){
        this.regionId = id;
        this.area0 = area0.get("name").toString();
        this.area1 = area1.get("name").toString();
        this.area2 = area2.get("name").toString();
        this.area3 = area1.get("name").toString();
        return  this;
    }
}
