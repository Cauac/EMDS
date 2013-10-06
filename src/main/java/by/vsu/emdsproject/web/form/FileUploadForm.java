package by.vsu.emdsproject.web.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}