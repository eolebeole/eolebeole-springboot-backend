package eolebeole.bemealmap.domain.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

@Repository
public class S3Service {

    @Autowired
    private S3Repository s3Repository;

    public boolean delete(S3File img) {
        return s3Repository.deleteFile(img).sdkHttpResponse().isSuccessful();
    }

    public String upload(S3File img, MultipartFile file) throws IOException {
        PutObjectResponse response = s3Repository.uploadFile(img, file);
        assert response.sdkHttpResponse().isSuccessful();
        return s3Repository.getUrl(img);
    }
}
