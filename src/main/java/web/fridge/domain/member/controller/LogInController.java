package web.fridge.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.jwt.JwtService;
import web.fridge.domain.member.controller.dto.GoogleLogInRequestDTO;
import web.fridge.domain.member.controller.dto.NaverLogInRequestDTO;
import web.fridge.domain.member.controller.dto.OauthLogInResponseDTO;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.service.LogInService;
import web.fridge.global.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value ="/login", produces = "application/json; charset=utf8")
@RequiredArgsConstructor
@Slf4j
public class LogInController {

    private final JsonUtil jsonUtil;
    private final LogInService logInService;
    private final JwtService jwtService;

    @PostMapping("/kakao")
    public ResponseEntity<String> kakaoLogIn(HttpServletRequest request){
        JSONObject kakaoRequest = jsonUtil.decodeHttpRequest(request);
        return logInService.saveKakaoMember(kakaoRequest);
    }

    @PostMapping("/google")
    public ResponseEntity<?> googleLogIn(@RequestBody GoogleLogInRequestDTO requestDTO){
        log.info(requestDTO.getName());
        Member member = logInService.googleLogIn(requestDTO);
        log.info(member.getMemberId().toString());
        OauthLogInResponseDTO responseDTO = OauthLogInResponseDTO.builder()
                .accessToken(jwtService.createAccessToken(member.getMemberId()))
                .refreshToken(jwtService.createRefreshToken(member.getEmail()))
                .message("성공적으로 로그인되었습니다.")
                .build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/naver")
    public ResponseEntity<?> naverLogIn(@RequestBody NaverLogInRequestDTO requestDTO){
        Member member = logInService.naverLogIn(requestDTO);
        OauthLogInResponseDTO responseDTO = OauthLogInResponseDTO.builder()
                .accessToken(jwtService.createAccessToken(member.getMemberId()))
                .refreshToken(jwtService.createRefreshToken(member.getEmail()))
                .message("성공적으로 로그인되었습니다.")
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
