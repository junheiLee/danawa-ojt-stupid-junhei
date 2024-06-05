package com.ojt.first.dto.response;

import lombok.Builder;
import lombok.ToString;

import java.util.List;

@ToString
public class SaveExcelResponse extends BaseResponse {

    private final int successCount;
    private final int failedCount;
    private final List<Object> falidList;

    @Builder
    public SaveExcelResponse(String code, String message,
                             int successCount, int failedCount,
                             List<Object> falidList) {
        super(code, message);
        this.successCount = successCount;
        this.failedCount = failedCount;
        this.falidList = falidList;
    }
}
