
package taskonefinalrev0;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ST10460086
 */
public class LoginNGTest {
    
    public LoginNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

   
    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String firstName = "<user first name>";
        String lastName = "<user last name>";
        
        //Username is correctly formatted
        String userN = "kyl_1";
        String expCorrectResult = "Username successfully captured";
        String correctResult = Login.getCheckUserName(userN);
        assertEquals(correctResult, expCorrectResult);
        
        //Username is incorrectly formatted
        String userN2 = "kyle!!!!!!!";
        String expIncorrectResult = "Username is not correctly formatted, "
                       + "please ensure that your username contains an "
                       + "underscore and is no more than 5 characters"
                       + "in length.";
        String incorrectResult = Login.getCheckUserName(userN2);
        assertEquals(incorrectResult, expIncorrectResult);
        
        
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        
        //Password meets the complexity requirements
        String passW = "Ch&&sec@ke99!";
        String expResult = "Password successfully captured";
        String result = Login.getCheckPasswordComplexity(passW);
        assertEquals(result, expResult);
        
        //Password does not meet the complexity requirements
        String passW2 = "password";
        String expIncorrectResult = "Password is not correctly formatted, "
                + "please ensure that the password contains at least 8 "
                + "characters, a capital letter, a number and a special "
                + "character.";
        String incorrectResult = Login.getCheckPasswordComplexity(passW2);
        assertEquals(incorrectResult, expIncorrectResult);
        
        
       //Test (assertTrue/False) 
    }
     /*   @Test //Login Successful
        public void testloginTestStatus() {
            boolean sampleLts = true;
             Login login = new Login();
             assertTrue(login.loginTestStatus(sampleLts)); 
  }
        @Test //Login Failed
        public void testloginTestStatus_FalseCondition() {
            boolean sampleLts2 = false;
             Login login = new Login();
             assertFalse(login.loginTestStatus(sampleLts2)); 
  } */
        @Test //Username Correctly Formatted
        public void testusernameTestStatus() {
            boolean sampleUts = true;
             Login login = new Login();
             assertTrue(login.usernameTestStatus(sampleUts)); 
  }
        @Test //Username Incorrectly Formatted
        public void testusernameTestStatus_FalseCondition() {
            boolean sampleUts2 = false;
             Login login = new Login();
             assertFalse(login.usernameTestStatus(sampleUts2)); 
  }
        
        @Test //Password Correctly Formatted
        public void testpasswordTestStatus() {
            boolean samplePts = true;
             Login login = new Login();
             assertTrue(login.passwordTestStatus(samplePts)); 
  }
        @Test //Password Incorrectly Formatted
        public void testpasswordTestStatus_FalseCondition() {
            boolean samplePts2 = false;
             Login login = new Login();
             assertFalse(login.passwordTestStatus(samplePts2)); 
  } 
    
    
}
