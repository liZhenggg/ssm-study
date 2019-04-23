package com.lzg.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lzg.crud.bean.Employee;
import com.lzg.crud.service.EmployeeService;
import com.lzg.crud.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired(required = false)
    EmployeeService employeeService;

    /**
     * 返回分页Json数据
     * 使用 @ResponseBody 注解将结果转为Json字符串，需要引入 Jackson 依赖
     *
     * @param pn
     * @return
     */
    @RequestMapping("/empsWithJson")
    @ResponseBody
    public ResultMsg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //引入PageHelper分页插件
        PageHelper.startPage(pn, 10);
        //后面紧跟的查询就是分页查询
        List<Employee> emps = employeeService.getAll();
        //使用PageInfo获取包装后的查询结果
        PageInfo pageInfo = new PageInfo(emps, 5);
        return ResultMsg.success().add("pageInfo", pageInfo);
    }

    /**
     * 分页查询员工列表
     *
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        //引入PageHelper分页插件
        PageHelper.startPage(pn, 10);
        //后面紧跟的查询就是分页查询
        List<Employee> emps = employeeService.getAll();
        //使用PageInfo获取包装后的查询结果
        PageInfo pageInfo = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }

    @RequestMapping("/search")
    @ResponseBody
    public ResultMsg getSearch(@RequestParam String keywords) {
        Object result = null;

        return ResultMsg.success().add("result", result);
    }
}
