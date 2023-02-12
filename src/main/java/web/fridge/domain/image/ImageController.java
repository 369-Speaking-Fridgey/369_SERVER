package web.fridge.domain.image;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@Slf4j
@RequiredArgsConstructor
@RequestMapping("/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadFile(@RequestPart("images") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(imageService.upload(multipartFile),HttpStatus.OK);
    }

}
