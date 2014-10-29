/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ejb.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.waastad.deltaspikeenterprise.jpa.entity.Person;
import org.waastad.ejb.repository.PersonRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Stateless
@Slf4j
public class BusinessBean implements BusinessBeanLocal, BusinessBeanRemote {

    @Inject
    private PersonRepository personRepository;

    @Override
    public String savePerson(String name) {
        Person p = new Person();
        p.setName(name);
        personRepository.save(p);
        return "Hello " + name;
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByNamedName(name);
    }

}
