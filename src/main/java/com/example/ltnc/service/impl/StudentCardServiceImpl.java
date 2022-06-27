package com.example.ltnc.service.impl;

import com.example.ltnc.entity.StudentCardDTO;
import com.example.ltnc.service.StudentCardService;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class StudentCardServiceImpl implements StudentCardService {
    @Autowired
    Tesseract tesseract;


    @Override
    public StudentCardDTO getStudentCardInfo(MultipartFile file) throws IOException, TesseractException {
        File convertFile = convert(file);
        String text = tesseract.doOCR(convertFile);
        StudentCardDTO studentCardDTO = new StudentCardDTO();
        studentCardDTO.setResult(text);
        return studentCardDTO;
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
//
}
