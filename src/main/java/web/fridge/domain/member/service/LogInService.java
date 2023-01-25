package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class LogInService {
    private final MemberRepository memberRepository;

    public void saveKakaoMember(JSONObject kakaoRequest) {
        // Member member = Member.
    }
}
