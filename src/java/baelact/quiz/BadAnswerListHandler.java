package baelact.quiz;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class BadAnswerListHandler extends TagSupport {
    public BadAnswerListHandler(){}
    
    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        HttpSession session = request.getSession();
        
        QuizManager qzManager = (QuizManager)session.getAttribute("qzManager");
        
        ArrayList<QuizAnswer> blist = qzManager.getBadList();
        String ret;
        if(blist == null || blist.size() == 0){
            ret = "All questions properly answered!";
        } else {
            ret = "<table border=1><thead><tr><td>Question</td><td>Expected result</td>"
                    + "<td>Your answer</td></tr></thead><tbody>";
            for(QuizAnswer a : blist){
                ret += ("<tr><td>"+a.getQuestion()+"</td>"
                        + "<td>"+a.getExpectedResult()+"</td>"
                        + "<td>"+a.getAnswer()+"</td></tr>");
            }
            ret += ("</tbody></table>");
        }
        try{
            pageContext.getOut().println(ret);
        } catch (IOException ex){
            throw new JspException("IOException thrown!!!", ex);
        }
        return SKIP_BODY;
    }
}