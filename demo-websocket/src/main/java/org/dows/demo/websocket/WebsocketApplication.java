package org.dows.demo.websocket;

import org.dows.framework.websocket.annotation.EnableWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWebSocket(scanBasePackages = "org.dows.demo.websocket.endpoint")
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

}
