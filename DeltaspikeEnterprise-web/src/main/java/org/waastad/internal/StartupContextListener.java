/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.internal;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@WebListener
public class StartupContextListener implements ServletContextListener {

    @Inject
    private StatisticsScheduler scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        scheduler.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        scheduler.shutdown();
    }

}
