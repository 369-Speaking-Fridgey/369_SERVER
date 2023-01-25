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

        
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        
        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getInputStream().available());
        
        amazonS3.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        
        String s3Url = amazonS3.getUrl(bucket, s3FileName).toString();

        Image image = new Image().initImage(s3Url,s3FileName);
        imageRepository.save(image);

        return s3Url;
    }


}
