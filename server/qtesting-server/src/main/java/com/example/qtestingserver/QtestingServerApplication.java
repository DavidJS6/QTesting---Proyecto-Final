package com.example.qtestingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class QtestingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QtestingServerApplication.class, args);
	}

}
