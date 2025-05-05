/*
package org.dows.framework;

import lombok.SneakyThrows;
import org.dows.framework.doc.api.DocumentHandler;
import org.dows.framework.doc.processor.DocumentProcessor;
import org.dows.framework.doc.api.entity.DocumentTypeEnum;
import org.dows.framework.doc.api.entity.excel.ExcelLocator;
import org.dows.framework.doc.api.entity.excel.ExcelSelector;
import org.dows.framework.doc.api.entity.excel.Point;
import org.dows.framework.doc.api.entity.excel.SheetRange;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelDemo {

    @SneakyThrows
    public static void testImportExcel () {
        File file = ResourceUtils.getFile("classpath:import.xlsx");
        FileInputStream fin = new FileInputStream(file);

        // selector
        ExcelSelector selector = new ExcelSelector();
        List<SheetRange> sheetRanges = new ArrayList<>();
        SheetRange sheetRange1 = new SheetRange();
        // index 为0的表
        sheetRange1.setSheetIndex(0);
        // 第三行到第七行，第一列到第十一列
        sheetRange1.setBeginPoint(new Point(1, 3));
        sheetRange1.setEndPoint(new Point(11, 6));
        sheetRanges.add(sheetRange1);
        selector.setSheetRanges(sheetRanges);

//        DocumentHandler documentHandler = (DocumentHandler) SpringUtil.getBean("DocumentHandler");
        AnnotationConfigApplicationContext beans = new AnnotationConfigApplicationContext(DocumentProcessor.class);
        DocumentHandler documentHandler = (DocumentHandler) beans.getBean("documentProcessor");
        Object readResult = documentHandler.read(fin, DocumentTypeEnum.EXCEL, selector, Grade.class);
        System.out.println();
    }

    @SneakyThrows
    public static void testExportExcel() {
        File file = ResourceUtils.getFile("classpath:exportTemplate.xlsx");
        FileInputStream fin = new FileInputStream(file);
        FileOutputStream fout = new FileOutputStream("D:\\export-" + System.currentTimeMillis() + ".xlsx");

        Grade grade = new Grade();
        grade.setName("小雪");
        grade.setChinese(99.0);
        grade.setMath(98.0);
        grade.setEnglish(97.0);
        grade.setPhysics(96.0);
        grade.setChemistry(95.0);
        grade.setPolitics(94.0);
        grade.setHistory(93.0);
        grade.setGeography(92.0);
        grade.setSports(100.0);
        grade.setMusic(91.0);
        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(grade);

        ExcelLocator excelLocator = new ExcelLocator();
        List<SheetRange> sheetRanges = new ArrayList<>();
        SheetRange sheetRange = new SheetRange();
        sheetRanges.add(sheetRange);
        excelLocator.setSheetRanges(sheetRanges);
        // 起始写位置
        sheetRange.setSheetIndex(0);
        sheetRange.setBeginPoint(new Point(1, 5));

        DocumentHandler documentHandler = (DocumentHandler) SpringUtil.getBean("DocumentHandler");
        documentHandler.write(fin, fout, DocumentTypeEnum.EXCEL, grades, excelLocator);
    }

    @SneakyThrows
    public static void main(String[] args) {
//        testExportExcel();
        testImportExcel();
    }
}
*/
