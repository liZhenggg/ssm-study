
SSM:Spring + SpringMVC + mybatis

Spring作为一个轻量级的框架，有很多的拓展功能，最主要的我们一般项目使用的就是IOC和AOP。
Spring实现的一个Web层，相当于Struts的框架，但是比Struts更加灵活和强大。
是一个持久层的框架，在使用上相比Hibernate更加灵活，可以控制sql的编写，使用 XML或注解进行相关的配置。

Spring
Spring就像是整个项目中装配bean的大工厂，在配置文件中可以指定使用特定的参数去调用实体类的构造方法来实例化对象。
Spring的核心思想是IoC（控制反转），即不再需要程序员去显式地'new'一个对象，而是让Spring框架帮你来完成这一切。

SpringMVC
SpringMVC在项目中拦截用户请求，它的核心Servlet即DispatcherServlet承担中介或是前台这样的职责，将用户请求通过HandlerMapping去匹配Controller，Controller就是具体对应请求所执行的操作。SpringMVC相当于SSH框架中struts。

mybatis
mybatis是对jdbc的封装，它让数据库底层操作变的透明。mybatis的操作都是围绕一个sqlSessionFactory实例展开的。mybatis通过配置文件关联到各实体类的Mapper文件，Mapper文件中配置了每个类对数据库所需进行的sql语句映射。在每次与数据库交互时，通过sqlSessionFactory拿到一个sqlSession，再执行sql命令。



基础框架搭建：
1.创建Maven工程
2.引入项目依赖jar包
	spring,springMVC,mybatis,数据库连接池，驱动包，其他（jstl,servlet-api,junit,spring-test,mybatis-generator-core?...）
	在pom.xml文件中添加相应依赖，可在Maven中央仓库查询依赖版本https://mvnrepository.com/

3.引入前端框架--bootstrap和jquery	
4.编写SSM框架关键配置文件(web.xml,spring,springmvc,mybatis)
	web项目核心配置文件 -- web.xml
	Spring核心配置文件 -- applicationContext.xml
		数据库配置文件 -- dbconfig.xml
		MyBatis配置文件 -- mybatis-config.xml
	SpringMVC前端控制器 -- dispatcherServlet-servlet.xml
	
	创建数据库表结构
	使用mybatis的逆向工程生成对应的bean和mapper（在根目录下配置mbg.xml,参考http://www.mybatis.org/generator/quickstart.html），根据需要修改自动生成的bean和mapper文件内容。
5.测试mapper


添加分页支持：
pom.xml引入 PageHelper 插件,