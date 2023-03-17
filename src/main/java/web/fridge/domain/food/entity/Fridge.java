package web.fridge.domain.food.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import web.fridge.domain.member.entity.Member;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fridgeId;

    @Column(length = 64)
    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FridgeType type;

    @Builder
    public Fridge(Long fridgeId, String name,  FridgeType type) {
        this.fridgeId = fridgeId;
        this.name = name;
        this.type = type;
    }
}
