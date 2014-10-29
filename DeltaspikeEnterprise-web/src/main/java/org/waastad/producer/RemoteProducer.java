/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.producer;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import org.waastad.ejb.business.BusinessBeanRemote;
import org.waastad.qualifier.RemoteEjb;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@SessionScoped
public class RemoteProducer implements Serializable {

    private static final long serialVersionUID = 1641757355955889522L;

    @Produces
    @EJB(name = "businessBean")
    @RemoteEjb
    BusinessBeanRemote businessBeanRemote;
}
