WHAT IS SPRING CLOUD VAULT?
==========================

assume there are common configurations to set of microservices. typical way is adding all those configurations in property files of each.
But using spring-loud-vault, we can centralize the configurations to one common place(vault server).
Then each microservice can access the vault server and fetch the needed properties(mainly secrets).

it can store usernames/passwords/db-related properties.

pls refer img-1.png


This is somewhat similar to spring-cloud-config
But,
Use Spring Cloud Vault when you need secure, dynamic, and centralized management of secrets.
Use Spring Cloud Config for application configuration



Choose Spring Cloud Vault when
==============================

1.You need to manage sensitive secrets securely.
2.You require dynamic secret generation and automatic lease renewal.
3.Your application must rotate secrets and handle high-security requirements.

Choose Spring Cloud Config when
===============================

1.You want to manage static configuration properties for multiple microservices.
2.You’re focusing on externalizing configuration without heavy secret management needs.



IMPLEMENTATION
==============

1. First we need to install vault in our machine based on os.

sudo apt-get update && sudo apt-get upgrade
sudo apt-get install curl gnupg apt-transport-https
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update
sudo apt-get install vault


After above installation steps, verify by below command
vault --version

you will see below output
Vault v1.17.6 (69a720d5d940bfcd590d7c24f3c98f178673d796), built 2024-09-24T19:48:40Z



2. start vault server

use below command to start the server
vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"

in the terminal you should see "core: post-unseal setup complete" if the vault server started successfully

Before writing to vault server, we need to set env variable as follows

export VAULT_ADDR="http://127.0.0.1:8200"






in this vault server, we can
2.1. write secret
-----------------

use below command to write
vault kv put secret/spring-vault-config-example my.username-dhanushka my.password=abc@123

2.2. read secret
----------------

use below command to read
vault kv get secret/spring-vault-config-example

This will return the username and password we wrote


2.3. delete secret
------------------

use below command to delete
vault kv delete secret/spring-vault-config-example



