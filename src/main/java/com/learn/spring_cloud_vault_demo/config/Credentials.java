package com.learn.spring_cloud_vault_demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("")
public class Credentials {

    private String name;
    private String password;
    private String key;
}

// I used below command to insert data to vault server
// vault kv put secret/spring-cloud-vault-demo my.username=dhanushka my.password=abc@123 my.key=derTDFS@hg#DFS
// vault kv put secret/spring-cloud-vault-demo name=sampath password=abc@123 key=derTDFS@hg#DFS