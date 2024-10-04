# Spring-Boot-Currency-Exchange-and-Discount-Calculation
This project is a Spring Boot application that integrates with a third-party currency exchange API to calculate discounts and convert currencies. The application features a system for applying various discount rules based on user roles and tenure and converts the final bill amount into the target currency using live exchange rates.

Features
Authentication:Implement authentication for the exposed endpoints. 
Currency Conversion: The application uses a third-party currency exchange API to convert the bill from the original currency to the desired target currency.
Discount Calculation:
Employee Discount: 30% discount for employees.
Affiliate Discount: 10% discount for affiliates.
Customer Loyalty Discount: 5% discount for customers who have been with the store for over 2 years.
Bill Total Discount: For every $100 on the bill, a $5 discount is applied.
Grocery Exclusion: Percentage-based discounts do not apply to grocery items.
Single Discount Policy: Only one percentage-based discount can be applied per user.
Final Amount: After applying discounts, the total payable amount is converted into the target currency.
bash
Copy code
git clone https://github.com/NikhilTripathi-dev/Spring-Boot-Currency-Exchange-and-Discount-Calculation.git
mvn spring-boot:run
Usage
Authentication: To interact with the system, users must authenticate.
Apply Discounts: Discounts are applied automatically based on the user's role and the item categories.
Currency Conversion: The total amount is automatically converted to the target currency after all discounts are applied.
API Endpoints
POST /calculate-discount: Calculate discounts based on the user's role and item categories.
Discount Rules
Employees receive a 30% discount.
Affiliates receive a 10% discount.
Customers with over 2 years of tenure receive a 5% discount.
A $5 discount is applied for every $100 spent.
Percentage-based discounts do not apply to groceries.
Users can only receive one percentage-based discount at a time.
The total payable amount is calculated in the target currency after applying discounts.
Technologies Used
Java 17: Programming language.
Spring Boot: Framework for building the application.
Maven: Dependency management and build tool.
REST API: For communication between client and server.
Third-party API: For fetching live currency exchange rates.
