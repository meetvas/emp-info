package com.newt.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.newt.dao")
@EntityScan("com.newt.model")
@ComponentScan(basePackages={"com"})
public class Application {

	public final Logger log =  LoggerFactory.getLogger(this.getClass());
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
