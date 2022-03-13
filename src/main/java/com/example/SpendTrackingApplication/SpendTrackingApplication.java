package com.example.SpendTrackingApplication;

import com.example.SpendTrackingApplication.MongoRepository.PurchaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.example.SpendTrackingApplication")
@EnableMongoRepositories(basePackageClasses = PurchaseRepository.class)
@EnableJpaRepositories(basePackages="com.example.SpendTrackingApplication.dao")
@EnableTransactionManagement
@EntityScan(basePackages="com.example.SpendTrackingApplication.entity")
public class SpendTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendTrackingApplication.class, args);
	}

}
