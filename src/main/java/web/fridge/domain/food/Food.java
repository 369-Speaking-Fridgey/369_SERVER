package web.fridge.domain.food;

import org.springframework.data.annotation.CreatedDate;
import web.fridge.domain.member.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "food")
public class Food {
    //food 테이블 20230105

    //`food_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    //`member_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //`food_name`	VARCHAR(36)	NULL,
    @Column(length = 36)
    private String name;

    //`quantity`	BIGINT	NULL,
    private Long quantity;

    //`memo`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String memo;

    //`type`	VARCHAR(36)	NULL	COMMENT 'check(ETC, MEET, VEGE, MILK, FROZEN)',
    @Column(length = 36)
    private String type;

    //`created_at`	DATETIME	NULL	COMMENT 'current_timestamp'
    @CreatedDate
    private LocalDateTime createdAt;

    //`expiry_date`	DATETIME	NULL
    private LocalDateTime expiredAt;

}
