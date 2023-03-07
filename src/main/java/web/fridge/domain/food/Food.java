package web.fridge.domain.food;

import org.springframework.data.annotation.CreatedDate;
import web.fridge.domain.member.entity.Member;
import web.fridge.global.entity.BaseTimeEntity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "food")
public class Food extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 36)
    private String name;

    private Long quantity;

    @Column(length = 225)
    private String memo;

    @Column(length = 36)
    private String type;

}
