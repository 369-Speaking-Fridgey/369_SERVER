package web.fridge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.service.MemberService;
import web.fridge.domain.post.dto.PostDetails;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.service.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostFindService postFindService;
    private final PostRegisterService postRegisterService;
    private final PostRemoveService postRemoveService;
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Post> postAdd(
            @AuthMember Member member,
            @RequestPart(value = "image") MultipartFile multipartFile,
            @RequestPart(value = "post") PostDetails postDetails) throws IOException {
        log.info("[PostController][postAdd]:{}",member.toString());
        Post post = postRegisterService.addPost(member,multipartFile,postDetails);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    //포스트 삭제 시 관련 거래도 삭제 되게 할건지? 다른 유저의 거래 기록 확인이 남아있어야하니까
    //채팅 추가 시 관련 채팅방 삭제도 해야함
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> postRemove(
            @AuthMember Member member,
            @PathVariable(value = "postId") Long postId){
        log.info("[PostController][postRemove]:{}",postId);
        Boolean isPostOwner = memberService.isPostOwner(member,postId);
        if(isPostOwner == Boolean.TRUE){
            postRemoveService.removePost(postId);
            return new ResponseEntity<>("delete post",HttpStatus.OK);
        }
        else return new ResponseEntity<>("your not a post owner",HttpStatus.CONFLICT);
    }

    //거래 완료된 포스트도 가져올 건지?
    //post 등록 시 address 등록 형식 문제가 있음 (자유롭게 String으로 받으면 멤버의 Region과 비교하기 어려움)
    @GetMapping
    public ResponseEntity<List<Post>> postByRegionList(
            @AuthMember Member member){
        log.info("[PostController][PostByRegionList]:{}",member.getRegion().toString());
        List<Post> posts = postFindService.findPostByRegion(member);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> postByPostID(
            @AuthMember Member member,
            @PathVariable(value = "postId") Long postId){
        Post post = postFindService.findPostByPostID(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
