/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ejb.business;

import java.util.List;
import javax.ejb.Remote;
import org.waastad.deltaspikeenterprise.jpa.entity.Person;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Remote
public interface BusinessBeanRemote {

    String savePerson(String name);

    List<Person> findByName(String name);
}
