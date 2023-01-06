package web.fridge.domain.post;

import web.fridge.domain.image.Image;
import web.fridge.domain.member.Member;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "post")
public class Post extends BaseTimeEntity {
    //post 테이블 20230105

    //`post_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    // `request_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id")
    private Member member;
    //`response_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',

    @ManyToOne(optional = false)
    @JoinColumn(name = "buyer_id")
    private Member buyer;

    //`image_id`	BIGINT	NOT NULL,
    @OneToOne(optional = false)
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(length = 225)
    private String title;

    @Column()
    private String contents;

    //`product`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String product;

    //`price`	BIGINT	NULL,
    private Long price;

    //`expiry_date`	DATETIME	NULL,
    // `exchange_date`	DATETIME	NULL,
    // `margin_date`	DATETIME	NULL
    private LocalDateTime expiredAt;

    private LocalDateTime requestAt;

    private LocalDateTime exchangeAt;

    //`method`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String method;

    //`address`	VARCHAR(255)	NULL
    @Column(length = 225)
    private String address;



}
