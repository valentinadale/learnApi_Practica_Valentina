package IntegracionBackFront.backfront.Services.FirebaseStorage;

import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FirebaseStorageService {
    public String uploadFile(MultipartFile file) throws IOException {
        // Genera un nombre único para el archivo
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Bucket bucket = StorageClient.getInstance().bucket();
        bucket.create(fileName, file.getBytes(), file.getContentType());

        // Genera URL pública (opcional)
        return String.format(
                "https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                bucket.getName(), fileName
        );
    }
}
