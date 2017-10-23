package com.springboot.app.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repo;

    @Override
    public void run(String... strings) throws Exception {

        repo.save(new User("Leszek", "CEO"));
        repo.save(new User("Paulina", "Admin"));
        repo.save(new User("Jakub", "User"));
        repo.save(new User("Kacper", "User"));
        showAllUsers();
        log.info("Only users: ");
        for (User user : repo.findByRole("User")) {
            log.info(user.toString());
        }
        log.info(repo.countByRole("User").toString());



    }

    public void showAllUsers() {
        for (User user : repo.findAll()) {
            log.info(user.toString());
        }
    }
}


