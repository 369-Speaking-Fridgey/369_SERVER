package web.fridge.domain.member;

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

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/login")
@Slf4j
public class LogInController {

    @PostMapping("/kakao")
    public ResponseEntity<Object> kakaoLogIn(HttpServletRequest request){
        String bodyJson = "";

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = null;
        //한줄씩 담을 변수
        String line = "";

        try {
            //body내용 inputstream에 담는다.
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                br = new BufferedReader(new InputStreamReader(inputStream));
                //더 읽을 라인이 없을때까지 계속
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }else {
                log.info("Data 없음");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bodyJson = stringBuilder.toString();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            //json 형태로 변환하기
            jsonObject = (JSONObject) jsonParser.parse(bodyJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        log.info(jsonObject.toJSONString());
        return ResponseEntity.ok(200);
    }

}
