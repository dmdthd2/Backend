<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-logout practice, index</title>
</head>
<body>
    <h1>BGP Practice #500</h1>
    <h3>컨트롤러 서블릿, DAO, DTO클래스 활용</h3>
    <hr>
    <a href="<%=request.getContextPath()%>/login.jsp">로그인 페이지(스크립틀릿+HTML)</a><p>
    <hr>
    <h3>세션 정보</h3>
    <h3>주의 : 실무에서는 세션에 비밀번호를 저장하지 않음!!!</h3><p>
<%
    java.util.Enumeration<String> names = session.getAttributeNames();
    while (names.hasMoreElements()) {
        String name = names.nextElement();
        Object value = session.getAttribute(name);
        out.println(name + " : " + value + "<br>");
    }
%>
<hr>
<form method="post">
    <input type="submit" name="removeSessionBtn" value="세션제거">
</form>
<%
    if (request.getParameter("removeSessionBtn") != null) {
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
</body>
</html>