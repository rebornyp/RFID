package com.gastby.springboot.com.gastby.insert;

import com.gastby.springboot.dao.DepartmentDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

public class TestController {

    @Autowired
    private DepartmentDao department;
    @Autowired
    private DepartmentDao department1;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testController() {
//        departmentDao = new DepartmentDao();
        ThreadPoolExecutor threadPoolExecutor;
        System.out.println(department.departments);
        System.out.println(department1.departments);

        System.out.println(DepartmentDao.departments);
        try {
            Class.forName("kd");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
