package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;
import web.fridge.domain.region.RegionRepository;
import web.fridge.global.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class LogInService {

    private final MemberRepository memberRepository;
    private final RegionRepository regionRepository;
    private final JwtProvider jwtProvider;

    public ResponseEntity<String> saveKakaoMember(JSONObject kakaoRequest) {

        JSONObject kakaoAccountInfo = (JSONObject) kakaoRequest.get("kakao_account");
        JSONObject kakaoProfileInfo = (JSONObject) kakaoAccountInfo.get("profile");

        Member member = Member.builder()
                .email(kakaoAccountInfo.get("email").toString())
                .nickname(kakaoProfileInfo.get("nickname").toString())
                .provider("KAKAO")
                .region(regionRepository.findById(Long.valueOf(1141010400)).get()) // TODO: 수정해야함
                .profile(kakaoProfileInfo.get("profile_image_url").toString())
                .build();

        Member savedMember = memberRepository.save(member);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(member.getMemberId()));
        return new ResponseEntity<>("카카오 로그인에 성공했습니다", httpHeaders, HttpStatus.OK);
    }
}
