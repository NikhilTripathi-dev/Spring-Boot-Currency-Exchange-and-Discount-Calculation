# Currency Exchange and Discount Calculation
# Overview
Develop a Spring Boot application that integrates with a third-party currency exchange API to retrieve real-time exchange rates. The application should calculate the total payable amount for a bill in a specified currency after applying applicable discounts. The application should expose an API endpoint that allows users to submit a bill in one currency and get the payable amount in another currency.

# Technologies Used

1. Java 17 or later

2. Spring Boot framwork

3. JUnit: Unit testing framework.

4. Any IDE such as IntelliJ IDEA or Eclipse.

5. Maven: Build and dependency management.

6. Lambok: Java library that reduces boilerplate code by generating getter/setter methods.


# Steps to Set Up
  # Step 1: Clone the repository

   git clone https://github.com/your-repo/Spring-Boot-Currency-Exchange-Discount.git

   cd Spring-Boot-Currency-Exchange-Discount

# Step 2: Build the project using Maven

  mvn clean install

# Step 3: Run the Application: You can run the Spring Boot application using the following command

  mvn spring-boot:run

  The application will start on http://localhost:8080/

# Step 4 : Run test cases with code coverage
  mvn test

# Key Features 

 # Third-Party API Integration

    1. Integrate with a currency exchange API, such as ExchangeRate-API or Open Exchange Rates, to get real-time currency exchange rates.

    2. Use the API key (replace your-api-key in the URL below) to access exchange rates.
       
        Example endpoint: https://open.er-api.com/v6/latest/{base_currency}?apikey=your-api-key
 
	
# Discounts and Currency Conversion Logic
  # Apply discounts as per the following rules
  
       1. If the user is an employee of the store, they get a 30% discount.
 
       2. If the user is an affiliate of the store, they get a 10% discount.
	
       3. If the user has been a customer for over 2 years, they get a 5% discount.
 
       4. For every $100 on the bill, there is a $5 discount.

       5. The percentage-based discounts do not apply to groceries.

       6. A user can get only one of the percentage-based discounts on a bill.
	
       7. Convert the bill total from the original currency to the target currency using the retrieved exchange rates.

       8. Calculate the final payable amount in the target currency after applying the applicable discounts.
 
# Authentication

	1. Implement authentication for the exposed endpoints. 
 
 # Endpoint Exposure
        1. Expose an API endpoint (/api/calculate) to accept bill details including items, their categories, total amount, user type, customer tenure, original currency, and target currency.
 
        2. The endpoint should return the net payable amount in the specified target currency after applying applicable discounts and currency conversion.
 
# Design and Testing

	1. Use object-oriented programming principles to design the application.

	2. Provide a high-level UML class diagram of all key classes in your solution.
 
	3. Write unit tests to achieve good code coverage, utilizing mocking frameworks where applicable.
 
	4. Ensure code simplicity and adherence to modern coding practices.

# Project Structure

1. CurrencyController: Handles API requests for billing and exposes endpoints like

2. CurrencyService Interface: Contains the core business logic, orchestrating the discount application, fetching exchange rates, and calculating the final bill.

3. DiscountService Interface: Contains logic to apply various discounts based on user roles, tenure, and bill items. 

4. BillRequest: Represents the bill entity, with fields like amount, currency, userId, and items

5. ExchangeRateResponse: Response the bill entity, with fields like amount, currency, userId, and items.

6. SecurityConfig: Basic authentication.

7. JUnit Tests: Comprehensive unit tests for all discount scenarios.

   ![image](https://github.com/user-attachments/assets/04836b56-e00d-4bc9-ab5b-1801d8898935)




# Usage

 This application calculates the net payable amount based on the following rules:

 A percentage-based discount applies depending on the user’s relationship with the store.

 if the user is an employee of the store, they get a 30% discount.

 If the user is an affiliate of the store, they get a 10% discount.

 If the user has been a customer for over 2 years, they get a 5% discount.
 
 If the bill contains groceries, percentage discounts are not applied.
 
 A fixed discount of $5 is applied for every $100 on the bill.

 Convert the bill total from the original currency to the target currency using the retrieved exchange rates.

 Calculate the final payable amount in the target currency after applying the applicable discounts.
 
# The application accepts two inputs:

  BillRequest: Whether the user is an employee, affiliate, a long-term customer (over 2 years) and original currency and target currency.

# License

   This project is licensed under the MIT License - see the LICENSE file for details.

# Contributing

   If you'd like to contribute to this project:

  Fork the repository.
  
  Create a new branch (git checkout -b feature/your-feature).
  
  Commit your changes (git commit -am 'Add some feature').
  
  Push to the branch (git push origin feature/your-feature).
  
  Create a new Pull Request.
  
# Contact
    For any issues or suggestions, please feel free to contact:
    
    Email: abc@gmail.com
















