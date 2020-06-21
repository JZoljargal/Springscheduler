package com.zoloo.schedulertask.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.zoloo.schedulertask.model.Student;
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

    @Scheduled(cron = "0/15 * * * * *")
	public void addScheduledData() throws Exception {
        log.info("*****The time is now: " + dateFormat.format(new Date()));
        System.out.print("*****The time is now: " + dateFormat.format(new Date()));
        Student student = new Student();
        student.setFirstName(generateRandomString());
        student.setLastName(generateRandomString());
        student.setRegister(generateRandomString());
        student.setEmail("zolootest@gmail.com");
        studentService.addStudent(student);
        System.out.println("\n");
    }
    
    public String generateRandomString() {
  
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
}