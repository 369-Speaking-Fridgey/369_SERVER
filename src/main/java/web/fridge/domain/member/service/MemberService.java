package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.global.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtProvider jwtProvider;
    public ResponseEntity<?> createTestJwt(Long memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(memberId));
        return new ResponseEntity<>("토큰 발급 성공", httpHeaders, HttpStatus.OK);
    }
}
