/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121part001;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Prog5121part001 {

    //This method checks if the username meets the requirements

public static boolean checkUsername(String username){

if (username.length()<=5 && username.contains("_"))

//username must be atleast up to 5 characters and contain an underscore

{

System.out.println("Welcome!" + username + "it is great to see you");

return true;

}

else {

System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five character characters in length");

return false;

}

}

//this methof checks if the password meets the complexity reuiremnts

//Password must have atleast 1 special character,Capital letter,number and atleast 8 characters minimum

public static boolean checkPasswordComplexity(String password){

if (password.length()>=8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")&& password.matches(".*[!@#$%^&*].*"))

{

System.out.println("Password sucessfully captured");

return true;

}

else {

System.out.println("Password is not correctly formatted;Please ensure that the password contains at least eight characters,a capital letter,a number and a special character");

return false;

}

}

//This method checks if the cellphone number meets requirements

public static boolean checkCellphoneNumber(String cellphone){

//Cellphone number must start with +27 and must be 12 characters long(south african number)

if (cellphone.length()==12 && cellphone.startsWith("+27"))

{

System.out.println("Cellphone number sucessfully captured ");

return true;

}

else {

System.out.println("Cellphone is incorrectly formatted or does not conatin an international code;please correct the number and try again");

return false;

}

}

//this method registers the user and returns a sucess message

public static String registerUser (String username,String password,String cellphone){


return"User has been registered successfully";

}

//trhis method checks if the entered login credentials match the stored credentials,this method is stricly for the programmer only,not the user

public static boolean loginUser(String username,String password,String storedUsername,String storedPassword){

if (username.equals(storedUsername) && password.equals(storedPassword)){

return true;}

else{

return false;

}

}

//This ,ethod returns the login status message

public static String returnLoginStatus(String storedPassword,String storedUsername,String password,String username){

if (loginUser(username,password,storedUsername,storedPassword)== true) {

return"Login is sucessfull,welcome back to your personal chatbox";

}else{

return"Login is unsucessful,please try again";

}

}

public static void main(String[] args) {

Scanner sc =new Scanner(System.in);

//the sevariables store the registered credentials

//NOTE TO MAKER:in a real life system the credentials would be saved to the database or file so users can log in

//user needs to register before logging in

String storedUsername=null;

String storedPassword=null;

String storedCellphone=null;

boolean isRegistered =false;

//hardcoded test credentials for option 3,this is used to assume the user has completed the registration process but now needs to login into the account.

String testUsername="kyl_1";

String testPassword="Ch&&sec@ke99!";

//in a real life system there would not been an option 3 but just to show that the login page does work effectively,BUT only when you have registered first

//The system will never allow you to register without credentials being captured first.


//step1;ask whether they want to login 0r register(loops till valid answer is entered

String choice="";

while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){

System.out.println("Welcome!Please choose either option 1,2 OR 3,only write the number ONLY(eg-1)");

//register option below allows the user to register then thereafter login

System.out.println("1-Register ");

//for register option below this will display user has to register first as this is how real life system work,for this system you cannot login without registering,this tests the security and accuracy of my system

System.out.println("2-Login");

//for the skip to login is strictly for testing purposes so the marker will be able to see that the login page does work effectively and this is strictly for people that have registered ONLY

System.out.println("3-Skip to login(for testing)");

choice =sc.nextLine();

if(!choice.equals("1")&& ! choice.equals("2") && !choice.equals("3")){

System.out.println("Invalid choice.Please enter either 1 or 2 or 3");

}

}

//step2 :Register

//If user selects 1,they go through registration process

if (choice.equals("1")){

//username loop-this system will keep asking for the username until it matches the username standards/requirements

String username="";

while(true){

System.out.println("Enter a username (must be atleats 5 characters and contain'_'):");

username=sc.nextLine();

if (checkUsername(username)){

break;

}

}

//password loop-keeps asking until password meets the requirements/standard

String password="";

while(true){

System.out.println("Enter a password(must have atleast 1 uppercase,1 special character,1 number);");

password=sc.nextLine();

if (checkPasswordComplexity(password)){

break;

}

}

//Cellphone-loop and this will keep asking for the user to input the cellphone number until it meets correct standards/requirements

String cellphone ="";

while (true){

System.out.println("Enter a cellphone number(must start with +27 and be 12 characters,ensure this is a South African cellphone number):");

cellphone=sc.nextLine();

if (checkCellphoneNumber(cellphone)){

break;

}

}

//Save the registered credentials for the login use

storedUsername=username;

storedPassword=password;

storedCellphone=cellphone;

isRegistered=true;

String registrationResult=registerUser(username,password,cellphone);

System.out.println(registrationResult);

}

//step 3:LOGIN

//User can login after registering(option1 or directly using option 1or3

if (choice.equals("2") || isRegistered ||choice.equals("3"))

//if testing (option 3),use hardcoded credentials

if(choice.equals("3")){

storedUsername=testUsername;

storedPassword=testPassword;

isRegistered=true;

System.out.println("Use username-kyl_1 and password Ch&&sec@ke99! for test purposes ");

}



{

//if user picked 2 (login) wihtout registering ,the program will stop

if (!isRegistered){

System.out.println("No registered user found.Please register first");

return;

}

System.out.println("----Login----");

//username login_keeps asking until the user the correct username which was entered during registration

String enteredUsername="";

while(!enteredUsername.equals(storedUsername)){

System.out.println("Enter a username(must be no more than 5 characters and contain'_'):");

enteredUsername=sc.nextLine();

if (!enteredUsername.equals(storedUsername)){

System.out.println("The entered username is incorrect,please try again");

}

}

System.out.println("Enter a username for login process:");

//Password login loop-keeps asking until the correct password is entered

String enteredPassword="";

while(!enteredPassword.equals(storedPassword)){

System.out.println("Enter your password for login process:");

enteredPassword=sc.nextLine();

if (!enteredPassword.equals(storedPassword)){

System.out.println("The entered password is incorrect,please try again");

}

}

System.out.println("Your entered password is correct,you are able to move onto the next step");

String loginStatus=returnLoginStatus(storedPassword,storedUsername,enteredPassword,enteredUsername);

System.out.println(loginStatus);

System.out.println("Welcome to Zamavezi's Chatbox " + enteredUsername);


}

}

}
    

