package com.school.demo.controllers;

import com.school.demo.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class fileController {
    FileService fileService;
    public fileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<?>  uploadFile(@RequestParam("image") MultipartFile multipartFile) throws IOException, SQLException {
        String upload=fileService.uploadFile(multipartFile);
     return ResponseEntity.status(HttpStatus.OK).body(upload);
    }


    @GetMapping("/downloadFile/{id}")
        public ResponseEntity<?> downloadFile(@PathVariable Long id) throws SQLException {
        byte[] data= fileService.downloadFile(id);
        if(data==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(data)
                ;
        }
}
