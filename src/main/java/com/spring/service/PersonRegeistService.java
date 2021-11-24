package com.spring.service;

import com.spring.entity.PersonRegeist;

public interface PersonRegeistService {

    public void insertPersonRegeist(PersonRegeist personRegeist);

    public PersonRegeist queryPersonRegeist(String idcard);
}
