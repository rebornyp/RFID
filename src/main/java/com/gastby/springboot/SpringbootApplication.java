package com.gastby.springboot;

import com.gastby.springboot.socket.ServerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootApplication.class, args);

        //服务器代码
        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            Socket socket = null;
            int count =0;//记录客户端的数量
            while(true){
                socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端连接的数量："+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
