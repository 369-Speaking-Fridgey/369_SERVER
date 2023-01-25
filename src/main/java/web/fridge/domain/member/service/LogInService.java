package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LogInService {

    private final MemberRepository memberRepository;

    public ResponseEntity<String> saveKakaoMember(JSONObject kakaoRequest) {

        JSONObject kakaoAccountInfo = (JSONObject) kakaoRequest.get("kakao_account");
        JSONObject kakaoProfileInfo = (JSONObject) kakaoAccountInfo.get("profile");

        Member member = Member.builder()
                .email(kakaoAccountInfo.get("eamil").toString())
                .nickname(kakaoAccountInfo.get("nickname").toString())
                .provider("KAKAO")
                .build();
        return new ResponseEntity<>("가입에 성공했습니다", HttpStatus.OK);
    }
}
