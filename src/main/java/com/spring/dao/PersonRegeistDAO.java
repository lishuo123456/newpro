package com.spring.dao;


import com.spring.entity.PersonRegeist;

public interface PersonRegeistDAO {

    public void insertPersonRegeist(PersonRegeist personRegeist);

    public PersonRegeist queryPersonRegeist(String idcard);

}
