package web.fridge.domain.food;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;
import web.fridge.domain.member.entity.Member;
import web.fridge.global.entity.BaseTimeEntity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "food")
@NoArgsConstructor
public class Food extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 36)
    @NotNull
    private String name;

    @NotNull
    private String quantity;

    @Nullable
    @Column(length = 225)
    private String memo;

    @NotNull
    @Column(length = 36)
    private String type;

    @NotNull
    @Column(length = 45)
    private String freezeType;

    @NotNull
    @Column(length = 45)
    private LocalDateTime expiryDate;

    @Builder
    public Food(Long foodId, Member member, String name, String quantity, String memo, String type, String freezeType, LocalDateTime expiryDate) {
        this.foodId = foodId;
        this.member = member;
        this.name = name;
        this.quantity = quantity;
        this.memo = memo;
        this.type = type;
        this.freezeType = freezeType;
        this.expiryDate = expiryDate;
    }
}
