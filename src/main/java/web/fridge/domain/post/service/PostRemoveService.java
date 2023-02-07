package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.ExchangeRepository;
import web.fridge.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostRemoveService {
    private final PostRepository postRepository;
    private final ExchangeRepository exchangeRepository;

    @Transactional //채팅 추가 시 관련 채팅방 삭제도 해야함
    public void removePost(Member member, Long postId){
        Post post = postRepository.findByPostId(postId);
        Exchange exchange = exchangeRepository.findByPost(post);
        postRepository.delete(post);
        exchangeRepository.delete(exchange);
    }

    public void removeExchange(Member member){

    }
}
