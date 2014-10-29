package org.waastad.deltaspikeenterprise.jpa.entity;

import java.io.Serializable;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = Person.FIND_BY_NAME, query = "SELECT t FROM Person t WHERE t.name=:name")
})
public class Person implements Serializable {

    public static final String FIND_BY_NAME = "Person.FindByName";
    private static final long serialVersionUID = 3523605948173674057L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Pet.class)
    private Collection<Pet> petCollection;

    @Basic
    private String name;

    public Person() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Pet> getPetCollection() {
        return this.petCollection;
    }

    public void setPetCollection(Collection<Pet> petCollection) {
        this.petCollection = petCollection;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
