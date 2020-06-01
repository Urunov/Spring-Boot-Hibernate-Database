package spring.dbimage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.dbimage.model.FileDocs;
import spring.dbimage.repository.DocFileStorage;

import java.util.List;
import java.util.Optional;

/**
 * @Created 01 / 06 / 2020 - 2:22 PM
 * @project SpringDBImage
 * @Author Hamdamboy
 */
@Service
public class DocFileStorageService {

    @Autowired
    private DocFileStorage docFileStorage;

    public FileDocs saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();

        try {
            FileDocs fileDocs = new FileDocs(docname, file.getContentType(), file.getBytes());
            return docFileStorage.save(fileDocs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public Optional<FileDocs> getFile(Integer fileId){
        return docFileStorage.findById(fileId);
    }

    public List<FileDocs> getFile(){

        return docFileStorage.findAll();
    }
}
