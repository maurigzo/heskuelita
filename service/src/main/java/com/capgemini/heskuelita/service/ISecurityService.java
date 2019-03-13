package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.entity.Human;

public interface ISecurityService {

void login(Human human) throws SecurityException;
void register(Human human) throws SecurityException;
}
