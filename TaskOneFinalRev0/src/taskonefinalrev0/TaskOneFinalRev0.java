//ST10460086
package taskonefinalrev0;

import javax.swing.JOptionPane;


public class TaskOneFinalRev0 {

    public static Login lg = new Login();
    public static int arraySize;
    
    public static void main(String[] args) {
        
        lg.menu();
         boolean closeProgram = false;
        int menuChoice;
        
        while (!closeProgram){
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog
               (null, "Welcome to EasyKanban" 
                       + "\nPlease choose an option"
                       + "\n[1] - Add tasks"
                       + "\n[2] - Show report"
                       + "\n[3] - Quit program"));
            switch(menuChoice){
                case 1: tasks(); break;
                case 2: JOptionPane.showMessageDialog(null, "Coming soon");  break;
                case 3: JOptionPane.showMessageDialog(null, "Quitting program ..."); 
                        closeProgram = true; break;
                default: JOptionPane.showMessageDialog(null, "Enter a valid option");break;
            }//switch ends
        }//while ends
        System.exit(0);
    }
    
    public static void tasks()
    {
        arraySize =  Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of tasks"));
        //housekeeping
        if(arraySize <= 0)
        {
            JOptionPane.showMessageDialog(null, "Enter a valid number");
        } //if ends
        //create the arrays
        String [] taskName = new String[arraySize];
        String [] taskDesc = new String[arraySize];
        String [] taskDevDetails = new String[arraySize];
        String [] taskStatus = new String[arraySize];
        String [] taskID = new String[arraySize];
        int [] taskNumber = new int[arraySize];
        int [] taskDuration = new int[arraySize];
        //variables
        int taskStatusNumber; //number --> text
        int totalHours = 0;
        
        // object of class
        Task ts = new Task();
        for (int i = 0; i < arraySize; i++) {
            taskNumber[i] = (i+1); // so it starts at 1
            taskName[i] = JOptionPane.showInputDialog(null, 
                    "Enter a task name for task "+taskNumber[i]);
            ts.setCheckTaskDescription(false);
            while (ts.checkTaskDescription == false){
                taskDesc[i]= JOptionPane.showInputDialog(null,
                    "Enter a task description that is under 50 characters");
                //for unit test
                    JOptionPane.showMessageDialog(null, 
                            ts.ischeckTaskDescription(taskDesc[i]));
                    System.out.println(ts.checkTaskDescription);
            }//while ends
            
            taskDevDetails[i] = JOptionPane.showInputDialog(null, 
                    "Enter name & surname of developer");
            taskDuration[i] = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Enter the task duration "));
            // 1 - to do 2 - done 3 - doing
            taskStatusNumber = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Please choose an option "
                            + "\n[1] - To do"
                            + "\n[2] - Done"
                            + "\n[3] - Doing"));
            
            switch(taskStatusNumber)
            {
                case 1 : taskStatus[i] = "To do"; break;
                case 2 : taskStatus[i] = "Done"; break;
                case 3 : taskStatus[i] = "Doing"; break;
            } //switch ends
            taskID[i] = ts.getCreateTaskID(taskName[i], taskNumber[i], taskDevDetails[i]);
          
            //pull unit test printlines
            totalHours = ts.getReturnTotalHours(taskDuration[i], totalHours);
            
            //Print task details
            JOptionPane.showMessageDialog(null, ts.getPrintTaskDetails(taskStatus[i],
                    taskDevDetails[i],taskNumber[i],taskName[i],taskDesc[i]
                    ,taskID[i],taskDuration[i]));
            
        }
        //optional
        if(arraySize > 0)
            {
                JOptionPane.showMessageDialog(null, "Total hrs: "+totalHours);
            }
    }
    
    /*
    References:
    -- Farrell, J. (2022). Java Programming. S.L.: Cengage Learning.
    -- Youtube Links:
    https://www.youtube.com/playlist?list=PL480DYS-b_kfHSYf2yzLgto_mwDr_U-Q6
    https://youtu.be/fQaUsfEzGdw?feature=shared
    https://youtu.be/1Pa15vDWG-8?feature=shared
    -- Resource Links:
    https://github.com/
    https://coderolls.com/assertTrue-and-assertFalse-in-junit/
    Developer Info:
    ST10460086
    Reece Mikhael Moodley
    ST10460086@vcconnect.edu.za
    */
}
