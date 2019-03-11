package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.core.beans.User;

public interface IUserDao {

    User login (String userName, String password);

    User register(String userName, String password, String email);
}
