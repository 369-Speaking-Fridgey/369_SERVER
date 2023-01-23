package web.fridge.domain.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.global.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Slf4j
public class LogInController {

    private final JsonUtil jsonUtil;
    private final LogInService logInService;

    @PostMapping("/kakao")
    public ResponseEntity<Object> kakaoLogIn(HttpServletRequest request){
        JSONObject kakaoRequest = jsonUtil.decodeHttpRequest(request);
        logInService.saveKakaoMember(kakaoRequest);
        return ResponseEntity.ok(200);
    }

}
