package com.example.ltnc.service;

import com.example.ltnc.entity.StudentCardDTO;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentCardService {
    StudentCardDTO getStudentCardInfo(MultipartFile file) throws IOException, TesseractException;
}
