package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import web.fridge.domain.image.ImageService;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.dto.PostDetails;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.PostRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PostRegisterService {
    private final PostRepository postRepository;
    private final ImageService imageService;

    @Transactional
    public Post addPost(Member member,MultipartFile multipartFile, PostDetails postDetails) throws IOException {
        imageService.upload(multipartFile); //upload pre signed & Member save
        Post post = new Post().initPost(member,postDetails);
        postRepository.save(post);
        return post;
    }

    @Transactional
    public void addExchange(Member member){
        //

    }


}
