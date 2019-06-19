package com.bwie.bticonexplor.scheduler;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class BitcoinScheduler {
    private Logger logger= (Logger) LoggerFactory.getLogger(this.getClass());

    @Scheduled(fixedRate = 10000)
    public void syncData(){
       logger.info("begin sync bitcoin data");
    }
}
