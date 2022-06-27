package com.example.ltnc.controller;

import com.example.ltnc.entity.StudentCardDTO;
import com.example.ltnc.service.StudentCardService;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/student-card")
@RequiredArgsConstructor
public class StudentCardController {
    private final StudentCardService studentCardService;

    @PostMapping("/upload")
    public ResponseEntity<StudentCardDTO> upload(@RequestBody MultipartFile file) throws TesseractException, IOException {
        return ResponseEntity.ok(studentCardService.getStudentCardInfo(file));
    }

}
