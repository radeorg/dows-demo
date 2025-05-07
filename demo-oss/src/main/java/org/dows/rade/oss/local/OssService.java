package org.dows.rade.oss.local;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.dows.rade.oss.OssInfo;
import org.dows.rade.oss.tencent.TencentOssClient;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class OssService {

     private final TencentOssClient tencentOssClient;

    //private final MinioOssClient minioOssClient;

    //    private final List<LocalOssClient> localOssClients;
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public void uoload() {
        //OssInfo info = tencentOssClient.upLoad(new File(System.getProperty("user.dir") + File.separator + "1.png"), "2.png", false);

        Date date = new Date();
        String resumeOss = String.format("%s%s", date.getYear(), date.getMonth());
        System.out.println(JSONUtil.toJsonStr(resumeOss));
        Long resumeFileId = System.currentTimeMillis();
        OssInfo info = tencentOssClient.upLoad(new File(System.getProperty("user.dir") + File.separator + "1.png"), String.format("%s.pdf", formatDate(new Date(), "YYYYMM") + File.separator + resumeFileId), true);

        System.out.println(JSONUtil.toJsonStr(info));
    }

    public void download() throws FileNotFoundException {
        //tencentOssClient.downLoadCheckPoint(System.getProperty("user.dir") + "dows-demo" + File.separator + "demo-oss" + File.separator + "1.png", "2.png");
        tencentOssClient.downLoadCheckPoint(System.getProperty("user.dir")  + File.separator + "3.png", "2.png");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
