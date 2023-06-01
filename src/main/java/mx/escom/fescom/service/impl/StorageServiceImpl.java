package mx.escom.fescom.service.impl;

import mx.escom.fescom.entities.File;
import mx.escom.fescom.entities.Image;
import mx.escom.fescom.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {
    @Override
    public Image uploadFileToStorage(MultipartFile imageFile, String name) {
        return null;
    }
}
