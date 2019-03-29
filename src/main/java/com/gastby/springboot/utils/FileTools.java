package com.gastby.springboot.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

public class FileTools {
    // 自定义上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "D://uploads";

    //MultipartFile上传文件
    public static String getFileInfo(HttpServletRequest request, HttpServletResponse response, MultipartFile file) {
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
                System.out.println(file.getName());
                System.out.println(file.getSize());
                System.out.println(filePath);
                //转存文件
                file.transferTo(new File(filePath));
                System.out.println(xls2String(new File(filePath)));

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
    public static String xls2String(File file){
        String result = "";
        try{
            FileInputStream fis = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            Workbook rwb = Workbook.getWorkbook(fis);
            Sheet[] sheet = rwb.getSheets();
            for (int i = 0; i < sheet.length; i++) {
                Sheet rs = rwb.getSheet(i);
                for (int j = 0; j < rs.getRows(); j++) {
                    Cell[] cells = rs.getRow(j);
                    for(int k=0;k<cells.length;k++)
                        sb.append(cells[k].getContents());
                }
            }
            fis.close();
            result += sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
