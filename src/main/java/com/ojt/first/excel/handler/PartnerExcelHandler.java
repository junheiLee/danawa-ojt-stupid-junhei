package com.ojt.first.excel.handler;

import java.io.File;
import java.util.List;

public class PartnerExcelHandler implements ExcelHandler{

    @Override
    public <T> List<T> toObjectList(File file) {
        return List.of();
    }
}
