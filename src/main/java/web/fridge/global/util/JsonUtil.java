package web.fridge.global.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class JsonUtil {

    public JSONObject decodeHttpRequest(HttpServletRequest request){
        String bodyJson = "";

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = null;
        //한줄씩 담을 변수
        String line = "";

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                br = new BufferedReader(new InputStreamReader(inputStream));
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
            jsonObject = (JSONObject) jsonParser.parse(bodyJson);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
