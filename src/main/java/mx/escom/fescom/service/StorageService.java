package mx.escom.fescom.service;

import mx.escom.fescom.entities.File;
import mx.escom.fescom.entities.Image;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    Image uploadFileToStorage(MultipartFile imageFile, String route);
}
