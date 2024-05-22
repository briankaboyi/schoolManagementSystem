package com.school.demo.service;

import com.school.demo.Utils.ImageUtils;
import com.school.demo.entities.StudentFile;
import com.school.demo.repositories.FileRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class FileService {
    FileRepo fileRepo;
    public FileService( FileRepo fileRepo){
        this.fileRepo = fileRepo;
    }
    public String uploadFile(MultipartFile multipartFile) throws IOException, SQLException {


        StudentFile studentFile= new StudentFile();
        studentFile.setName(multipartFile.getName());
        studentFile.setType(multipartFile.getContentType());
        byte[] bytes = multipartFile.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
        studentFile.setData(blob);


        System.out.println(studentFile.getName());

     fileRepo.save(studentFile);
        return "File uploaded successfully";
    }





    public byte[] downloadFile(Long id) throws SQLException {
        Optional<StudentFile> savedFile = fileRepo.findById(id);
        byte[] imageBytes=null;
      imageBytes= savedFile.get().getData().getBytes(1,(int) savedFile.get().getData().length());
        return imageBytes;
    }
}
