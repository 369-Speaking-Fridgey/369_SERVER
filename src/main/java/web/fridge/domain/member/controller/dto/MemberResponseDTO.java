package web.fridge.domain.member.controller.dto;

import lombok.Builder;
import web.fridge.domain.member.entity.Member;

public class MemberResponseDTO {
    private Long memberId;
    private String name;
    private String email;

    @Builder
    public MemberResponseDTO(Member member){
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
