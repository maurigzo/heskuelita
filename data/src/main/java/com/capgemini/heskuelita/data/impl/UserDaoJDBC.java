
package com.capgemini.heskuelita.data.impl;


import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDaoJDBC implements IUserDao {


    private Connection conn;

    public UserDaoJDBC (Connection conn) {

        super ();

        this.conn = conn;
    }

    @Override
    public User login(String userName, String password) {

        User us = null;
        try {

            Statement stm = this.conn.createStatement ();

          ResultSet resultSet;
            resultSet = stm.executeQuery ("SELECT * from public.user WHERE \"us_userName\"='" + userName + "' AND us_password='" + password + "'");
            while (resultSet.next ()) {

                us = new User ();
                us.setEmail (resultSet.getString ("us_email"));
                us.setUserName (userName);
                break;
            }

        } catch (Exception e) {

            throw new DataException (e);
        }

        if (us == null) {
            throw new DataException ("Usuario " + userName + " desconocido");
        }

        return us;
    }

    @Override
    public User register(String userName, String password, String email){

        User us;
        try{
            Statement stm = this.conn.createStatement();

            stm.executeQuery("INSERT INTO public.user (us_\"userName\", us_password, us_email) VALUES ('"+userName+"','"+password+"','"+email+"')");

            us = new User ();
            us.setEmail (email);
            us.setUserName (userName);

        } catch(Exception e){

            throw new DataException(e);
        }

        return us;
    }
}