package com.learn.spring_cloud_vault_demo;

import com.learn.spring_cloud_vault_demo.config.Credentials;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Here what i'm going to do is print the values stored in vault server
 *
 * I'm using CommandLineRunner, which wil be run on application startup
 *
 * Since vault configuration always use bootstrap.properties files we need to add vault
 * server related configs to that
 * */
@SpringBootApplication
@EnableConfigurationProperties(Credentials.class)
@RequiredArgsConstructor
@Slf4j
public class SpringCloudVaultDemoApplication implements CommandLineRunner {

	private final Credentials credentials;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudVaultDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("-------------Properties Fetched From Vault Server-----------");
		log.info("Username:{}", credentials.getName());
		log.info("Password:{}", credentials.getPassword());
		log.info("Key:{}", credentials.getKey());
	}
}
