/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
package com.mycompany.prog5121part001;
import org.junit.Test;
import static org.junit.Assert.*;
public class prog5121part001Test {
    // Test 1: Username correctly formatted
@Test
public void testCheckUsernameValid() {
assertEquals(true, Prog5121part001.checkUsername("kyl_1"));
}

// Test 2: Username incorrectly formatted
@Test
public void testCheckUsernameInvalid() {
assertEquals(false, Prog5121part001.checkUsername("kyle!!!!!!!"));
}

// Test 3: Password meets complexity requirements
@Test
public void testCheckPasswordValid() {
assertEquals(true, Prog5121part001.checkPasswordComplexity("Ch&&sec@ke99!"));
}

// Test 4: Password does not meet complexity requirements
@Test
public void testCheckPasswordInvalid() {
assertEquals(false, Prog5121part001.checkPasswordComplexity("password"));
}

// Test 5: Cell phone correctly formatted
@Test
public void testCheckCellphoneValid() {
assertEquals(true, Prog5121part001.checkCellphoneNumber("+27838968976"));
}

// Test 6: Cell phone incorrectly formatted
@Test
public void testCheckCellphoneInvalid() {
assertEquals(false, Prog5121part001.checkCellphoneNumber("08966553"));
}

// Test 7: Login successful
@Test
public void testLoginSuccessful() {
assertEquals(true, Prog5121part001.loginUser("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!"));
}

// Test 8: Login failed
@Test
public void testLoginFailed() {
assertEquals(false, Prog5121part001.loginUser("kyl_1", "Ch&&sec@ke99!", "wronguser", "wrongpass"));
}
}

    

