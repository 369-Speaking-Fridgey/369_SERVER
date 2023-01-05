package web.fridge.domain.hello.entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class MemberEntity {
    //member 테이블 20230105

    //`member_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    //`region_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY'
    @OneToOne(optional = false)
    @JoinColumn(name = "resion_id")
    private RegionEntity region;

    /*`nickname`	VARCHAR(64)	NULL,
    * `provider`	VARCHAR(64)	NULL	COMMENT 'check(GOOGLE, KAKAO, NAVER)',
	`email`	VARCHAR(64)	NULL,
	`profile`	VARCHAR(255)	NULL,
	`address`	VARCHAR(255)	NULL*/
    @Column(length = 64)
    private String nickname;
    @Column(length = 64)
    private String provider;
    @Column(length = 64)
    private String email;
    @Column(length = 225)
    private String profile;
    @Column(length = 225)
    private String address;


}
