package com.example.ltnc;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LtncApplication {

	public static void main(String[] args) {
		SpringApplication.run(LtncApplication.class, args);
	}

	@Bean
	Tesseract getTesseract(){
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("./tessdata");
		tesseract.setLanguage("vie");
		return tesseract;
	}
}
