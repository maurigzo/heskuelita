package java.com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.core.beans.User;
import java.com.capgemini.heskuelita.data.db.DBConnectionManager;
import java.com.capgemini.heskuelita.service.ISecurityService;
import java.com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet{

    private ISecurityService securityService = new SecurityServiceImpl();

    public LoginServlet() {

        super();
    }

    @Override
    public void init() throws ServletException {

        ServletContext context = config.getServletContext();

        DBConnectionManager manager =
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User ();
        user.setUserName(req.getParameter("user"));
        user.setPassword(req.getParameter("pw"));

        try{
            this.securityService.login(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("home.jsp");
        }
        catch (Exception e){
            resp.sendRedirect("err.jsp");
        }
    }

}
