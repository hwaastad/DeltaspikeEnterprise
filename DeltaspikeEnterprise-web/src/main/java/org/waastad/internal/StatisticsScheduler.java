/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.internal;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.waastad.ejb.business.BusinessBeanRemote;
import org.waastad.qualifier.RemoteEjb;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Singleton
@Slf4j
public class StatisticsScheduler {

    @Resource
    private TimerService timerService;
    private Timer timer;

    @Inject
    @RemoteEjb
    private BusinessBeanRemote businessBeanRemote;


    public void init() {
        log.info("Initializing timer...");
        timer = timerService.createIntervalTimer(3000L, 10000L, new TimerConfig("test-timer", false));
    }

    public void shutdown() {
        if (timer != null) {
            log.info("Canceling timer...");
            timer.cancel();
        }
    }

    @Timeout
    public void timeout(Timer timer) {
        log.info("Timer Hit......");
        businessBeanRemote.savePerson("Name " + new Date());
    }

}
