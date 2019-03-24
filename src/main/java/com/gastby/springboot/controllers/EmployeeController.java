package com.gastby.springboot.controllers;

import com.gastby.springboot.dao.EmployeeDao;
import com.gastby.springboot.entities.Employee;
import com.gastby.springboot.entities.Part;
import com.gastby.springboot.mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao empDao;

    @Autowired
    PartMapper partMapper;

    @GetMapping("/list")
    public String queryEmps(Model model) {
        Collection<Employee> all = empDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    @GetMapping("/log")
    public String queryLog(Model model) {
//        Collection<Employee> all = empDao.getAll();
//        model.addAttribute("emps", all);
        return "log/info";
    }

    @GetMapping("/part")
    public String queryParts(Model model) {
        List<Part> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "part/partList";
    }



    @GetMapping("/dataAnalyze")
    public String once() {
        return "success";
    }


    @GetMapping("/emp")
    public String addEmp() {
        return "emp/add";
    }

}
