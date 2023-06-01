package mx.escom.fescom.service.impl;

import mx.escom.fescom.entities.Image;
import mx.escom.fescom.repositories.ImageRepository;
import mx.escom.fescom.service.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }
}
