package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.jwt.JwtService;
import web.fridge.domain.member.controller.dto.MemberNameModifyRequestDTO;
import web.fridge.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtService jwtProvider;

    public ResponseEntity<?> createTestJwt(Long memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(memberId));
        return new ResponseEntity<>("토큰 발급 성공", httpHeaders, HttpStatus.OK);
    }

    public Member modifyMemberName(Member member, MemberNameModifyRequestDTO requestDTO) {
        member.setName(requestDTO.getName());
        return member;
    }
}
