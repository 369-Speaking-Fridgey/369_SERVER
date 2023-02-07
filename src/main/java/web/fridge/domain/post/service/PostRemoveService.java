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
    public void removePost(Long postId){
        Post post = postRepository.findByPostId(postId);
        postRepository.delete(post);
        //removeExchange(postId); 포스트 삭제 시 거래도 삭제 되게 할건지 역대 거래 조회..?
    }

    @Transactional
    public void removeExchange(Long postId){
        Post post = postRepository.findByPostId(postId);
        Exchange exchange = exchangeRepository.findByPost(post);
        exchangeRepository.delete(exchange);
    }
}
