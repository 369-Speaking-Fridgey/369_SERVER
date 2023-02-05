package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostRemoveService {
    private final PostRepository postRepository;

    public void removePost(){
        
    }

    public void removeDeal(){

    }
}
