
package taskonefinalrev0;


public class Task {
    
    boolean checkTaskDescription;
    String createTaskID;
    String printTaskDetails;
    int returnTotalHours;
    
    
    //method 1
    public String ischeckTaskDescription(String taskName)
    {
        String tempText;
        if(taskName.length() <= 50)
        {
            checkTaskDescription = true;
            tempText = "Task successfully captured";
        }
        else
        {
            checkTaskDescription = false;
            tempText = "Please eneter a task description "
                    + "of less than 50 characters";
        }
         return tempText;   
    
    }

    public void setCheckTaskDescription(boolean checkTaskDescription) {
        this.checkTaskDescription = checkTaskDescription;
    }

    
    //dealing with task id
    public String getCreateTaskID(String taskName, int taskNumber,
                                    String taskDev)
    {
        createTaskID = taskName.substring(0,2).toUpperCase() + ":" +taskNumber 
                             + ":" + taskDev.substring(taskDev.length()-3).toUpperCase();
        
        return createTaskID;
    }

    public void setCreateTaskID(String createTaskID) {
        this.createTaskID = createTaskID;
    }
    
    public String getPrintTaskDetails(String taskStatus, String taskDevDetails,
            int taskNumber, String taskName, String taskDesc,
            String TaskID, int taskDuration)
    {
        printTaskDetails ="Task details of task : "
                + taskNumber
                +"\nTask status: " +taskStatus
                        + "\nDeveloper Details : "+taskDevDetails
                        + "\nTask Number : "+taskNumber
                        + "\nTask Name : "+taskName
                        + "\nTask Description : "+taskDesc
                        + "\nTask ID : "+TaskID
                        + "\nTask Duration : "+taskDuration+ " hours";
        
        return printTaskDetails;
    }

    public void setPrintTaskDetails(String printTaskDetails) {
        this.printTaskDetails = printTaskDetails;
    }
    
    //calc method
    public int getReturnTotalHours(int taskDuration, int totalHours){
        returnTotalHours = totalHours + taskDuration;
        return returnTotalHours;
    }

    public void setReturnTotalHours(int returnTotalHours) {
        this.returnTotalHours = returnTotalHours;
    }
    
    
    
}
