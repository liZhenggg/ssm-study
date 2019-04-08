package com.lzg.crud.test;


import com.lzg.crud.bean.Department;
import com.lzg.crud.bean.Employee;
import com.lzg.crud.dao.DepartmentMapper;
import com.lzg.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * <p>
 * Spirng项目可以使用Sping的单元测试，可以自动注入我们需要的组件:
 * 1.导入 SpingTest 模块
 * 2.使用注解 @ContextConfiguration 指定Spring 配置文件位置
 *
 * @RunWith 来指定Junit运行单元测试的运行器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void testCRUD() {
/*
//        不用spring注解获取bean的写法：
//        1.创建SpirngIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        2.从容器中获取bean
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        System.out.println(bean);*/

        // 1.测试插入部门数据
//        departmentMapper.insertSelective(new Department(null, "研发部"));
//        departmentMapper.insertSelective(new Department(null, "测试部"));
//        departmentMapper.insertSelective(new Department(null, "人事部"));
//        departmentMapper.insertSelective(new Department(null, "项目部"));
//
//        // 1.测试插入员工数据
//        employeeMapper.insertSelective(new Employee(null, "Jack Ma", "M", "JackMa@lzg.com", 1));
//        employeeMapper.insertSelective(new Employee(null, "Lily xu", "F", "LilyXu@lzg.com", 1));
//        employeeMapper.insertSelective(new Employee(null, "Maria Wang", "M", "MariaWang@lzg.com", 2));

//        //测试批量插入员工数据
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i < 1000; i++) {
//            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//            mapper.insertSelective(new Employee(null, uid, "M", uid + "@lzg.com", 1));
//        }
//        System.out.println("批量添加完成！");

//        //测试批量插入部门数据
//        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//        for (int i = 0; i < 10; i++) {
//            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//            mapper.insertSelective(new Department(null, "测试部门" + uid));
//        }
//        System.out.println("批量添加完成！");

        //测试修改
//        employeeMapper.updateByPrimaryKey(new Employee(1, "Alice", "F", "Alice@lzg.com", 3));
//        departmentMapper.updateByPrimaryKey(new Department(1, "开发部"));

        //测试删除
//        employeeMapper.deleteByPrimaryKey(3);
//        departmentMapper.deleteByPrimaryKey(4);


    }
}
