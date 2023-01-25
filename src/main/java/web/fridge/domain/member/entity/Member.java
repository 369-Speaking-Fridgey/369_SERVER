package web.fridge.domain.member.entity;

import lombok.Getter;
import web.fridge.domain.region.Region;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id")
    private Region region;

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
