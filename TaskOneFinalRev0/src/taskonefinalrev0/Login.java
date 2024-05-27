    //ST10460086
    package taskonefinalrev0;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
    import javax.swing.JOptionPane;

    public class Login {
    //GLOBAL VARIABLES
    public static String registeredUsername;
    public static String registeredPassword;
    public static String firstName = "<user first name>";
    public static String lastName = "<user last name>";
    public static boolean loginStatus;
    

    public static void menu()
    {
     
        JOptionPane.showMessageDialog(null, 
                "Welcome to EasyKanban"); 
        registerUser();
        loginUser();
    }
    
    //Registration Method starts
    public static void registerUser()
    {
        //Variables
        boolean checkUsername = false;
        boolean checkPasswordComplexity = false;
        String username;
        String password;
       
        //Saving additional user details
        firstName = JOptionPane.showInputDialog(null, "Enter your name");
        lastName = JOptionPane.showInputDialog(null, "Enter your last name");

        //Username check
        do{           
            username = JOptionPane.showInputDialog(null, "Username must contain "+"'_'"+
                   " and be no more than 5 characters in length:");
            checkUsername = username.contains("_")
                   && username.length()<=5;
            JOptionPane.showMessageDialog(null, getCheckUserName(username));
        }while(!checkUsername);

       
        do{           
            password = JOptionPane.showInputDialog(null, "Password must contain: \n"
            + "1 Upper case \n"
            + "1 Number \n"
            + "1 special character [!@$#]"
            + "and be a minimum of 8 characters in length");
            //RULES --> A - Z or a - z or 0 - 9

            //RULES
            Pattern specialPattern = Pattern.compile("[^A-Za-z0-9]");
            Pattern digitPattern = Pattern.compile("\\d"); //FORMAT
            Pattern capsPattern = Pattern.compile("[A-Z]");

            //Matching
            Matcher specialMatcher = specialPattern.matcher(password);
            Matcher digitMatcher = digitPattern.matcher(password);
            Matcher capsMatcher = capsPattern.matcher(password);

            checkPasswordComplexity = password.length() >= 8
                   && specialMatcher.find()
                   && digitMatcher.find()
                   && capsMatcher.find();

            JOptionPane.showMessageDialog(null, getCheckPasswordComplexity(password));
        }while(!checkPasswordComplexity);

        //Saving Login Details
        registeredUsername = username;
        registeredPassword = password;
        JOptionPane.showMessageDialog(null, "Registration completed");
    }// Registration Method Ends

    // Checking Username and Returning Message
    public static String getCheckUserName(String userN){
        boolean checkUser = false;
        String userOutput;
        checkUser = userN.contains("_")
                   && userN.length()<=5;
        if(!checkUser)
           {
               userOutput = falseUsernamePrompt();
           }else
        {   
            usernameTestStatus(checkUser);
            userOutput = ("Username successfully captured");
        }
        return userOutput;
    }  
    
    //Checking Password and Returning Message
    public static String getCheckPasswordComplexity(String passW){
        boolean checkPassComp = false;
        String passOutput;
        Pattern specialPattern = Pattern.compile("[^A-Za-z0-9]");
           Pattern digitPattern = Pattern.compile("\\d"); //FORMAT
           Pattern capsPattern = Pattern.compile("[A-Z]");

           //Matching
           Matcher specialMatcher = specialPattern.matcher(passW);
           Matcher digitMatcher = digitPattern.matcher(passW);
           Matcher capsMatcher = capsPattern.matcher(passW);

           checkPassComp = passW.length() >= 8
                   && specialMatcher.find()
                   && digitMatcher.find()
                   && capsMatcher.find();
        if(!checkPassComp)
           {
               passOutput = falsePasswordPrompt();
           }else
        {
             passwordTestStatus(checkPassComp);
             passOutput = ("Password successfully captured");
        }
        
        return passOutput;
    }
    
    //Login Method
    public static void loginUser(){ 
        do{ 
     
        String usernameCheck = JOptionPane.showInputDialog(null, "--- Login ---"
               + "\nEnter your username");
   
       String passwordCheck = JOptionPane.showInputDialog(null, "--- Login ---"
               + "\nEnter your password");
       JOptionPane.showMessageDialog(null, returnLoginStatus(usernameCheck, passwordCheck));
       }while(!loginStatus);
    }// Login Method Ends
    
    //Performs Login Check and returns appropriate message
    public static String returnLoginStatus(String user, String pass){
        String status; // Login check
        
        if(user.equals(registeredUsername)
               && pass.equals(registeredPassword)){
           loginStatus = true; 
           status = ("\n"+"--- Login Successful ---"+"\n"+"Welcome " + firstName + " " +
                   lastName+ " it is great to see you.");
       }else
       {
           loginStatus = false;
           status = ("\n"+"Username or password incorrect, please try again"+"\n");

       }
        return status;
    }// Login Check Ends

    //TEXT PROMPTS

    public static String falseUsernamePrompt(){
        return ("Username is not correctly formatted, "
                       + "please ensure that your username contains an "
                       + "underscore and is no more than 5 characters"
                       + "in length.");
    }

    public static String falsePasswordPrompt(){
        return ("Password is not correctly formatted, "
                + "please ensure that the password contains at least 8 "
                + "characters, a capital letter, a number and a special "
                + "character.");
    }
    
    //Used for Testing
    
    public static boolean usernameTestStatus(boolean uts){
        return uts;
    }
    
    public static boolean passwordTestStatus(boolean pts){
        return pts;
    }
 }
