package com.gastby.springboot.controllers;

import com.gastby.springboot.dao.EmployeeDao;
import com.gastby.springboot.entities.Employee;
import com.gastby.springboot.entities.Part;
import com.gastby.springboot.mapper.PartMapper;
import com.gastby.springboot.utils.FileTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao empDao;

    @Autowired
    PartMapper partMapper;

    @Autowired
    FileTools fileTools;


    @GetMapping("/userList")
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
    public String dataController() {

        return "success";

    }

    @GetMapping("/file")
    public String fileUpload(Model model) {
        List<Part> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "file/uploadPage";
    }

    //    上传文件
    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public void uploadFile(@RequestParam(value = "fileinfo", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        //上传文件的路径
        String path = fileTools.getFileInfo(request, response, file);
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
        List<Part> parts = partMapper.queryAllParts();
        model.addAttribute("parts", parts);
        return "storage/index";
    }



    @GetMapping("/emp")
    public String addEmp() {
        return "emp/add";
    }

}
