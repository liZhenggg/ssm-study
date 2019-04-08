package com.lzg.crud.test;


import com.github.pagehelper.PageInfo;
import com.lzg.crud.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * 使用Spirng测试模块提供的模拟请求功能，测试CRUD请求的正确性
 * Spring4测试的时候Servlet需要3.0以上的版本
 */
@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {

    //传入Spring的IOC
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求，获取结果
    MockMvc mockMvc;

    @Before
    public void initMock() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testEmpPages() throws Exception {
        //模拟请求，获取返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps")
                .param("pn", "5")).andReturn();
        //从请求域中获取PageInfo信息
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        if (pi == null) {
            System.out.println("分页数据为空！");
            return;
        }
        System.out.println("当前页码" + pi.getPageNum());
        System.out.println("总页数" + pi.getPages());
        System.out.println("总记录数" + pi.getTotal());
        System.out.println("在页面显示的连续页码：");
        int pagesNum[] = pi.getNavigatepageNums();
        for (int i : pagesNum) {
            System.out.print(" " + i);
        }
        System.out.println();

        List<Employee> employees = pi.getList();
        for (Employee e : employees) {
            System.out.println("ID:" + e.getdId() + ",name:" + e.getEmpName() +
                    ",部门：" + e.getDepartment().getDeptName());
        }


    }
}
