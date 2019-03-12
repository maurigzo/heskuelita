package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.entity.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;


public class UserDaoHibernate implements IUserDao {

    Session session= null;
    private Connection conn;


    public UserDaoHibernate () {
        super ();
    }

    @Override
    public Account login(String userName, String password) {
        List <Account> account;
        try {
            Query query= session.createQuery("Finding all accounts by userName where account_name= 'pedro', password= '1234'");
            query.setParameter("account_name", userName);
            query.setParameter("password", password);
            account= (query.list());

        } catch (Exception e) {

            throw new DataException (e);
        }

        if (account == null)
            throw new DataException ("Cuenta " + userName + " desconocida");

        return (account.get(0));
    }

}