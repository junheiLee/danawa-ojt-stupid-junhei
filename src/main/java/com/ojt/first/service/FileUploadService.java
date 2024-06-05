package com.ojt.first.service;

import com.ojt.first.dto.response.SaveExcelResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    SaveExcelResponse saveExcelData(String condition, MultipartFile uploadedExcelFile) throws IOException;
}
