<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Quiz</title>
    </head>
    <body>
        <h1>Math Quiz - Multiplication</h1><br/>
        <p>You will be asked a number of questions. Each question contains two randomly chosen positive integers. You will be asked to return their product.</p><br/>
        <form name="frmParams" action="newquiz" method="POST">
            Number of questions: <input type="text" pattern="\d*" name="qzNum" /><br/>
            Range: 1 to <input type="text" pattern="\d*" name="qzRng" /><br/>
            <input type="submit" value=" Start quiz " />
        </form>
    </body>
</html>
