package com.ojt.first.excel;

import java.io.File;
import java.util.List;

public interface PostHandler {

    /**
     * 해당 파일이 Excel 확장자(.xlsx, .xls)인지 확인
     *
     * @param uploadFile 확인할 Excel 파일
     * @return Excel 파일이 맞을 경우 true 반환
     */
    boolean canParse(File uploadFile);

    /**
     * 해당 파일의 첫 번째 줄 데이터(Header)를 List로 반환
     *
     * @param uploadFile 확인할 Excel 파일
     * @return 첫 번째 줄 데이터 문자열 리스트
     */
    List<String> getHeaders(File uploadFile);

}
