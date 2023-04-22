package web.fridge.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String provider;

    @Column(length = 64)
    private String email;

    @Column(length = 225)
    private String profile;

    @Builder
    public Member(String name, String provider, String email, String profile) {
        this.name = name;
        this.provider = provider;
        this.email = email;
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }
}
