package com.capgemini.heskuelita.service.impl;


import com.capgemini.heskuelita.entity.Account;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;


public class SecurityServiceImpl implements ISecurityService{


    private IUserDao userDao;

    public SecurityServiceImpl(IUserDao userDao) {

        super();

        this.userDao = userDao;
    }


    @Override
    public void login(Account account) throws SecurityException {

        try {

            account=this.userDao.login(account.getUser_name(), account.getPassword());
        } catch (Exception e) {

            throw new SecurityException(e);
        }
    }

    /*
    @Override
    public void register(Account account) throws SecurityException{

        try{
            this.userDao.register(account.getUser_name, account.getPassword, account.getEmail);
        } catch (Exception e) {

            throw new SecurityException(e);
        }

    }
    */
}