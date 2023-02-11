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
            @AuthMember Member member){
        log.info("[ExchangeController][exchangeByMemberCompleteList]:{}",member.getMemberId().toString());
        List<Exchange> exchanges = postFindService.findExchangeByMemberStatusComplete(member);
        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    //거래 중인 것과 거래 신청한 것이 함께 보여줄건지 따로 보여줄 건지?
    //차이는 탭이 2개로 나눌건지 3개로 나눌 건지 입니다 (거래완료/거래 신청 내역) 혹은 (거래중/예약중/거래완료)
    @GetMapping("/member/reserved")
    public ResponseEntity<List<Exchange>> exchangeByMemberReservedList(
            @AuthMember Member member){
        log.info("[ExchangeController][exchangeByMemberReservedList]:{}",member.getMemberId().toString());
        List<Exchange> exchanges = postFindService.findExchangeByMemberStatusReserved(member);
        return new ResponseEntity<>(exchanges,HttpStatus.OK);
    }

    @PostMapping("/{post_id}")
    public ResponseEntity<?> exchangeAdd(
            @AuthMember Member member,
            @PathVariable(value = "post_id") Long postId){
        log.info("[ExchangeController][exchangeAdd]:{}",postId);
        Boolean isExchangExist = postFindService.isExchangeExist(member,postId);
        if(isExchangExist == Boolean.TRUE){
            return new ResponseEntity<>("exchange is already exist", HttpStatus.OK);
        } else {
            Exchange exchange = postRegisterService.addExchange(postId, member);
            return new ResponseEntity<>(exchange, HttpStatus.OK);
        }
    }

    //완료된 거래(complete) 시 한쪽에서 지우면 다른쪽에서 보이게 할지
    @DeleteMapping("/{exchanged_id}")
    public ResponseEntity<String> exchangeRemove(
            @AuthMember Member member,
            @PathVariable(value = "exchanged_id") Long exchangedId){
        log.info("[ExchangeController][exchangeRemove]:{}",member.toString());
        Status status = postFindService.getExchangeStatus(exchangedId);
        if(status == Status.INPROGRESS){
            postRemoveService.removeExchange(exchangedId);
            return new ResponseEntity<>("cancel exchange", HttpStatus.OK);
        }else if(status == Status.RESERVED){
            return new ResponseEntity<>("exchange is reserved, cancel is not allowed",HttpStatus.OK);
        }else return new ResponseEntity<>("completed exchange, allowed",HttpStatus.OK);

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
