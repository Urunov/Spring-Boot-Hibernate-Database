package spring.dbimage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.dbimage.model.FileDocs;
import spring.dbimage.service.DocFileStorageService;

import javax.print.Doc;
import java.util.List;

/**
 * @Created 01 / 06 / 2020 - 2:00 PM
 * @project SpringDBImage
 * @Author Hamdamboy
 */

@Controller
public class DocFileController {

    @Autowired
    private DocFileStorageService docFileStorageService;

    @GetMapping("/")
    public String get(Model model) {
        List<FileDocs> docList = docFileStorageService.getFile();
        model.addAttribute("docList", docList);
        return "doc";
    }

    @PostMapping("/uploadFiles")
    public String uploadMultipleFiles(@RequestParam("files")MultipartFile[] files) {

        for(MultipartFile file: files){
            docFileStorageService.saveFile(file);
        }
        return "redirect:/";
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId) {
        FileDocs docs = docFileStorageService.getFile(fileId).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(docs.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+docs.getDocName()+"\"")
                .body(new ByteArrayResource(docs.getData()));
    }
}
