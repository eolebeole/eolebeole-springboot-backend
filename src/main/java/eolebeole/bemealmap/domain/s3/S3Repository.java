package eolebeole.bemealmap.domain.s3;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;

@Repository
public class S3Repository {

    @Bean
    public S3Client s3client() {
        return S3Client.builder()
                .region(Region.AP_NORTHEAST_2) // AWS 리전을 설정합니다.
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public DeleteObjectResponse deleteFile(S3File object) {
        return s3client().deleteObject(DeleteObjectRequest.builder()
                .bucket(object.getBucketName())
                .key(object.getKeyName())
                .build());
    }

    public String getUrl(S3File file) {
        return s3client().utilities().getUrl(builder -> builder
                .bucket(file.getBucketName())
                .key(file.getKeyName())
        ).toExternalForm();
    }

    public PutObjectResponse uploadFile(S3File object, MultipartFile file) throws IOException {
        return s3client().putObject(PutObjectRequest.builder()
                .bucket(object.getBucketName())
                .key(object.getKeyName())
                .build(), RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
    }
}
