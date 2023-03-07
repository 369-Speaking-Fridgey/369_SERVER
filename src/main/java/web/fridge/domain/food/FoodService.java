package web.fridge.domain.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.member.entity.Member;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> foodFind(Member member) {
        return foodRepository.findAllByMember(member);
    }
}
