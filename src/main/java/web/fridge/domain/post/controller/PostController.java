package web.fridge.domain.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.dto.PostDetails;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.service.PostFindService;
import web.fridge.domain.post.service.PostModifyService;
import web.fridge.domain.post.service.PostRegisterService;
import web.fridge.domain.post.service.PostRemoveService;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostFindService postFindService;
    private final PostRegisterService postRegisterService;
    private final PostRemoveService postRemoveService;

    @PostMapping
    public ResponseEntity<Post> postAdd(
            @AuthMember Member member,
            @RequestPart(value = "image") MultipartFile multipartFile,
            @RequestPart(value = "post") PostDetails postDetails) throws IOException {
        log.info("[PostController][postAdd]:{}",member.toString());
        Post post = postRegisterService.addPost(member,multipartFile,postDetails);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> postRemove(
            @AuthMember Member member,
            @PathVariable(value = "postId") Long postId){
        log.info("[PostController][postRemove]:{}",postId);
        postRemoveService.removePost(postId);
        return new ResponseEntity<>("delete post",HttpStatus.OK);
    }

    //get 위치 기반 식재료 거래 목록 반환 사용자 위치(region)기반 식재료 포스트 조회
    @GetMapping
    public ResponseEntity<String> postByRegionList(
            @AuthMember Member member){
        log.info("[PostController][PostByRegionList]:{}",member.getRegion().toString());
        postFindService.findPostByRegion(member);
        return new ResponseEntity<>("get post by region", HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> postByPostID(
            @AuthMember Member member,
            @PathVariable(value = "postId") Long postId){
        Post post = postFindService.findPostByPostID(member,postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
