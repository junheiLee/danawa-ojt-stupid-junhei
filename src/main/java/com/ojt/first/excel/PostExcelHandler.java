package com.ojt.first.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface PostExcelHandler {

    /**
     * 해당 파일이 Excel 확장자(.xlsx, .xls)인지 확인
     *
     * @param fileName 확인할 파일 이름 (uploadFile.getOriginalFilename())
     * @return Excel 파일이 맞을 경우 true 반환
     */
    boolean canParse(String fileName);

    /**
     * 해당 파일의 첫 번째 줄 데이터(Header)를 List로 반환
     *
     * @param inputStream 확인할 Excel 파일의 InputStream (uploadFile.getInputStream())
     * @return 첫 번째 줄 데이터 문자열 리스트
     */
    List<String> getHeaders(InputStream inputStream) throws IOException;

}
