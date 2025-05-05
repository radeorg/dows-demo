package org.dows.framework;

import lombok.SneakyThrows;
import org.dows.framework.doc.api.DocumentHandler;
import org.dows.framework.doc.processor.DocumentProcessor;
import org.dows.framework.doc.api.entity.DocumentTypeEnum;
import org.dows.framework.doc.api.entity.word.WordElementEnum;
import org.dows.framework.doc.api.entity.word.WordSelector;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class WordDemo {
    @SneakyThrows
    public static void testImportWord() {
        File file = ResourceUtils.getFile("classpath:import.docx");
        FileInputStream fin = new FileInputStream(file);

        DocumentHandler documentHandler = new DocumentProcessor();
        WordSelector ws = new WordSelector();
        WordSelector selector = ws.begin(WordElementEnum.PARAGRAPH)
                .and(WordElementEnum.PICTURE)
                .end();
        Object read = documentHandler.read(fin, DocumentTypeEnum.WORD, selector, null);
        System.out.println();
    }

    @SneakyThrows
    public static void testExportWord() {
        // 模板
        File file = ResourceUtils.getFile("classpath:exportTemplate.docx");
        FileInputStream fin = new FileInputStream(file);
        // 图片数组
        File pic1 = ResourceUtils.getFile("classpath:sunset.jpg");
        byte[] finalBytes1 = getPictureBytes(pic1);
        File pic2 = ResourceUtils.getFile("classpath:pavilion.jpg");
        byte[] finalBytes2 = getPictureBytes(pic2);
        // 输出位置自定义
        FileOutputStream fout = new FileOutputStream("D:\\" + System.currentTimeMillis() + ".docx");
        // 数据准备
        Thesis thesis = new Thesis();
        thesis.setTopic("滕王阁序");
        thesis.setTitle1("豫章故郡");
        thesis.setTitle2("披绣闼");
        thesis.setContext1("豫章故郡，洪都新府。星分翼轸，地接衡庐。襟三江而带五湖，控蛮荆而引瓯越。物华天宝，龙光射牛斗之墟；人杰地灵，徐孺下陈蕃之榻。雄州雾列，俊采星驰。台隍枕夷夏之交，宾主尽东南之美。都督阎公之雅望，棨戟遥临；宇文新州之懿范，襜帷暂驻。十旬休假，胜友如云；千里逢迎，高朋满座。腾蛟起凤，孟学士之词宗；紫电青霜，王将军之武库。家君作宰，路出名区；童子何知，躬逢胜饯。");
        thesis.setContext2("时维九月，序属三秋。潦水尽而寒潭清，烟光凝而暮山紫。俨骖騑于上路，访风景于崇阿；临帝子之长洲，得天人之旧馆。层峦耸翠，上出重霄；飞阁流丹，下临无地。鹤汀凫渚，穷岛屿之萦回；桂殿兰宫，即冈峦之体势。");
        thesis.setContext3("披绣闼，俯雕甍，山原旷其盈视，川泽纡其骇瞩。闾阎扑地，钟鸣鼎食之家；舸舰弥津，青雀黄龙之舳。云销雨霁，彩彻区明。落霞与孤鹜齐飞，秋水共长天一色。渔舟唱晚，响穷彭蠡之滨；雁阵惊寒，声断衡阳之浦。");
        thesis.setPicture1(finalBytes1);
        thesis.setPicture2(finalBytes2);

        DocumentHandler documentHandler = new DocumentProcessor();
        documentHandler.write(fin, fout, DocumentTypeEnum.WORD, thesis, null);
    }

    @SneakyThrows
    private static byte[] getPictureBytes(File file) {
        FileInputStream picFileIn = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int temp;
        while ((temp = picFileIn.read(bytes)) != -1) {
            outputStream.write(bytes, 0, temp);
        }
        return outputStream.toByteArray();
    }

    @SneakyThrows
    public static void main(String[] args) {
//        testImportWord();
        testExportWord();
    }
}
