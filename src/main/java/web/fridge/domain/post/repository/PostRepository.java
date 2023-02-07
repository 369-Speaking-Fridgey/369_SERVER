package web.fridge.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.fridge.domain.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByPostId(Long postId);

}
