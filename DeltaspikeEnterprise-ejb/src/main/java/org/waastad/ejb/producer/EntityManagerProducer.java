/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ejb.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@ApplicationScoped
@Slf4j
public class EntityManagerProducer {

    @PersistenceContext(unitName = "DemoPU")
    protected EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager create() {
        log.info("Producing entitymanager.....");
        return em;
    }

}
