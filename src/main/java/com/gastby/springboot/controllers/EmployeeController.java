package com.gastby.springboot.controllers;

import com.gastby.springboot.dao.EmployeeDao;
import com.gastby.springboot.entities.Employee;
import com.gastby.springboot.entities.Part;
import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.entities.Tag;
import com.gastby.springboot.mapper.Part2Mapper;
import com.gastby.springboot.mapper.TagMapper;
import com.gastby.springboot.mapper.UserMapper;
import com.gastby.springboot.pojo.User;
import com.gastby.springboot.utils.FileTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    Part2Mapper partMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    FileTools fileTools;

    private String history;



    @GetMapping("/log")
    public String queryLog(Model model) {
//        Collection<Employee> all = empDao.getAll();
//        model.addAttribute("emps", all);
        return "log/info";
    }

    @GetMapping("/part")
    public String queryParts(Model model) {
        List<Part2> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "part/partList";
    }




    @GetMapping("/dataAnalyze")
    public String dataController() {

        return "success";

    }

    @GetMapping("/file")
    public String fileUpload(Model model) {
        model.addAttribute("msg", "暂无插入记录");
        return "file/uploadPage";
    }

    //    上传文件
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(@RequestParam(value = "fileinfo", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, Model model) {
        //上传文件的路径
        history = fileTools.getFileInfo(request, response, file);
        //System.out.println(records);
    }

    @RequestMapping("/refresh/local")
    public String localRefresh(Model model) {
        if (null != history)
            model.addAttribute("msg", history);
        else model.addAttribute("msg", "暂无插入记录");
        return "file/uploadPage::table_refresh";
    }

    @GetMapping("/partPosition")
    public String showPartPosition() {

        return "positions/part";
    }

    @GetMapping("/transport")
    public String showMap() {

        return "transport/map";
    }

    @GetMapping("/storage")
    public String showWareHouse(Model model) {
        List<Part2> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "storage/index";
    }




}
