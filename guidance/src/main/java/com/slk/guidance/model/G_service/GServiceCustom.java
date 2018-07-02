package com.slk.guidance.model.G_service;

import org.springframework.web.multipart.MultipartFile;
public class GServiceCustom extends GService {

    private MultipartFile files;

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }
}
