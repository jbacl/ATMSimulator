# Automatic Teller Machine using _Java_ and _MySQL_

### A fully functional Java project that was designed and built to replicate the standard features of an ATM.
### You can create your own bank account through the _Signup_ button and a card number will be given to you at the end of the signup process.
### Once you log in successfully, you will be given 6 options: _Deposit_, _Withdrawal_, _Fast Cash_, _Mini Statement_, _Bank Inquiry_, and _Pinchange_. Click on your desired option and input any needed details. 
### For all of the options, you can use the back button to come back to the _transactions_ page if you misclicked or do not want that specific service.
### All information is stored and organized in an _AWS Aurora MySQL_ database and can be accessed using MySQL Workbench.

## How to install and run: 
### 1. Download the source code file by clicking on the green **CODE** button and dragging the downloaded file onto your desktop. 
### 2. Double-click on the zip file, and your computer will create a new folder with the source code.
### 3. Finally, double-click on _BankManagementSystem.jar_, and it will run the ATM Simulator.
## **ONLY CONTINUE IF YOU WANT TO VIEW THE DATABASE**
### 4. Go to https://dev.mysql.com/downloads/installer/ and install the latest version of MySQL installer. 
###     **_As of 06/23/2023, MySQL Workbench does not work on macOS. Still, try to install it just in case they fix the issue_**
### 5. Open the MySQL installer and download the latest version of MySQL Server, MySQL Workbench, and MySQL Shell.
### 6. After the files are done installing, open MySQL Workbench and click on the **PLUS** button next to MySQL Connections.
### 7. Set _Connection Name_ to any name you want, and make sure _Connection Method_ is set to _Standard (TCP/IP)_
### 8. For _Hostname_, input "bankmanagement-instance-1.c2fuumy8c57t.us-east-2.rds.amazonaws.com" and _Port_ as 3306.
### 9. For the _Username_, input "admin" and _Password_ as "1234qwer".
