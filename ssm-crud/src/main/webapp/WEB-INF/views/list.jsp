<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>员工列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%-- web资源文件路径：
        不以/开始的相对路径，查找资源时是以当前资源的路径为基准，这种方式容易出错；
        以/开始的相对路径，查找资源时是以服务器根路径为基准(例:http://localhost:8080)，
        后面需要加上项目名(http://localhost:8080/crud)。
    --%>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- jQuery -->
    <script src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <!-- bootstrap.css -->
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap.js -->
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%-- 标题 --%>
    <div class="row">
        <h1>SSM-CRUD</h1>
    </div>
    <%-- 按钮 --%>
    <div class="row" style="padding:5px">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                新增
            </button>
            <button type="button" class="btn btn-danger">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                删除
            </button>
        </div>
    </div>

    <%-- 表格数据 --%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>部门</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list }" var="emp">
                    <tr>
                        <td>${emp.empId }</td>
                        <td>${emp.empName }</td>
                        <td>${emp.gender=="M"?"男":"女" }</td>
                        <td>${emp.email }</td>
                        <td>${emp.department.deptName }</td>
                        <td>
                            <button type="button" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button type="button" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <%-- 分页信息 --%>
    <div class="row">
        <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页，总共 ${pageInfo.pages} 页，共 ${pageInfo.total} 条记录
        </div>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/emps?pn=1" aria-label="Previous">
                                <span aria-hidden="true">首页</span>
                            </a>
                        </li>
                        <li>
                            <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                        <c:if test="${page_num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_num}</a></li>
                        </c:if>
                        <c:if test="${page_num != pageInfo.pageNum}">
                            <li><a href="${APP_PATH}/emps?pn=${page_num}">${page_num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <li>
                            <a href="${APP_PATH}/emps?pn=${pageInfo.pages}" aria-label="Previous">
                                <span aria-hidden="true">末页</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>

</body>
</html>
