<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="bal" uri="/WEB-INF/tlds/BadAnswersListHandler.tld"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Quiz</title>
        <style>
            table {
                margin: 0 20px;
                border-spacing: 0;
                text-align: center;
                border: solid 1px #f5eabe;
            }
            .lightBlue { background-color: #edf8f7 }
            .white { background-color: #fff }
        </style>
    </head>
    <body>
        <h1>Quiz Statistics</h1>
        <p>Good answers: <c:out value="${qzGoodans}" /> of <c:out value="${qzNum}" /> questions </p>
        <!-- use JSTL elements to show badList -->
        <div id="badans" class="badans">
            <table id="tbStats" class="tbStats">
                <thead>
                    <tr>
                        <th>Question</th>
                        <th>Expected result</th>
                        <th>Your answer</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="qzQuestion" items="${qzManager.badList}" varStatus="iter">
                        <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                            <td>${qzQuestion.question}</td>
                            <td>${qzQuestion.expectedResult}</td>
                            <td>${qzQuestion.answer}</td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
        </div>
        <form name="frmQuiz" action="index.jsp" method="GET">
            <input type="submit" value=" New quiz " />
        </form>
    </body>
</html>
