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
        Post post = postFindService.findPostByPostID(member,postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
