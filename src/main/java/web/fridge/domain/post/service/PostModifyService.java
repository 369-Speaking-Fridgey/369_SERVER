package web.fridge.domain.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.post.entity.Exchange;
import web.fridge.domain.post.entity.Post;
import web.fridge.domain.post.repository.ExchangeRepository;
import web.fridge.domain.post.repository.PostRepository;
import web.fridge.global.enums.Status;

@Service
@RequiredArgsConstructor
public class PostModifyService {
    private final PostRepository postRepository;
    private final ExchangeRepository exchangeRepository;

    @Transactional
    public Status modifyExchangeStatus(Long exchangedId){
        Exchange exchange = exchangeRepository.findByExchangedId(exchangedId);
        exchange.completeExchange(exchange);
        return exchange.getStatus();
    }

}
