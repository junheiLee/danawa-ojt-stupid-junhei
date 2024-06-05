package com.ojt.first.controller;

import com.ojt.first.excel.PostExcelHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/files")
@RestController
public class FileUploadController {

    private final PostExcelHandler postExcelHandler;

    @PostMapping("/{condition}")
    public String saveExcelData(@PathVariable String condition,
                                @RequestParam MultipartFile excelFile) throws IOException {

        if (!postExcelHandler.canParse(excelFile)) {
            throw new RuntimeException("임시" + "확장자가 다르다는 메시지");
        }
        List<String> headers = postExcelHandler.getHeaders(excelFile);

        return headers.toString();

    }

}
