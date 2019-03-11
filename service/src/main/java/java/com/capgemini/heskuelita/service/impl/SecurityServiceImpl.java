package java.com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.User;
import java.com.capgemini.heskuelita.data.IUserDao;
import java.com.capgemini.heskuelita.service.ISecurityService;
import java.com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDAO;

    public SecurityServiceImpl (IUserDao userDAO){

        super();

        this.userDAO = userDAO;
    }

    @Override
    public void login(User user) throws SecurityException {

        try {
            user = this.userDAO.login(user.getUserName(), user.getPassword());
        }

        catch(Exception e){
            throw new SecurityException();
        }
    }
}
