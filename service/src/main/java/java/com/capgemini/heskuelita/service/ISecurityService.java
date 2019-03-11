package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.core.beans.User;

public interface ISecurity {

void login(User user) throws SecurityException;
}
