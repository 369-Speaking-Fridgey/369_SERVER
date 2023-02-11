package web.fridge.domain.post.entity;


import lombok.Getter;
import web.fridge.domain.member.entity.Member;
import web.fridge.global.entity.BaseTimeEntity;
import web.fridge.global.enums.Status;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "exchange")
public class Exchange extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangedId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "requester_id")
    private Member member;

    @ManyToOne(optional = false)
    @JoinColumn(name ="post_id")
    private Post post;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Exchange initExchange(Member member,Post post){
        this.member = member;
        this.post = post;
        this.status = Status.INPROGRESS;
        return this;
    }

}
