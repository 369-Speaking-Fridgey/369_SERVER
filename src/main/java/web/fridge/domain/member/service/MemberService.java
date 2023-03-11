package web.fridge.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.PostRepository;
import web.fridge.domain.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtProvider jwtProvider;
    private final PostRepository postRepository;

    public ResponseEntity<?> createTestJwt(Long memberId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", jwtProvider.createAccessToken(memberId));
        return new ResponseEntity<>("토큰 발급 성공", httpHeaders, HttpStatus.OK);
    }

    public Boolean isPostOwner(Member member, Long postId){
        Post post = postRepository.findByPostId(postId);
        if(member == post.getMember()){
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }
}
