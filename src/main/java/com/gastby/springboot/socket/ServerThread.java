package com.gastby.springboot.socket;

import com.gastby.springboot.entities.MonitorRecord;
import com.gastby.springboot.mapper.MonitorRecordMapper;
import com.gastby.springboot.utils.SpringApplicationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义的处理服务端连接的线程类
 */
public class ServerThread extends Thread{

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");


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
                    if (line.indexOf("EPC") != -1) {
                        int l = line.indexOf("EPC") + 4;
                        int r = l + 25;
                        String epc = line.substring(l, r);
                        MonitorRecord monitorRecord = new MonitorRecord();
                        monitorRecord.setReaderId("2018AWD7588");
                        monitorRecord.setTagId(epc);
                        monitorRecord.setInfo("识别");
                        monitorRecord.setWorker("W-001");
                        String time = simpleDateFormat.format(new Date());
                        monitorRecord.setStartTime(time);
                        monitorRecord.setEndTime(time);
                        System.out.println(monitorRecord);

                        MonitorRecordMapper monitorRecordMapper = (MonitorRecordMapper) SpringApplicationContextHolder.getSpringBean("monitorRecordMapper");
                        System.out.println(monitorRecordMapper == null);
                        monitorRecordMapper.insertPart(monitorRecord);
                    }
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
