package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.ExchangeRepository;
import web.fridge.domain.post.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostFindService {

    private final PostRepository postRepository;
    private final ExchangeRepository exchangeRepository;

    public void findPostByRegion(Member member){

    }

    public List<Exchange> findExchangeByMember(Member member){
       return exchangeRepository.findAllByMember(member);
    }

    public void findPostByPostID(Member member, Long postId){
        Post post = postRepository.findByPostId(postId);
    }
}
