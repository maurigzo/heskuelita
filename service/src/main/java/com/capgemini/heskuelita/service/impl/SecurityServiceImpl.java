package com.capgemini.heskuelita.service.impl;


import com.capgemini.heskuelita.entity.Human;
import com.capgemini.heskuelita.data.IHumanDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;


public class SecurityServiceImpl implements ISecurityService{


    private IHumanDao humanDao;

    public SecurityServiceImpl(IHumanDao humanDao) {

        super();

        this.humanDao = humanDao;
    }


    @Override
    public void login(Human human) throws SecurityException {

        try {

            this.humanDao.login(human.getUser_name(), human.getPassword());
        } catch (Exception e) {

            throw new SecurityException(e);
        }
    }

    @Override
    public void register(Human human) throws SecurityException{

        try{
            this.humanDao.register(human.getUser_name(), human.getPassword(),human.getEmail());
        } catch (Exception e) {

            throw new SecurityException(e);
        }

    }
}