package com.ojt.first.controller;

import com.ojt.first.dto.response.SaveExcelResponse;
import com.ojt.first.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/files")
@RestController
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SaveExcelResponse uploadExcelData(@RequestParam String condition,
                                             @RequestParam MultipartFile excelFile) throws IOException {

        return fileUploadService.saveExcelData(condition, excelFile);
    }

}
