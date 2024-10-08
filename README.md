# Spring-Boot-Currency-Exchange-and-Discount-Calculation
This Spring Boot application integrates with a third-party currency exchange API to convert currencies and calculate discounts based on user roles and other business rules. The final amount is derived after applying relevant discounts and currency conversion.

# Features:-
Currency Conversion: Converts total bill from one currency to another using live exchange rates.
# Discount Rules:
30% discount for store employees.

10% discount for store affiliates.

5% discount for customers with over 2 years of tenure.

$5 discount for every $100 spent.

No percentage-based discounts on groceries.

Only one percentage-based discount can be applied per bill.

Final Amount Calculation: After discounts and currency conversion.

# Technologies Uesd:-
1.Spring Boot: REST API framework.

2.Spring Security: For authentication and authorization.

3.Java: Core language.

4.RestTemplate: To fetch currency exchange rates.

5.JUnit: Unit testing framework.

6.Maven: Build and dependency management.

7.Lambok: Java library that reduces boilerplate code by generating getter/setter methods.

8.SonarQuebe: for code quality.

9.Eclemma: for code coverage.

# Installation and Setup prerequisites:-
Ensure you have the following installed:
Java 17 or higher
Maven

# Steps to setup:-
Clone the repository:

git clone https://github.com/your-repo/Spring-Boot-Currency-Exchange-Discount.git

cd Spring-Boot-Currency-Exchange-Discount

# Assumption:-
Configure API Key:
Obtain an API key from a currency exchange service and add it to the src/main/resources/application.properties:
currency.api.url=https://api.exchangeratesapi.io/latest
currency.api.key=YOUR_API_KEY

# Build the application
mvn clean install

# Run the Application
mvn spring-boot:run

# API Endpoints
POST /api/calculate

The application will start on http://localhost:8080.

# Use eclemma plugin for code coverege.

# Step 1: download and install SonarQube
# Step 2: Configure SonarQube in Your Spring Boot Project
# 1. Install Sonar Scanner for Maven
If you're using Maven, you can integrate SonarQube using the Sonar Maven plugin.

Add the following plugin to your pom.xml:

xml
Copy code
<build>
  <plugins>
    <plugin>
      <groupId>org.sonarsource.scanner.maven</groupId>
      <artifactId>sonar-maven-plugin</artifactId>
      <version>3.9.1.2184</version>
    </plugin>
  </plugins>
</build>
# 2. Add SonarQube Properties to the pom.xml
In the pom.xml file, add the necessary SonarQube properties under the <properties> section:

xml
Copy code
<properties>
  <sonar.host.url>http://localhost:9000</sonar.host.url>
  <sonar.login>your-sonarqube-token</sonar.login>
</properties>
You can generate a SonarQube token from the SonarQube dashboard by going to User Settings -> Security -> Generate Tokens.

# 3. Running the SonarQube Analysis
After setting up the project, run the following Maven command to analyze your Spring Boot project with SonarQube:

Copy code
mvn clean verify sonar:sonar
This will build the project, analyze the code, and send the results to the SonarQube dashboard. After completion, you can view the analysis results in SonarQube at http://localhost:9000.

# Security: using spring boot basic security.

add dependency for security:-
  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

  # Project Structure:-

![image](https://github.com/user-attachments/assets/c12f852b-ff7c-49c2-abc5-f3fbe57d326c)


![image](https://github.com/user-attachments/assets/d01f1ff5-3eb4-4ed2-aabc-3da5a7482c12)









