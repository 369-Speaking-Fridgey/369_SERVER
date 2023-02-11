package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.ExchangeRepository;
import web.fridge.domain.post.repository.PostRepository;
import web.fridge.domain.region.Region;
import web.fridge.global.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostFindService {

    private final PostRepository postRepository;
    private final ExchangeRepository exchangeRepository;

    public void findPostByRegion(Member member){
        List<Post> posts = postRepository.findByMember(member);
        Region region = member.getRegion();

    }

    public List<Exchange> findExchangeByMemberStatusComplete(Member member){
        List<Exchange> exchanges = exchangeRepository.findAllByMember(member);
        exchanges = exchanges.stream()
                .filter(b -> b.getStatus().equals(Status.COMPLETED)).collect(Collectors.toList());
        return exchanges;
    }

    public Post findPostByPostID(Member member, Long postId){
        return postRepository.findByPostId(postId);
    }
}
