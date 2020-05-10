package com.music.rpc;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启dubbo
@EnableDubboConfiguration
@MapperScan("com.music.rpc.mapper")
public class MusicRpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicRpcApplication.class, args);
    }

}
