package com.gastby.springboot.com.gastby.insert;

import com.gastby.springboot.dao.DepartmentDao;
import com.gastby.springboot.mapper.Part2Mapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ThreadPoolExecutor;

public class TestController {

    @Autowired
    Part2Mapper partMapper;

    @Autowired
    ApplicationContext applicationContext;


}
