package com.gastby.springboot;

import com.gastby.springboot.entities.InsertRecord;
import com.gastby.springboot.entities.Part;
import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.entities.Tag;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.PartMapper;
import com.gastby.springboot.mapper.TagMapper;
import com.gastby.springboot.utils.Utils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    TagMapper tagMapper;

    @Autowired
    Part2Mapper partMapper;

    @Test
    public void con() {
        File file = new File("C:\\Users\\Gastby\\Desktop\\tags.xls");
        List<Tag> list = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        try{
            FileInputStream fis = new FileInputStream(file);
            Workbook rwb = Workbook.getWorkbook(fis);
            Sheet[] sheet = rwb.getSheets();
            for (int i = 0; i < sheet.length; i++) {
                Sheet rs = rwb.getSheet(i);
                for (int j = 1; j < rs.getRows(); j++) {
                    Cell[] cells = rs.getRow(j);
                    Tag tag = new Tag();

                    tag.setTid(cells[0].getContents());
                    tag.setType(cells[1].getContents());
                    Date date = new Date();
                    tag.setBirthDate(dateFormat.format(date));
                    list.add(tag);
                }
            }
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        for (Tag tag : list)
            tagMapper.insertPart(tag);

    }


    @Test
    public void testController() {
        String pid = "ERLYS2Z910";
        String tid = "sd";
        partMapper.updateTagInfo(1, tid);
        tagMapper.updatePartInfo(1, pid);
    }

}
