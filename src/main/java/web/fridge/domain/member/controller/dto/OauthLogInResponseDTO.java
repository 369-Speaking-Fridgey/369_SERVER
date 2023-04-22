package web.fridge.domain.member.controller.dto;

import lombok.Builder;

public class OauthLogInResponseDTO {
    public String accessToken;
    public String refreshToken;
    public String message;

    @Builder
    public OauthLogInResponseDTO(String accessToken, String refreshToken, String message) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.message = message;
    }
}
