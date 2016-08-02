<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>诗歌列表</title>
    <script>
        function sureDel(){
            return confirm("是否确定删除数据？");
        }
    </script>
</head>
<body>
<nav>
<a href="save.html">添加诗词</a>
</nav>
<form action="list.do" method="post">
    <div>
    <label>标题</label><input name="title" value="${qo.title}" />
    <label>作者</label><input name="author" value="${qo.author}" />
    <label>朝代</label><input name="dynasty" value="${qo.dynasty}" />
    <label>内容</label><input name="poemKeyword" value="${qo.poemKeyword}" />
    <button>查询</button></div>
</form>
<table>
    <tr>
        <th>标题</th>
        <th>作者</th>
        <th>朝代</th>
        <th>内容</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
<c:forEach items="${data}" var="p">
    <tr>
        <td>${p.title}</td>
        <td>${p.author}</td>
        <td>${p.dynasty}</td>
        <td>${p.poemText}</td>
        <td>
            <%--<fmt:formatDate value="${p.createTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/>--%>
            ${p.createTimeStr}
        </td>
        <td>
            <a href="delete.do?id=${p.id}" onclick="return sureDel();">删除</a>
            <a href="gotoUpdate.do?id=${p.id}">修改</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
