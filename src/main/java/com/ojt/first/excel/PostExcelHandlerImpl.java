package com.ojt.first.excel;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class PostExcelHandlerImpl implements PostExcelHandler {

    private final static String[] EXCEL_EXTENSIONS = {"xls", "xlsx"};

    @Override
    public boolean canParse(MultipartFile uploadFile) {

        String extension = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
        return Arrays.asList(EXCEL_EXTENSIONS).contains(extension);
    }

    public PostExcelHandlerImpl() {
        super();
    }

    @Override
    public List<String> getHeaders(MultipartFile uploadFile) throws IOException {

        Workbook wb = WorkbookFactory.create(uploadFile.getInputStream());

        Iterator<Cell> headersIterator = getHeadersIterator(wb);    // Header 정보인 0번째 sheet의 0번째 row의 Iterator를 가져욘다.
        List<String> headers = toStringList(headersIterator);       // Iterator를 List<String>으로 변환

        wb.close();

        return headers;
    }

    private Iterator<Cell> getHeadersIterator(Workbook wb) {
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(0);

        return row.cellIterator();
    }

    private List<String> toStringList(Iterator<Cell> cells) {
        List<String> headers = new ArrayList<>();

        while (cells.hasNext()) {
            Cell cell = cells.next();
            headers.add(cell.getStringCellValue());
        }
        return headers;
    }

}
