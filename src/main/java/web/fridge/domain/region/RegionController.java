package web.fridge.domain.region;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.fridge.global.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;
    private final JsonUtil jsonUtil;

    @PostMapping("/local")
    public ResponseEntity<Region> saveRegion(HttpServletRequest request){
        JSONObject naverRequest = jsonUtil.decodeHttpRequest(request);
        Region region = regionService.saveRegion(naverRequest);
        log.info("[RegionController][Region]:{}",region.toString());
        return new ResponseEntity<>(region,HttpStatus.OK);
    }



}
