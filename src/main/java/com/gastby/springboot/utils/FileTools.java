package com.gastby.springboot.utils;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.mapper.Part2Mapper;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileTools {
    // 自定义上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "D://uploads";

    @Autowired
    Part2Mapper part2Mapper;

    //MultipartFile上传文件
    public String getFileInfo(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
        String filePath = new String();
        String uploadPath = UPLOAD_DIRECTORY;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //判断文件是否为空
        if (!file.isEmpty()) {
            try {
                //文件的保存路径：request.getSession().getServletContext().getRealPath("/") +
                filePath = UPLOAD_DIRECTORY + File.separator + file.getOriginalFilename();
                //转存文件
                file.transferTo(new File(filePath));
                xls2String(new File(filePath)); // 将xls文件信息插入rfid2数据库的part表中；

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }//函数结束符

    /**
     * 读取xls文件内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public String xls2String(File file){
        List<Part2> list = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            Workbook rwb = Workbook.getWorkbook(fis);
            Sheet[] sheet = rwb.getSheets();
            for (int i = 0; i < sheet.length; i++) {
                Sheet rs = rwb.getSheet(i);
                for (int j = 0; j < rs.getRows(); j++) {
                    Cell[] cells = rs.getRow(j);
                    Part2 part2 = new Part2();
                    /*for(int k=0;k<cells.length;k++) {
                        sb.append(cells[k].getContents() + " ");
                    }*/
                    part2.setPid(cells[0].getContents());
                    part2.setName(cells[1].getContents());
                    part2.setType(cells[2].getContents());
                    part2.setInfo(cells[3].getContents());
                    part2.setProducer(cells[4].getContents());
                    part2.setProduceDate(cells[5].getContents());
                    //sb.append("\n");
                    list.add(part2);
                }
            }
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        for (Part2 part2 : list)
            part2Mapper.insertPart(part2);
        return null;
    }


}
