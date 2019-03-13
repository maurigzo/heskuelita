package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.core.beans.User;

public interface IUserDao {

    User login (String user_name, String password);

    User register(String user_name, String password, String email);
}
