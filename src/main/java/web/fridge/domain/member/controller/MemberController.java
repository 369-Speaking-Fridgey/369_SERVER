package web.fridge.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam("id") Long id){
        log.info(id.toString());
        return memberService.createTestJwt(id);
    }

    @GetMapping("/current")
    public ResponseEntity<?> testUser(@AuthMember Member member){
        return new ResponseEntity<>(member, HttpStatus.OK);
    }



}
