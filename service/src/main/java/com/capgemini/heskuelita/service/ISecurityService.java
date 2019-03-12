package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.entity.Account;

public interface ISecurityService {

void login(Account account) throws SecurityException;
//void register(Account account) throws SecurityException;
}
