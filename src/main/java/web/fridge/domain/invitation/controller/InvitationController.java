package web.fridge.domain.invitation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.invitation.controller.dto.InvitationAcceptDTO;
import web.fridge.domain.invitation.controller.dto.InvitationResponseDTO;
import web.fridge.domain.invitation.entity.Invitation;
import web.fridge.domain.invitation.service.InvitationService;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invitations")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping
    public ResponseEntity<?> invitationFindByMember(@AuthMember Member member){
        List<Invitation> invitationList = invitationService.findAllInvitationsByMember(member);
        List<InvitationResponseDTO> responseDTOList = invitationList.stream().map(InvitationResponseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> invitationStatusModify(@AuthMember Member member, @RequestBody InvitationAcceptDTO requestDTO){
        Invitation invitation = invitationService.modifyInvitationStatus(member, requestDTO);
        return new ResponseEntity<>(new InvitationResponseDTO(invitation), HttpStatus.OK);
    }

}
