package com.ojt.first.service;

import com.ojt.first.config.UploadableFileForm;
import com.ojt.first.dto.response.SaveExcelResponse;
import com.ojt.first.excel.PostExcelHandler;
import com.ojt.first.excel.handler.ExcelHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final PostExcelHandler postExcelHandler;

    @Override
    public SaveExcelResponse saveExcelData(String condition,
                                           MultipartFile uploadedExcelFile) throws IOException {

        String fileName = uploadedExcelFile.getOriginalFilename();

        if (!postExcelHandler.canParse(fileName)) {
            throw new RuntimeException("임시" + "확장자가 다르다는 메시지");
        }

        List<String> headers = postExcelHandler.getHeaders(uploadedExcelFile.getInputStream());
        ExcelHandler handler = UploadableFileForm.get(condition, headers).getHandler().get();

        return null;
    }
}
