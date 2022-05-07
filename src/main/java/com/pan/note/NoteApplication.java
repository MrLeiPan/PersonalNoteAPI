package com.pan.note;

import com.pan.note.mychat.netty.WebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class NoteApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NoteApplication.class, args);

        //从容器中取出 netty服务启动类 启动线程
        WebSocketServer webSocketServer = applicationContext.getBean("webSocketServer", WebSocketServer.class);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(webSocketServer);
        service.shutdown();
        

    }

}
