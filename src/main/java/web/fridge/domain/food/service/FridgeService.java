package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.member.entity.Member;

@Service
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;

    public Fridge makePrivateMemberFridge(Member member){

    }
}
