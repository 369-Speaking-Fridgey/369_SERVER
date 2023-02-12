package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import web.fridge.domain.image.Image;
import web.fridge.domain.image.ImageService;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.dto.PostDetails;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.ExchangeRepository;
import web.fridge.domain.post.repository.PostRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PostRegisterService {

    private final ExchangeRepository exchangeRepository;
    private final PostRepository postRepository;
    private final ImageService imageService;

    @Transactional //upload pre signed
    public Post addPost(Member member,MultipartFile multipartFile, PostDetails postDetails) throws IOException {
        Image image = imageService.upload(multipartFile);
        Post post = new Post().initPost(member,postDetails,image);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public Exchange addExchange(Long postId, Member member){
        Post post = postRepository.findByPostId(postId);
        Exchange exchange = new Exchange().initExchange(member,post);
        exchangeRepository.save(exchange);
        return exchange;
    }


}
