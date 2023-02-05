package web.fridge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.service.PostFindService;
import web.fridge.domain.post.service.PostModifyService;
import web.fridge.domain.post.service.PostRegisterService;
import web.fridge.domain.post.service.PostRemoveService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostFindService postFindService;
    private final PostRegisterService postRegisterService;
    private final PostRemoveService postRemoveService;
    private final PostModifyService postModifyService;

    //post 식재료 거래 등록
    @PostMapping
    public ResponseEntity<String> postAdd(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][postAdd]:{}",member.toString());
        postRegisterService.addPost();
        return new ResponseEntity<>("save post", HttpStatus.OK);
    }

    //delete 식재료 거래 삭제 apo
    @DeleteMapping
    public ResponseEntity<String> postRemove(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][postRemove]:{}",member.toString());
        postRemoveService.removePost();
        return new ResponseEntity<>("delete post",HttpStatus.OK);
    }

    //get 위치 기반 식재료 거래 목록 반환 사용자 위치(region)기반 식재료 조회
    @GetMapping
    public ResponseEntity<String> postByRegionList(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][PostByRegionList]:{}",member.toString());
        postFindService.findPostByRegion();
        return new ResponseEntity<>("get post by region", HttpStatus.OK);

    }

    //get 사용자별 거래 조회
    @GetMapping
    public ResponseEntity<String> postByMemberList(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][PostByMemberList]:{}",member.toString());
        postFindService.findPostByMember();
        return new ResponseEntity<>("get post by Member", HttpStatus.OK);
    }

    //post 식재료 거래 요청
    @PostMapping("/deal")
    public ResponseEntity<String> dealAdd(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][dealAdd]:{}",member.toString());
        postRegisterService.addDeal();

        return new ResponseEntity<>("send deal", HttpStatus.OK);
    }

    //delete 식재료 거래 취소
    @DeleteMapping("/deal")
    public ResponseEntity<String> dealRemove(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][dealRemove]:{}",member.toString());
        postRemoveService.removeDeal();
        return new ResponseEntity<>("cancel deal", HttpStatus.OK);
    }

    //put 식재료 거래완료
    @PutMapping("/deal")
    public ResponseEntity<String> dealStatusModify(
            @AuthMember Member member,
            @RequestHeader(value = "Authorization") String token){
        log.info("[PostController][dealStatusModify]:{}",member.toString());
        postModifyService.modifyDealStatus();
        return new ResponseEntity<>("complete deal", HttpStatus.OK);
    }

    //Get 거래 단건 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<String> postByPostID(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable(value = "postId") Long postId
    ){
        postFindService.findPostByPostID();
        return new ResponseEntity<>("get a post By postID",HttpStatus.OK);
    }
}
