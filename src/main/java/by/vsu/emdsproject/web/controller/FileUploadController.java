package by.vsu.emdsproject.web.controller;

import java.util.ArrayList;
import java.util.List;

import by.vsu.emdsproject.web.form.FileUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String displayForm() {
        return "file_upload_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
            Model map) {

        List<MultipartFile> files = uploadForm.getFiles();

        List<String> fileNames = new ArrayList<String>();

        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()

            }
        }

        map.addAttribute("files", fileNames);
        return "file_upload_success";
    }
}