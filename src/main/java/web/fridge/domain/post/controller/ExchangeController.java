package web.fridge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.service.*;
import web.fridge.global.enums.Status;

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


    @GetMapping("/member/complete")
    public ResponseEntity<List> exchangeByMemberCompleteList(
            @AuthMember Member member
        ){
        log.info("[ExchangeController][exchangeByMemberCompleteList]:{}",member.getMemberId().toString());
        List<Exchange> exchanges = postFindService.findExchangeByMemberStatusComplete(member);
        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    @GetMapping("/member/reserved") //by status reserved
    public ResponseEntity<List<Exchange>> exchangeByMemberReservedList(
            @AuthMember Member member){
        log.info("[ExchangeController][exchangeByMemberReservedList]:{}",member.getMemberId().toString());
        List<Exchange> exchanges = postFindService.findExchangeByMemberStatusReserved(member);
        return new ResponseEntity<>(exchanges,HttpStatus.OK);
    }

    @PostMapping("/{post_id}")
    public ResponseEntity<Exchange> exchangeAdd(
            @AuthMember Member member,
            @PathVariable(value = "post_id") Long postId){
        log.info("[ExchangeController][exchangeAdd]:{}",postId);
        Exchange exchange = postRegisterService.addExchange(postId, member);
        return new ResponseEntity<>(exchange, HttpStatus.OK);
    }

    @DeleteMapping("/{exchanged_id}")
    public ResponseEntity<String> exchangeRemove(
            @AuthMember Member member,
            @PathVariable(value = "exchanged_id") Long exchangedId){
        log.info("[ExchangeController][exchangeRemove]:{}",member.toString());
        postRemoveService.removeExchange(exchangedId);
        return new ResponseEntity<>("cancel deal", HttpStatus.OK);
    }

    @PutMapping("/{exchanged_id}")
    public ResponseEntity<Status> exchangeStatusModify(
            @AuthMember Member member,
            @PathVariable(value = "exchanged_id") Long exchanged_id){
        log.info("[ExchangeController][exchangeStatusModify]:{}",exchanged_id.toString());
        Status status = postModifyService.modifyExchangeStatus(exchanged_id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
