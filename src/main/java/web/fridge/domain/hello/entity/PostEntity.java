package web.fridge.domain.hello.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "post")
public class PostEntity {
    //post 테이블 20230105

    //`post_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    // `request_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    private Long request_id;
    //`response_id`	BIGINT	NOT NULL	COMMENT 'AUTO INCREMENT PRIMARY KEY',
    private Long response_id;

    //`image_id`	BIGINT	NOT NULL,
    @OneToOne(optional = false)
    @JoinColumn(name = "image_id")
    private ImageEntity image;

    //`product`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String product;

    //`price`	BIGINT	NULL,
    private Long price;

    //`expiry_date`	DATETIME	NULL,
    // `exchange_date`	DATETIME	NULL,
    // `margin_date`	DATETIME	NULL
    private LocalDate expiry_date;
    private LocalDate margin_date;
    private LocalDate exchange_date;

    //`exchange_time`	DATETIME	NULL,
    private LocalTime exchange_time;

    //`method`	VARCHAR(255)	NULL,
    @Column(length = 225)
    private String method;

    //`address`	VARCHAR(255)	NULL
    @Column(length = 225)
    private String address;



}
