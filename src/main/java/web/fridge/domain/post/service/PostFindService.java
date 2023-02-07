package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostFindService {

    private final PostRepository postRepository;

    public void findPostByRegion(Member member){

    }

    public void findExchangeByMember(Member member){

    }

    public void findPostByPostID(Member member, Long postId){
        Post post = postRepository.findByPostId(postId);
    }
}
