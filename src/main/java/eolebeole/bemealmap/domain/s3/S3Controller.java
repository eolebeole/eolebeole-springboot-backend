package eolebeole.bemealmap.domain.s3;

import eolebeole.bemealmap.domain.entity.Img;
import eolebeole.bemealmap.domain.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Optional;

@Controller
@RequestMapping("/s3/*")
public class S3Controller {
    @Autowired
    private ImgRepository imgRepository;

    @Autowired
    private S3Service s3Service;

    @Bean
    public Base64.Encoder base64Encoder() {
        return Base64.getUrlEncoder().withoutPadding();
    }

    private String encodeTimestamp() {
        long current = System.currentTimeMillis();
        byte[] bytes = ByteBuffer.allocate(Long.BYTES).putLong(current).array();
        return base64Encoder().encodeToString(bytes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Img> optional = imgRepository.findById(id);
        if (optional.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Img img = optional.get();
        assert s3Service.delete(img);
        imgRepository.delete(img);
        return new ResponseEntity(img, HttpStatus.OK);
    }

    @PostMapping("/{type}")
    public ResponseEntity upload(@PathVariable String type, @RequestParam("file") MultipartFile file) {
        String key = String.format("%s/%s_%s", type, encodeTimestamp(), file.getOriginalFilename());

        Img img = new Img();
        img.setBucketName("eolebeole");
        img.setKeyName(key);
        try {
            String url = s3Service.upload(img, file);
            imgRepository.save(img);

            img.setUrl(url);
            return new ResponseEntity(img, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
