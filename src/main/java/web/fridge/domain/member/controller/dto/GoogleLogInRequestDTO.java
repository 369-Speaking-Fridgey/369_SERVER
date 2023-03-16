package web.fridge.domain.member.controller.dto;

import lombok.Getter;
import web.fridge.domain.member.entity.Member;

@Getter
public class GoogleLogInRequestDTO {
    private String id;
    private String name;
    private String profile;
    private String email;

    public Member toEntity() {
        return Member.builder()
                .name(this.getName())
                .profile(this.getProfile())
                .email(this.getEmail())
                .provider("GOOGLE")
                .build();
    }
}
