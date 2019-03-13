
package com.capgemini.heskuelita.data.impl;


import com.capgemini.heskuelita.entity.Human;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IHumanDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HumanDaoJDBC implements IHumanDao {


    private Connection conn;

    public HumanDaoJDBC (Connection conn) {

        super ();

        this.conn = conn;
    }

    @Override
    public Human login(String user_name, String password) {

        Human us = null;
        try {

            Statement stm = this.conn.createStatement ();

            ResultSet resultSet;
            resultSet = stm.executeQuery ("SELECT * from public.Human WHERE user_name='" + user_name + "' AND password='" + password + "'");
            while (resultSet.next ()) {

                us = new Human ();
                us.setEmail (resultSet.getString ("us_email"));
                us.setUser_name (user_name);
                break;
            }

        } catch (Exception e) {

            throw new DataException (e);
        }

        if (us == null) {
            throw new DataException ("Usuario " + user_name + " desconocido");
        }

        return us;
    }

    @Override
    public Human register(String user_name, String password, String email){

        Human us;
        try{
            Statement stm = this.conn.createStatement();

            stm.executeQuery("INSERT INTO public.Human (user_name, password, email) VALUES ('"+user_name+"','"+password+"','"+email+"')");

            us = new Human ();
            us.setEmail (email);
            us.setUser_name (user_name);

        } catch(Exception e){

            throw new DataException(e);
        }

        return us;
    }
}