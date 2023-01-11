package web.fridge.domain.image;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {


    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;
    private final ImageRepository imageRepository;

    public String upload(MultipartFile multipartFile) throws IOException {

        //파일 이름 중복 방지 UUID 사용
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        //파일 사이즈 체크
        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getInputStream().available());
        //s3 파일 업로드
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        //S3 url 받아오기 <에러남 Endpoint does not contain a valid host name: null
        String s3Url = amazonS3.getUrl(bucket, s3FileName).toString();

        //image table
        Image image = new Image().initImage(s3Url,s3FileName);
        imageRepository.save(image);

        return s3Url;
    }


}
