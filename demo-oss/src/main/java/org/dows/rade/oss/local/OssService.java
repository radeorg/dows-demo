package org.dows.rade.oss.local;

import lombok.RequiredArgsConstructor;
import org.dows.rade.oss.OssInfo;
import org.dows.rade.oss.tencent.TencentOssClient;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

@Component
@RequiredArgsConstructor
public class OssService {

     private final TencentOssClient tencentOssClient;

    //private final MinioOssClient minioOssClient;

    //    private final List<LocalOssClient> localOssClients;
    public void uoload() {
        //OssInfo info = tencentOssClient.upLoad(new File(System.getProperty("user.dir") + File.separator + "1.png"), "2.png", false);
        OssInfo info = tencentOssClient.upLoad(new File(System.getProperty("user.dir") + File.separator + "1.png"), "2.png", true);


    }

    public void download() throws FileNotFoundException {
        //tencentOssClient.downLoadCheckPoint(System.getProperty("user.dir") + "dows-demo" + File.separator + "demo-oss" + File.separator + "1.png", "2.png");
        tencentOssClient.downLoadCheckPoint(System.getProperty("user.dir")  + File.separator + "3.png", "2.png");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
