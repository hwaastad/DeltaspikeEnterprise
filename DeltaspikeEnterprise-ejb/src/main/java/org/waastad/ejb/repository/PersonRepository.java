/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ejb.repository;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.waastad.deltaspikeenterprise.jpa.entity.Person;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Repository
//@EntityManagerConfig(entityManagerResolver = CrmEntityManagerResolver.class, flushMode = FlushModeType.COMMIT)
public abstract class PersonRepository extends AbstractEntityRepository<Person, Long> {

    @Inject
    private EntityManager em;

    public abstract List<Person> findByName(String name);

    @Query(named = Person.FIND_BY_NAME)
    public abstract List<Person> findByNamedName(@QueryParam("name") String name);

}
