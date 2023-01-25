package web.fridge.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import web.fridge.domain.region.Region;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
public class Member{
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

    @Builder
    public Member(Region region, String nickname, String provider, String email, String profile) {
        this.region = region;
        this.nickname = nickname;
        this.provider = provider;
        this.email = email;
        this.profile = profile;
    }
}
