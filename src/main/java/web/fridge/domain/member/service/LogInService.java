package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.family.entity.Family;
import web.fridge.domain.family.FamilyRepository;
import web.fridge.domain.family.entity.Role;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.domain.fridge.entity.FridgeType;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.member.controller.dto.GoogleLogInRequestDTO;
import web.fridge.domain.member.controller.dto.NaverLogInRequestDTO;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;
import web.fridge.domain.jwt.JwtService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogInService {

    // TODO: (리팩토링) 반복되는 코드 줄이기
    private final MemberRepository memberRepository;
    private final FridgeRepository fridgeRepository;
    private final FamilyRepository familyRepository;
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
        List<Family> familyList = familyRepository.findByMember(member);
        if (familyList.isEmpty()) {
            Fridge fridge = fridgeRepository.save(Fridge.builder().type(FridgeType.PERSONAL).name(member.getName() + "'s Fridge").build());
            Family family = familyRepository.save(Family.builder().member(member).fridge(fridge).role(Role.OWNER).build());
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(member.getMemberId()));
        return new ResponseEntity<>("카카오 로그인에 성공했습니다", httpHeaders, HttpStatus.OK);
    }

    public Member googleLogIn(GoogleLogInRequestDTO requestDTO) {
        Member member = memberRepository.findByEmail(requestDTO.getEmail())
                .orElse(requestDTO.toEntity());
        List<Family> familyList = familyRepository.findByMember(member);
        if (familyList.isEmpty()) {
            Fridge fridge = fridgeRepository.save(Fridge.builder().type(FridgeType.PERSONAL).name(member.getName() + "'s Fridge").build());
            Family family = familyRepository.save(Family.builder().member(member).fridge(fridge).role(Role.OWNER).build());
        }
        return memberRepository.save(member);
    }

    public Member naverLogIn(NaverLogInRequestDTO requestDTO) {
        Member member = memberRepository.findByEmail(requestDTO.getEmail())
                .orElse(requestDTO.toEntity());
        List<Family> familyList = familyRepository.findByMember(member);
        if (familyList.isEmpty()) {
            Fridge fridge = fridgeRepository.save(Fridge.builder().type(FridgeType.PERSONAL).name(member.getName() + "'s Fridge").build());
            Family family = familyRepository.save(Family.builder().member(member).fridge(fridge).role(Role.OWNER).build());
        }
        return memberRepository.save(member);
    }

}
