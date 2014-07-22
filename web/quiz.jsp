<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Quiz</title>
    </head>
    <body>
        <h1>Question #<c:out value="${qzIdx}" /> / <c:out value="${qzNum}" /> </h1>
        <p>What is <c:out value="${num1}" /> times <c:out value="${num2}" /> ?</p>
            <form name="frmQuiz" action="quiz" method="POST">
                Answer: <input type="text" pattern="\d*" name="qzAnswer" /><br/>
                <input type="hidden" name="num1" value="<c:out value="${num1}" />">
                <input type="hidden" name="num2" value="<c:out value="${num2}" />">
                <input type="submit" value=" Submit " />
            </form>
    </body>
</html>
