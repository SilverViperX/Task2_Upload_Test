
package taskonefinalrev0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
    
    Task tk = new Task();
    
    public TaskTest() {
    }

    @Test
    public void testIscheckTaskDescription1() {
        String s = "Create Login to authenticate users";
        assertEquals("Task successfully captured", tk.ischeckTaskDescription(s));
    }
    
    @Test
    public void testIscheckTaskDescription2() {
        String s = "Create Add Task feature to add task users";
        assertEquals("Task successfully captured", tk.ischeckTaskDescription(s));
    }
    
    @Test
    public void testIscheckTaskDescriptionFail() {
        String s = "1234567890"
                + "1234567890"
                + "1234567890"
                + "1234567890"
                + "1234567890"
                + "1234567890";
        assertEquals("Please eneter a task description "
                    + "of less than 50 characters", tk.ischeckTaskDescription(s));
    }


    @Test
    public void testGetCreateTaskID1() {
        String tName = "Login Feature";
        int tNumber = 1;
        String tDev = "Robyn Harrison";
        assertEquals("LO:1:SON", tk.getCreateTaskID(tName, tNumber, tDev));
    }

    @Test
    public void testSetCreateTaskID2() {
        String tName = "Add Task Feature";
        int tNumber = 2;
        String tDev = "Mike Smith";
        assertEquals("AD:2:ITH", tk.getCreateTaskID(tName, tNumber, tDev));
    }


    @Test
    public void testGetReturnTotalHours1() {
        int numTasks = 2;
        int[] myArrayTest = new int[]{8, 10};

        int result = 0;
        for (int i = 0; i < numTasks; i++) {
            result = tk.getReturnTotalHours(myArrayTest[i], result);
        }
        assertEquals(18,result);
    }
    
    @Test
    public void testGetReturnTotalHours2() {
        int numTasks = 5;
        int[] myArrayTest = new int[]{10, 12, 55, 11, 1};

        int result = 0;
        for (int i = 0; i < numTasks; i++) {
            result = tk.getReturnTotalHours(myArrayTest[i], result);
        }
        assertEquals(89,result);
    }

    
    
}
