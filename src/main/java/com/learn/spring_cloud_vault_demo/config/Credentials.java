package com.learn.spring_cloud_vault_demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my") // my.name | my.password | my.key
public class Credentials {

    private String name;
    private String password;
    private String key;
}

// I used below command to insert data to vault server
// vault kv put secret/spring-cloud-vault-demo my.username=dhanushka my.password=abc@123 my.key=derTDFS@hg#DFS