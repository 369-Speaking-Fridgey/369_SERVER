package web.fridge.domain.family;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.member.entity.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;

    @NotNull
    @Column(length = 64)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Family(Long familyId, String name, Fridge fridge, Member member) {
        this.familyId = familyId;
        this.name = name;
        this.fridge = fridge;
        this.member = member;
    }
}
