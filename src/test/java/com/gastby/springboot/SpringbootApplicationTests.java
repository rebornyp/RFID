package com.gastby.springboot;

import com.gastby.springboot.entities.Part;
import com.gastby.springboot.mapper.PartMapper;
import com.gastby.springboot.pojo.User;
import com.gastby.springboot.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Test
    public void con() {
        System.out.print("asdfsed");
        int i, j;
        Random random = new Random();
        i = random.nextInt(65536);
        j = random.nextInt(65536);
        Scanner scanner = new Scanner(System.in);
        while(scanner.next().length() != 0) {

            System.out.println("黄" + (char)i + (char)j);

        }
    }


}
