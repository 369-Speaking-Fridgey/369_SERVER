package web.fridge.domain.basket.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.member.entity.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    @Column(length = 64)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BasketStatus status;

    @Builder
    public Basket(Long basketId, Member member, String name, BasketStatus basketStatus) {
        this.basketId = basketId;
        this.member = member;
        this.name = name;
        this.status = basketStatus;
    }
}
