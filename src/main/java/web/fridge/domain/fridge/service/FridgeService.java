package web.fridge.domain.fridge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.family.entity.Family;
import web.fridge.domain.family.FamilyRepository;
import web.fridge.domain.family.entity.Role;
import web.fridge.domain.fridge.controller.dto.FridgeMemberRemoveDTO;
import web.fridge.domain.fridge.controller.dto.FridgeMemberWithdrawDTO;
import web.fridge.domain.fridge.controller.dto.FridgeRemoveDTO;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.domain.fridge.entity.FridgeType;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.member.entity.Member;

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
        for (Family family : familyList) {
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

    @Transactional
    public void removeFridgeMember(Member member, FridgeMemberWithdrawDTO requestDTO) {
        Family family = familyRepository.findByMemberAndFridge_FridgeId(member, requestDTO.getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 접근입니다."));
        family.setRole(Role.REMOVED);
    }

    @Transactional
    public void removeFridgeMemberByOwner(Member member, FridgeMemberRemoveDTO requestDTO) throws IllegalAccessException {
        Family ownerFamily = familyRepository.findByMemberAndFridge_FridgeId(member, requestDTO.getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 접근입니다."));
        if (ownerFamily.getRole() != Role.OWNER || ownerFamily.getFridge().getType() == FridgeType.PERSONAL) {
            throw new IllegalAccessException("삭제할 수 있는 권한이 없습니다.");
        }
        Family memberFamily = familyRepository.findByMember_MemberIdAndFridge_FridgeId(requestDTO.getMemberId(), requestDTO.getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 접근입니다."));
        memberFamily.setRole(Role.REMOVED);
    }

    @Transactional
    public void removeFridge(Member member, FridgeRemoveDTO requestDTO) {
        Family ownerFamily = familyRepository.findByMemberAndFridge_FridgeId(member, requestDTO.getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 접근입니다."));
        if (ownerFamily.getRole() != Role.OWNER || ownerFamily.getFridge().getType() == FridgeType.PERSONAL) {
            throw new IllegalArgumentException("삭제할 수 있는 권한이 없습니다.");
        }
        List<Family> familyList = familyRepository.findAllByFridge_FridgeId(requestDTO.getFridgeId());
        familyRepository.deleteAll(familyList);
    }
}
