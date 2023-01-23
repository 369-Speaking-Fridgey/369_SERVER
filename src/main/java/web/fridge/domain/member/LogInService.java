package web.fridge.domain.member;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class LogInService {
    private final MemberRepository memberRepository;
    public void saveKakaoMember(JSONObject kakaoRequest) {
        Member member = Member.
    }
}
