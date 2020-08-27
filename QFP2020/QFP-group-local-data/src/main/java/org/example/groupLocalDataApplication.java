package org.example;

import cn.hutool.core.net.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class groupLocalDataApplication {
    public static void main(String[] args) {
        int groupPort = 8061;
        if(!NetUtil.isUsableLocalPort(groupPort)){
            System.err.printf("端口号%d被占用",groupPort);
            System.exit(1);
        }
    new SpringApplicationBuilder(groupLocalDataApplication.class).properties("server.port="+groupPort).run(args);
    }
}
