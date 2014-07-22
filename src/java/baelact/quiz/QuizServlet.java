package baelact.quiz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fwdTo;
        String userPath = request.getServletPath();
        HttpSession session = request.getSession(true);
        QuizManager qzManager = (QuizManager)session.getAttribute("qzManager");
        //new quiz has to be created
        if(userPath.equals("/newquiz")){
            int qzNum = new Integer(request.getParameter("qzNum")).intValue();
            int qzRng = new Integer(request.getParameter("qzRng")).intValue();
            
            qzManager = new QuizManager(qzNum, qzRng);
            session.setAttribute("qzManager", qzManager);
            
            Integer qzIdx = new Integer(1);
            session.setAttribute("qzIdx", qzIdx);
            
            int[] qz = qzManager.getQuiz();
            
            fwdTo = "quiz.jsp";
            request.setAttribute("qzNum",qzNum);
            request.setAttribute("num1",new Integer(qz[0]));
            request.setAttribute("num2",new Integer(qz[1]));
            
        } else {
            Integer qzIdx = (Integer)session.getAttribute("qzIdx");
            Integer num1 = new Integer(request.getParameter("num1")).intValue();
            Integer num2 = new Integer(request.getParameter("num2")).intValue();
            Integer answer = new Integer(request.getParameter("qzAnswer")).intValue();
            int qzNum = qzManager.getQuizNumber();
            //evaluate answer
            qzManager.evaluateAnswer(new int[]{num1,num2}, answer);
            //quiz already running, ask new question and increase counter
            if(qzIdx < qzNum){
                qzIdx = new Integer(qzIdx.intValue() + 1);
                session.setAttribute("qzIdx", qzIdx);
                
                int[] qz = qzManager.getQuiz();
                
                fwdTo = "quiz.jsp";
                request.setAttribute("qzNum",qzNum);
                request.setAttribute("num1",new Integer(qz[0]));
                request.setAttribute("num2",new Integer(qz[1]));
            } else {
                //quiz finished, show statistics
                                
                fwdTo = "stats.jsp";
                request.setAttribute("qzNum",qzNum);
                request.setAttribute("qzGoodans",new Integer(qzManager.getGoodAns()));
            }
        }
        
        //forward request to the target JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher(fwdTo);
        dispatcher.forward(request, response);
    }    

}
