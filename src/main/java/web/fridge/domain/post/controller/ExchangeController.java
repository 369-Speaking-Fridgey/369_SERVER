package web.fridge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.service.PostFindService;
import web.fridge.domain.post.service.PostModifyService;
import web.fridge.domain.post.service.PostRegisterService;
import web.fridge.domain.post.service.PostRemoveService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {

    private final PostFindService postFindService;
    private final PostRegisterService postRegisterService;
    private final PostRemoveService postRemoveService;
    private final PostModifyService postModifyService;


    @GetMapping("/member")
    public ResponseEntity<List> exchangeByMemberList(
            @AuthMember Member member){
        log.info("[ExchangeController][exchangeByMemberList]:{}",member.getMemberId().toString());
        List<Exchange> exchanges = postFindService.findExchangeByMember(member);
        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    //post 식재료 거래 요청
    @PostMapping("/{post_id}")
    public ResponseEntity<String> exchangeAdd(
            @AuthMember Member member,
            @PathVariable(value = "post_id") Long postId){
        log.info("[ExchangeController][exchangeAdd]:{}",member.toString());
        postRegisterService.addExchange(member);
        return new ResponseEntity<>("send deal", HttpStatus.OK);
    }

    //delete 식재료 거래 취소
    @DeleteMapping("/{post_id}")
    public ResponseEntity<String> exchangeRemove(
            @AuthMember Member member,
            @PathVariable(value = "post_id") Long postId){
        log.info("[ExchangeController][exchangeRemove]:{}",member.toString());
        postRemoveService.removeExchange(postId);
        return new ResponseEntity<>("cancel deal", HttpStatus.OK);
    }

    //put 식재료 거래 완료
    @PutMapping("/{post_id}")
    public ResponseEntity<String> exchangeStatusModify(
            @AuthMember Member member,
            @PathVariable(value = "post_id") Long postId){
        log.info("[ExchangeController][exchangeStatusModify]:{}",member.toString());
        postModifyService.modifyExchangeStatus();
        return new ResponseEntity<>("complete deal", HttpStatus.OK);
    }
}
