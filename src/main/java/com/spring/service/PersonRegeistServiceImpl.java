package com.spring.service;

import com.spring.dao.PersonRegeistDAO;
import com.spring.entity.PersonRegeist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PersonRegeistServiceImpl implements PersonRegeistService {
    @Autowired
    private PersonRegeistDAO personRegeistDAO;

    @Override
    public void insertPersonRegeist(PersonRegeist personRegeist) {
        personRegeistDAO.insertPersonRegeist(personRegeist);
    }

    @Override
    public PersonRegeist queryPersonRegeist(String idcard) {

        return personRegeistDAO.queryPersonRegeist(idcard);
    }


}
