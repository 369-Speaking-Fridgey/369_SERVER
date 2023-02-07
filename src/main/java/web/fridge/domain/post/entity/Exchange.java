package web.fridge.domain.post.entity;


import web.fridge.domain.member.entity.Member;
import web.fridge.global.entity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange")
public class Exchange extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "requester_id")
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name ="post_id")
    private Post post;

    private LocalDateTime createdAt;

    @Column(length = 10)
    private String status;

}
