package org.example;


import cn.hutool.core.net.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IndexZuulApplication {
    public static void main(String[] args) {
        int zuulPort = 8071;
        if(!NetUtil.isUsableLocalPort(zuulPort)){
            System.err.printf("端口号%d已经被占用请更换地址",zuulPort);
            System.exit(1);
        }
    new SpringApplicationBuilder(IndexZuulApplication.class).properties("server.port="+zuulPort).run(args);
    }
}
