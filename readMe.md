#Navigate to project Directory
C:\Users\navneetkushwaha\OneDrive - Nagarro\Desktop\Testing Software\ExitTest\ExitTest\ExitTest>
then Use cmd:- mvn test

----------------------------------------------------------------------------------------------------
#Test data should be read from excel. User has the ability to selective run the test cases by marking yes in the "Execution Required" field in excel.
>> In Test Case 4:- To test Invalid Login I've created this excel sheet and user can update yes or no .
phonenumber	Execution Required
7521938510	yes
9876543210	No
5556667777	No
9998887777	No

>>In Test Case :- Verify Grocery Prodcut search bar and user can search product on the basis of requirement.
GroceryProduct
Atta
----------------------------------------------------------------------------------------------------
#Use config files for Global Parameters usage.

Browser configuration
browser=ie
headless = false

Base URL for the Flipkart website
base_url=https://www.flipkart.com/

----------------------------------------------------------------------------------------------------
#The test should run on following browsers IE, Chrome, FF.
in config file we can update browser:-
there is a parameter
Browser configuration
browser=ie 

----------------------------------------------------------------------------------------------------
#There should be an option to run the test cases in headless mode.
in config file there is parameter named headless in which on the basis of requirement we can write true or false
headless = false

----------------------------------------------------------------------------------------------------
#Create a ReadMe document which has the steps to install and run the code.

in pom.xml all repository are mentioned now maven must be installed and only navigate to folder and provide command
mvn test
-----------------------------------------------------------------------------------------------------
    Test Case 1: Verify Flipkart Home Page Title(Done)
    Objective: Ensure the Flipkart home page title is correct.
    Steps:
        Open Flipkart website.
        Get the title of the page.
    Expected Result: The title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

------------------------------------------------------------------------------------------------------
#All are Test cases

    Test Case 2: Verify Login Page Elements (Done)
    Objective: Ensure all elements on the login page are present.
        Steps:
            Open Flipkart website.
            Click on the "Login" link.
        	Check for presence of username and password input fields, login button, and other relevant elements.
    Expected Result: All elements should be present on the login page.

    Test Case 3: Verify Successful Login(Done)
        Objective: Ensure users can log in successfully.
        Precondition: User credentials are valid.
        Steps:
            Open Flipkart website.
            Click on the "Login" link.
            Enter valid username and password.
            Click on the login button.
        Expected Result: User should be logged in successfully and redirected to the home page.
    
    Test Case 4: Verify Invalid Login  (done)
        Objective: Ensure users cannot log in with invalid credentials.
        Precondition: User credentials are invalid.
        Steps:
            Open Flipkart website.
            Click on the "Login" link.
            Enter not registered mobile number.
            Click on the login button.
        Expected Result: An alert will popUp.


    Test Case 5: Verify Search Functionality(Done)
        Objective: Ensure search functionality works correctly.
        Steps:
            Open Flipkart website.
            Enter a search query in the search bar.
            Hits enter button.
        Expected Result: Relevant search results should be displayed.


    Test Case 6: Verify Product Details Page(Done)
        Objective: Ensure product details page displays correct information.
        Precondition: Product exists in the catalog.
        Steps:
            Open Flipkart website.
            Search for a product.
            Click on the product.
        Expected Result: Product details page should display correct information like product name, price, description, etc.


    Test Case 7: Verify Add to Cart Functionality (done)
        Objective: Ensure users can add products to the cart.
        Precondition: Product is available for purchase.
        Steps:
            Open Flipkart website.
            Search for a product.
            Click on the product.
            Click on the "Add to Cart" button.
        Expected Result: Product should be added to the cart successfully.

    Test Case 8: Verify Cart Page (done)
        Objective: Ensure cart page displays correct information.
        Steps:
            Open Flipkart website.
            Click on the cart icon.
        Expected Result: Cart page should display the list of products added, total price, and options to proceed to checkout.


    Test Case 9: Verify Travel Page(done)
        Objective: Ensure users can open travel page.
        Steps:
            Open Flipkart website.
            Click on the travel icon.
            Get title of travel page.
        Expected Result: Expected and actual title must be same.


    Test Case 10: Verify Travel Page Elements(done)
        Objective: Ensure travel page elements are present in travel page.
        Steps:
            Open Flipkart website.
            Click on the travel icon.
            Check all required fields are present or not.
        Expected Result: All required fields must be present in travel page.


    Test Case 11: Verify Become Seller(done)
        Objective: Ensure Become seller is openable.
        Steps:
            Open Flipkart website.
            click Become seller icon.
            Ensure ExpectedTitle and ActualTitle of Become seller page title is equal.
        Expected Result: Become seller page.


    Test Case 12: Verify StartSelling Dashboard(done)
        Objective: Ensure become seller page is openable or not using title of driver.
        Steps:
            Open Flipkart website.
            Select Become seller icon.
            select start selling dashboard.
        Expected Result: ExpectedTitle and Actual title of driver must be same.

    Test Case 13: Verify Shopsy Page(done)
        Objective: Ensure Shopsy Page is openable.
        Steps:
            Open Flipkart shopsy website.
        Expected Result: ExpectedTitle and Actual title of driver must be same.


    Test Case 14: Verify Shopsy Query Form(done)
        Objective: Ensure users can send query.
        Steps:
            Open Flipkart shopsy website.
            now check all fields are present or not (FullName,MobileNumber/EmailId,TypeYourMessage)
        Expected Result: All fields must be present


    Test Case 15: Verify Selling DashBoard Login(done)
        Objective: Ensure all relevent fields must be present.
        Steps:
           Open Flipkart website.
            Select Become seller icon.
            select start selling dashboard.
            now check all fields are present or not (username,gstin,panNo)
        Expected Result: all fields must be present.
        
    Test Case 16: Verify Shopsy Query form(done)
        Objective: Ensure users can send query or not.
        Steps:
             Open Flipkart shopsy website.
             filling all required fields.
             Click on the "Submit" button.
        Expected Result: Query Sent successfully alert message must be visible.

    Test Case 17: Verify Grocery Category(done)
        Objective: Ensure grocery category is openable or not.
        Steps:
            Open Flipkart website.
            Click on the "Grocery Icon" link.
        Click on the "Grocery Icon" button.
        Expected Result: Expected title and actual title must be same.


    Test Case 18: Verify Pincode Enter(done)
        Objective: Ensure users can enter Pincode.
        Steps:
            Open Flipkart website.
            Click on the "Grocery Icon" link.
            Enter pincode 
        Expected Result: Enter pincode successfully.

    Test Case 19: Verify Searching of Product in Grocery(done)
        Objective: Ensure users can search product .
        Steps:
            Open Flipkart website.
            Click on the "Grocery Icon" link..
            Search product in grocery search bar.
        Expected Result: Expected and Actual Title must be same.


    Test Case 20: Verify Terms and Conditions Page(done)
        Objective: Ensure users can access terms and conditions.
        Steps:
            Open Flipkart website.
            Click on the "Terms and Conditions" link.
        Expected Result: Terms and conditions page should be displayed.







