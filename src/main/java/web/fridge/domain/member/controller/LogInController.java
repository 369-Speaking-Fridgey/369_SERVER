package web.fridge.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.domain.member.service.LogInService;
import web.fridge.global.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LogInController {

    private final JsonUtil jsonUtil;
    private final LogInService logInService;

    @PostMapping("/kakao")
    public ResponseEntity<String> kakaoLogIn(HttpServletRequest request){
        JSONObject kakaoRequest = jsonUtil.decodeHttpRequest(request);
        return logInService.saveKakaoMember(kakaoRequest);;
    }

}
