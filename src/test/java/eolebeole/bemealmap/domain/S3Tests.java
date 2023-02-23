package eolebeole.bemealmap.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import eolebeole.bemealmap.domain.entity.Img;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class S3Tests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testUploadImage() throws Exception {
        String filename = "eolebeole.png";
        URL resource = getClass().getClassLoader().getResource(filename);
        File file = new File(resource.toURI());

        // "eolebeole.png" 파일을 이용하여 가짜 MultipartFile 객체를 생성
        MockMultipartFile mockFile = new MockMultipartFile("file", filename, "image/jpeg", new FileInputStream(file));

        // 파일 업로드 요청
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .multipart("/s3/test").file(mockFile))
                .andExpect(status().isOk())
                .andReturn();
        Img image = objectMapper.readValue(result.getResponse().getContentAsString(), Img.class);
        assertNotEquals(0, image.getImgId());
        assertNotNull(image.getUrl());
        System.out.println(image.getUrl());

        // 파일 삭제 요청
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/s3/" + image.getImgId()))
                .andExpect(status().isOk());
    }
}
