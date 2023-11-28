package mx.escom.fescom.service.impl;

import mx.escom.fescom.entities.Image;
import mx.escom.fescom.service.StorageService;
import org.javaswift.joss.model.Account;
import org.javaswift.joss.model.Container;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {

    //private final Account storageService;
    private final String containerName;

    public StorageServiceImpl( @Value("{openstack.swift.tenant}") String container){
        this.containerName = container;
        //this.storageService = storageService;
    }
    @Override
    public Image uploadFileToStorage(MultipartFile imageFile, String name) {

        /*
        * Container container = storageService.getContainer(containerName);
        container.create();
        container.makePublic();*/
        return null;
    }
}
