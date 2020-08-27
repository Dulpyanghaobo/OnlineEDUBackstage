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
public class onlineEduCourseListAppliction {
    public static void main(String[] args) {
        int Port = 8078;
        int eurkuaPort = 8761;
        if(NetUtil.isUsableLocalPort(eurkuaPort)){
            System.err.printf("服务器%d端口未启动",eurkuaPort);
            System.exit(1);
        }
        if (null != args && 0!= args.length) {
            for(String arg :args){
                if(arg.startsWith("port=")){
                    String stringSub = StrUtil.subAfter(arg,"port=",true);
                    if(NumberUtil.isNumber(stringSub)){
                        Port = Convert.toInt(stringSub);
                    }
                }
            }
        }
        if(!NetUtil.isUsableLocalPort((Port))){
            System.err.printf("端口%d被占用",Port);
            System.exit(1);
        }
        new SpringApplicationBuilder(onlineEduCourseListAppliction.class).properties("server.port="+Port).run(args);
    }
}
