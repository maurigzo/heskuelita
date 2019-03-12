package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.entity.Account;

public interface IUserDao {

    Account login (String userName, String password);

   // Account register(String userName, String password, String email);
}
