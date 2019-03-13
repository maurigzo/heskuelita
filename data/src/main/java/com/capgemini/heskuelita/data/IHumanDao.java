package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.entity.Human;

public interface IHumanDao {

    Human login (String user_name, String password);

    Human register(String user_name, String password, String email);
}
