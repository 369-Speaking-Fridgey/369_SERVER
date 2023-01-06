package web.fridge.domain.member;

import web.fridge.domain.region.Region;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class Member extends BaseTimeEntity {
    //member 테이블 20230105

    //`member_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    //`region_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY'
    @OneToOne(optional = false)
    @JoinColumn(name = "region_id")
    private Region region;

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
