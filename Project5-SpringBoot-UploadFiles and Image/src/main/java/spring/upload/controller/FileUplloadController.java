package spring.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Created 01 / 06 / 2020 - 11:20 AM
 * @project SpringBootUploadFile
 * @Author Hamdamboy
 */

@Controller
public class FileUplloadController {

    public static String uploadDirectory = System.getProperty("user.dir") + "/upload";

    @RequestMapping(name= "/")
    public String UploadPage() {

        return "uploadview";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("files")MultipartFile[] files) {
        StringBuilder fileNames = new StringBuilder();

        for(MultipartFile file: files){
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());

            try {
                Files.write(fileNameAndPath, file.getBytes());

            } catch (IOException e){
                e.printStackTrace();
            }

        }
        model.addAttribute("msg", "Successfully uploaded files" + fileNames.toString());
        return "uploadstatusview";
    }


    @RequestMapping("/showMe")
    public String showMe(Model model){


        return "showMe";
    }

}
