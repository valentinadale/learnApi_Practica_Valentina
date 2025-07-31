package IntegracionBackFront.backfront.Controller.FirebaseController;

import IntegracionBackFront.backfront.Services.FirebaseStorage.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private FirebaseStorageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file){
        try{
            String fileUrl = service.uploadFile(file);
            return ResponseEntity.ok().body("{\\\"url\\\":\\\"\" + fileUrl + \"\\\"}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
