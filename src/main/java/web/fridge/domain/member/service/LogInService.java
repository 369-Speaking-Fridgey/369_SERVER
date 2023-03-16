package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.controller.dto.GoogleLogInRequestDTO;
import web.fridge.domain.member.controller.dto.NaverLogInRequestDTO;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;
import web.fridge.domain.jwt.JwtService;

@Service
@RequiredArgsConstructor
public class LogInService {

    private final MemberRepository memberRepository;
    private final JwtService jwtProvider;

    public ResponseEntity<String> saveKakaoMember(JSONObject kakaoRequest) {

        JSONObject kakaoAccountInfo = (JSONObject) kakaoRequest.get("kakao_account");
        JSONObject kakaoProfileInfo = (JSONObject) kakaoAccountInfo.get("profile");

        Member member = Member.builder()
                .email(kakaoAccountInfo.get("email").toString())
                .name(kakaoProfileInfo.get("nickname").toString())
                .provider("KAKAO")
                .profile(kakaoProfileInfo.get("profile_image_url").toString())
                .build();

        Member savedMember = memberRepository.save(member);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(member.getMemberId()));
        return new ResponseEntity<>("카카오 로그인에 성공했습니다", httpHeaders, HttpStatus.OK);
    }

    public Member googleLogIn(GoogleLogInRequestDTO requestDTO) {
        Member member = memberRepository.findByEmail(requestDTO.getEmail())
                .orElse(requestDTO.toEntity());
        return memberRepository.save(member);
    }

    public Member naverLogIn(NaverLogInRequestDTO requestDTO) {
        Member member = memberRepository.findByEmail(requestDTO.getEmail())
                .orElse(requestDTO.toEntity());
        return memberRepository.save(member);
    }
}
