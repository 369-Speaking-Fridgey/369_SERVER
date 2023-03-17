package web.fridge.domain.invitation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.fridge.domain.family.FamilyRepository;
import web.fridge.domain.food.controller.FridgeMemberInviteDTO;
import web.fridge.domain.food.entity.Fridge;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.invitation.InvitationRepository;
import web.fridge.domain.invitation.entity.Invitation;
import web.fridge.domain.invitation.entity.InvitationStatus;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class InvitationService {
    private final InvitationRepository invitationRepository;
    private final FamilyRepository familyRepository;
    private final MemberRepository memberRepository;
    private final FridgeRepository fridgeRepository;

    public Invitation inviteFridgeMember(Member member, FridgeMemberInviteDTO requestDTO) {
        Member invitedMember = memberRepository.findByEmail(requestDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        return invitationRepository.save(
                Invitation.builder()
                        .fridge(fridgeRepository.findById(requestDTO.getFridgeId())
                                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다.")))
                        .member(invitedMember)
                        .status(InvitationStatus.IN_QUEUE)
                        .build()
        );
    }
}
