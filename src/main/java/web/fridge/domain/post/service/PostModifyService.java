package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostModifyService {
    private final PostRepository postRepository;

    public void modifyDealStatus(){

    }

}
