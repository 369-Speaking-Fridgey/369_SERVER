package web.fridge.domain.region;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public Region saveRegion(JSONObject request){

        //상태 코드 확인
        JSONObject status = (JSONObject) request.get("status");
        String message = status.get("name").toString();
        //법정동 코드
        JSONObject results = (JSONObject) request.get("results");
        JSONObject code = (JSONObject) results.get("code");
        Long regionId = Long.parseLong(code.get("id").toString());
        //지역 분리
        JSONObject allRegion = (JSONObject) results.get("region");
        JSONObject area0  = (JSONObject) allRegion.get("area0");
        JSONObject area1  = (JSONObject) allRegion.get("area1");
        JSONObject area2  = (JSONObject) allRegion.get("area2");
        JSONObject area3  = (JSONObject) allRegion.get("area3");

        try{
            Region region = new Region().initRegion(regionId, area0, area1, area2, area3);
            regionRepository.save(region);
            return region;
        }catch(Exception e){
            return null;
        }
    }

}
