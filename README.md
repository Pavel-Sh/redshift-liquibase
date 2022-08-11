# Redshift Liquibase Example

### Prerequisites
In order to verify and test liquibase perform the following steps

* Setup a Redshift cluster under you AWS account.
* Make the cluster publicly available if you are going to execute liquibase from outside.
* Ensure you cluster has correct security group assigned which allows jdbc connection from outside.
* Ensure you cluster has a database and a schema.
* Ensure to create a user which would be used by liquibase (using admin user is a bad practice). Update application properties with correct username/password.
* Check cluster jdbc url and update application.properties with jdbc url.
