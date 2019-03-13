
package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.HumanDaoJDBC;
import com.capgemini.heskuelita.entity.Human;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet ("/register")
public class RegisterServlet extends HttpServlet {
/*

    private ISecurityService securityService;


    public RegisterServlet () {

        super ();
    }

    @Override
    public void init (ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();

        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");

        try {

            this.securityService = new SecurityServiceImpl (new HumanDaoJDBC (manager.getConnection()));
        } catch (Exception e) {

            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Human human = new Human ();
        human.setUser_name (req.getParameter ("user"));
        human.setPassword (req.getParameter ("pwd"));
        human.setEmail (req.getParameter ("email"));

        try {

            this.securityService.register (human);

            HttpSession session = req.getSession ();
            session.setAttribute ("user", human);

            resp.sendRedirect ("home.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect ("err.jsp");
        }
    }
*/
}