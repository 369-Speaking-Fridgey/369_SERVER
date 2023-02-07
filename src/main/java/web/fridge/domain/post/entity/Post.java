package web.fridge.domain.post.entity;

import web.fridge.domain.image.Image;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.dto.PostDetails;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public Post initPost(Member member, PostDetails postDetails){
        this.member = member;
        this.title = postDetails.getTitle();
        this.contents = postDetails.getContents();
        this.price = postDetails.getPrice();
        this.exchangeAt = postDetails.getExchangeAt();
        this.requestAt = postDetails.getRequestAt();
        this.exchangeAt = postDetails.getExchangeAt();
        this.method = postDetails.getMethod();
        this.address = postDetails.getAddress();
        return this;
    }


}
