package web.fridge.domain.fridge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.fridge.domain.fridge.controller.dto.*;
import web.fridge.domain.fridge.entity.Fridge;
import web.fridge.domain.fridge.service.FridgeService;
import web.fridge.domain.invitation.controller.dto.InvitationResponseDTO;
import web.fridge.domain.invitation.entity.Invitation;
import web.fridge.domain.invitation.service.InvitationService;
import web.fridge.domain.member.annotation.AuthMember;
import web.fridge.domain.member.controller.dto.MemberResponseDTO;
import web.fridge.domain.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/fridges", produces = "application/json; charset=utf8")
public class FridgeController {
    private final FridgeService fridgeService;
    private final InvitationService invitationService;

    @GetMapping
    public ResponseEntity<?> fridgeListFind(@AuthMember Member member){
        List<Fridge> fridgeList = fridgeService.findFridgeListByMember(member);
        List<FridgeResponseDTO> responseDTOList = new ArrayList<>();
        for (Fridge fridge : fridgeList){
            responseDTOList.add(FridgeResponseDTO.builder().member(member).fridge(fridge).build());
        }
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @GetMapping("/{fridgeId}")
    public ResponseEntity<?> fridgeMemberListFind(@AuthMember Member member, @PathVariable Long fridgeId){
        List<Member> memberList = fridgeService.findMembersByFridge(fridgeId);
        List<MemberResponseDTO> responseDTOList = new ArrayList<>();
        for (Member fridgeMember : memberList) {
            responseDTOList.add(MemberResponseDTO.builder().member(member).build());
        }
        return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
    }

    @PostMapping("/invite")
    public ResponseEntity<?> fridgeMemberInvite(@AuthMember Member member, @RequestBody FridgeMemberInviteDTO requestDTO){
        Invitation invitation = invitationService.inviteFridgeMember(member, requestDTO);
        InvitationResponseDTO invitationResponseDTO = new InvitationResponseDTO(invitation);
        return new ResponseEntity<>(invitationResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> fridgeMemberRemoveSelf(@AuthMember Member member, @RequestBody FridgeMemberWithdrawDTO requestDTO){
        fridgeService.removeFridgeMember(member, requestDTO);
        return new ResponseEntity<>("냉장고에서 탈퇴되셨습니다.", HttpStatus.OK);
    }

    @PostMapping("/bye")
    public ResponseEntity<?> fridgeMemberRemove(@AuthMember Member member, @RequestBody FridgeMemberRemoveDTO requestDTO) throws IllegalAccessException {
        fridgeService.removeFridgeMemberByOwner(member, requestDTO);
        return new ResponseEntity<>("냉장고에서 탈퇴되었습니다.", HttpStatus.OK);
    }

    @PostMapping("/stop")
    public ResponseEntity<?> fridgeRemoveByOwner(@AuthMember Member member, @RequestBody FridgeRemoveDTO requestDTO){
        Fridge fridge = fridgeService.removeFridge(member, requestDTO);
        return new ResponseEntity<>(new FridgeResponseDTO(member, fridge), HttpStatus.OK);
    }

}
