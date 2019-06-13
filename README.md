# TestBank
TestBank is an example web application with secure and vulnerable implementations; to be used to test against our products implementations.

## Getting Started
TestBank is written using Java/Spring Boot and uses JavaServer Pages (.jsp) to generate the dynamically web pages, the JavaServer Pages are marked up using Bootstrap.
TestBank utilities the H2 SQL Database Engine; to provide an embedded database in memory, with the schema and data refreshed upon each TestBank instance.
The H2 database ensures across instances the database resets, incase the tests destroy the database and so each test is tested against the exact same data.
With the database in memory it is also alot quicker to query speeding up tests.

### Installing
TestBank uses gradle for building and testing. Simply clone the branch of the TestBank repository you wish to build/install and use the gradle wrapper to automatically run the tests and build the .war file.
```
./gradlew build
```
To skip the tests append '-x test'.
After gradle has successfully tested and built the application the .war file is localed in
```
./build/libs/*.war
```

### Deployment
With the built .war file Java can be invoked to deploy the Spring Boot service.
```
java -jar testbank-*.war
```
The above command invokes the Spring Boot service through Java and begins running the service listening on port 8080.

By default the service runs on port 8080, but this can be changed by passing the runtime argument -Dserver.port=<desired port>
```
java -Dserver.port=9090 -jar testbank-*.war
``` 
The above command runs the service listening for inbound connections on port 9090.

While testing the application on AWS EC2 there was issues with the random number generation capability of the instances. They weren't able to generate random number fast enough, causing webpages to be unable to be served. As security isn't an issue the source of entropy can be changed via a runtime argument.
```
java -Djava.security.egd=file:/dev/./urandom -jar testbank-*.war
```
The above entropy source fixed the random number shortage issues on AWS EC2.

TestBank can be deployed in either a secure mode or a vulnerable mode. By default it boots in vulnerable mode and this is represented on the webpages with '- vulnerable' appended to the name. Through runtime arguments TestBanks context can be switched to provide the service in a secure mode, changing the implementation behind the vulnerable functions.
```
java -Dsecure -jar testbank-*.war
```
The above command used the '-Dsecure' runtime argument to boot up the service in a secure context. As with the vulnerable instance the context is displayed visibly and visiting the secure webpage the ' - vulnerbale' appending to the name will have changed to '- secure'

### Sonar
To run a scan on sonar 
```
./gradlew sonarqube -Dsonar.host.url=<<SONAR URL>> -Dsonar.login=<<SONAR TOKEN>> -Dsonar.projectKey=<<PROJECT KEY>>
```
For more information go [here](href="https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Gradle)
