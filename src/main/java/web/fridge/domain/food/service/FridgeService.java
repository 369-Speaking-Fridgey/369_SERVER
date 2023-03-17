package web.fridge.domain.food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.family.Family;
import web.fridge.domain.family.FamilyRepository;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.member.entity.Member;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;
    private final FamilyRepository familyRepository;


    public List<Fridge> findFridgeListByMember(Member member) {
        List<Family> familyList = familyRepository.findByMember(member);
        List<Fridge> fridgeList = new ArrayList<>();
        for (Family family : familyList){
            fridgeList.add(family.getFridge());
        }
        return fridgeList;
    }

    // TODO: queryDSL로 리팩토링
    public List<Member> findMembersByFridge(Long fridgeId) {
        List<Family> familyList = familyRepository.findAllByFridge(fridgeRepository.findById(fridgeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 냉장고입니다.")));
        List<Member> memberList = new ArrayList<>();
        for (Family family : familyList) {
            memberList.add(family.getMember());
        }
        return memberList;
    }

}
