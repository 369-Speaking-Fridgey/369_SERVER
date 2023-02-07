package web.fridge.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {

    Exchange findByPost(Post post);

    List<Exchange> findAllByMember(Member member);

}
