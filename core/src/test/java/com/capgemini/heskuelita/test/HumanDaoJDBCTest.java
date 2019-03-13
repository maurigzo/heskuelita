package com.capgemini.heskuelita.test;

import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.HumanDaoJDBC;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HumanDaoJDBCTest {

    private Connection conn;
    private ISecurityService securityService;

    @Before
    public void init (ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();
        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");
        try {

            this.securityService = new SecurityServiceImpl(new HumanDaoJDBC(manager.getConnection()));
        } catch (Exception e) {

            throw new ServletException(e);
        }


    }

    @Test
    @DisplayName("Create New Records")
    private void insertTest() throws java.sql.SQLException{

        ResultSet resultSet;

            Statement stm = this.conn.createStatement ();


            resultSet = stm.executeQuery ("INSERT INTO public.Human (user_name, password, email) VALUES ('juan',1234,'juan@juan')");
            System.out.println(stm.getGeneratedKeys());


        Assertions.assertNotNull(resultSet);

    }

    @Test
    private void loginTest(){



    }

}
