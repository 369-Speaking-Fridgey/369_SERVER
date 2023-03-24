package web.fridge.domain.family.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.family.entity.Role;
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

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    private Fridge fridge;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Family(Long familyId, Fridge fridge, Member member, Role role) {
        this.familyId = familyId;
        this.fridge = fridge;
        this.member = member;
        this.role = role;
    }
}
