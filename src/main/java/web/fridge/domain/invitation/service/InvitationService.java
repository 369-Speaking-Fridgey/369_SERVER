package web.fridge.domain.invitation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.fridge.domain.family.FamilyRepository;
import web.fridge.domain.family.entity.Family;
import web.fridge.domain.family.entity.Role;
import web.fridge.domain.food.controller.dto.FridgeMemberInviteDTO;
import web.fridge.domain.food.repository.FridgeRepository;
import web.fridge.domain.invitation.InvitationRepository;
import web.fridge.domain.invitation.controller.dto.InvitationAcceptDTO;
import web.fridge.domain.invitation.entity.Invitation;
import web.fridge.domain.invitation.entity.InvitationStatus;
import web.fridge.domain.member.entity.Member;
import web.fridge.domain.member.repository.MemberRepository;

import java.util.List;

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

    public List<Invitation> findAllInvitationsByMember(Member member) {
        return invitationRepository.findAllByMemberAndStatus(member, InvitationStatus.IN_QUEUE);
    }

    @Transactional
    public Invitation modifyInvitationStatus(Member member, InvitationAcceptDTO requestDTO) {
        Invitation invitation = invitationRepository.findByMemberAndFridge_FridgeId(member, requestDTO.getFridgeId())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 요청입니다."));
        invitation.setStatus(requestDTO.getIsAccepted());
        if (invitation.getStatus().equals(InvitationStatus.ACCEPTED)){
            Family family = familyRepository.save(Family.builder()
                            .fridge(invitation.getFridge())
                            .member(member)
                            .role(Role.MEMBER).build());
        }
        return invitation;
    }
}
