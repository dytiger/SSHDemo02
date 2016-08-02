<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>诗歌修改</title>
</head>
<body>
<form action="update.do" method="post">
    <div>
        <label>标题</label><input type="text" name="title" value="${vo.title}" />
    </div>
    <div>
        <label>作者</label><input type="text" name="author" value="${vo.author}" />
    </div>
    <div>
        <label>朝代</label><input type="text" name="dynasty" list="dynasty-list" value="${vo.dynasty}" />
    </div>
    <div>
        <textarea name="poemText" cols="80" rows="10">${vo.poemText}</textarea>
    </div>
    <div>
        <input type="hidden" name="id" value="${vo.id}" />
        <button>保存</button>
    </div>
    <datalist id="dynasty-list">
        <option>先秦</option>
        <option>汉</option>
        <option>魏晋</option>
        <option>南北朝</option>
        <option>隋朝</option>
        <option>唐朝</option>
        <option>北宋</option>
        <option>南宋</option>
        <option>元朝</option>
        <option>明朝</option>
        <option>清朝</option>
        <option>当代</option>
        <option>现代</option>
    </datalist>
</form>
</body>
</html>
