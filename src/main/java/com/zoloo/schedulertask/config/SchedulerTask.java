package com.zoloo.schedulertask.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zoloo.schedulertask.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

	private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
    private StudentService studentService;

	@Scheduled(fixedRate = (60000*2))
	public void reportCurrentTime() throws Exception {
        log.info("*****The time is now: " + dateFormat.format(new Date()));
        System.out.print("*****The time is now: " + dateFormat.format(new Date()));
        studentService.getStudents().forEach(t-> System.out.println(t));
        System.out.println("\n");
	}
}