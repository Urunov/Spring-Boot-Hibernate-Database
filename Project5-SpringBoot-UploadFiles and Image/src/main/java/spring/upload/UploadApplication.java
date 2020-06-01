package spring.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.upload.controller.FileUplloadController;

import java.io.File;

@SpringBootApplication
public class UploadApplication {

    public static void main(String[] args) {

        new File(FileUplloadController.uploadDirectory).mkdir();
        SpringApplication.run(UploadApplication.class, args);
    }



}
