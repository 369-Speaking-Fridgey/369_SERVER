package web.fridge.domain.member;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    @GetMapping("/test")
    public String test(@RequestParam String req){
        return req + "실행 완료";
    }



}
