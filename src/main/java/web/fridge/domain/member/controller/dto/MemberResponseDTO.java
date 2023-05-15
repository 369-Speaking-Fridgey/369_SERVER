package web.fridge.domain.member.controller.dto;

import lombok.Builder;
import lombok.Getter;
import web.fridge.domain.member.entity.Member;

@Getter
public class MemberResponseDTO {
    private Long memberId;
    private String name;
    private String email;

    private String profile;

    @Builder
    public MemberResponseDTO(Member member){
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.profile = member.getProfile();
    }
}
