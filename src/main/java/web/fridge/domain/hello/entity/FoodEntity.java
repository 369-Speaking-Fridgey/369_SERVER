package web.fridge.domain.hello.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "food")
public class FoodEntity {
    //food 테이블 20230105

    //`food_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long food_id;

    //`member_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    //`food_name`	VARCHAR(36)	NULL,
    @Column(length = 36)
    private String food_name;

    //`quantity`	BIGINT	NULL,
    private Long quantity;

    //`memo`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String memo;

    //`type`	VARCHAR(36)	NULL	COMMENT 'check(ETC, MEET, VEGE, MILK, FROZEN)',
    @Column(length = 36)
    private String type;

    //`created_at`	DATETIME	NULL	COMMENT 'current_timestamp'
    private LocalDate created_at = LocalDate.now();

    //`expiry_date`	DATETIME	NULL
    private LocalDate expiry_date;

}
