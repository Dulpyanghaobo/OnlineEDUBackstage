package org.example;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class collectionDataApplication {
    public static void main(String[] args) {
        int port = 8090;
        int eurekaServerPort = 8761;
        if (NetUtil.isUsableLocalPort(eurekaServerPort)){
            System.err.printf("服务器%d端口未开启",eurekaServerPort);
//            退出
            System.exit(1);
        }
        if(null != args && 0!= args.length){
            for (String arg : args){
                if(arg.startsWith("port=")){
                    String stringSub = StrUtil.subAfter(arg,"port=",true);
                    if(NumberUtil.isNumber(stringSub)){
                        port = Convert.toInt(stringSub);
                    }
                }
            }
        }
        if(!NetUtil.isUsableLocalPort((port))){
            System.err.printf("端口%d被占用",port);
            System.exit(1);
        }
        new SpringApplicationBuilder(collectionDataApplication.class).properties("server.port="+port).run(args);
    }
}
