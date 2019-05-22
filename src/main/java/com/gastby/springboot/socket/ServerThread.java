package com.gastby.springboot.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 自定义的处理服务端连接的线程类
 */
public class ServerThread extends Thread{
    //服务器线程处理
    //和本线程相关的socket
    Socket client =null;
    boolean flag = true;
    //
    public ServerThread(Socket socket){
        this.client = socket;
    }

    public void run(){
        //服务器处理代码
        try {
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(client.getInputStream()));
            int count = 1;

            while (flag) {
                String line = input.readLine();
                if(null != line) {
                    System.out.println("客户端说： " + line);
                    if ("exit".equals(line)) flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
