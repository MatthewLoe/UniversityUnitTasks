import java.util.*;

public class SimpleLock
{
    //I need a base number to start the encoding
    private static final float MAGIC =  2.03f;

    public static void main(String [] args)
    {
        float pass;

        pass = enterPassword();
       
        checkPassword(pass);
    }
    
    /************************************************
     *SUBMODULE: enterPassword
     *IMPORT: -
     *EXPORT: encoded Password
     *    Should read each charcter of the password, 
     *    and add it to the encoding.
     * ********************************************/
    public static float enterPassword()
    {
        char input;
        float testNumber;
        Scanner sc = new Scanner(System.in);
        
        //Initialise testNumber
        testNumber = MAGIC;

        //TODO LOOP: put this in a loop once a single char is working.
            System.out.println("Speak Friend and Enter");
            input = sc.next().charAt(0);
            testNumber += encode(input);
        //END LOOP

        return testNumber;
    }

    /***************************************************
     *SUBMODULE: checkPassword
     *IMPORT: character
     *EXPORT: encoded char as float
     *    encodes a single character
     * ************************************************/
    public static float encode(char pChar)
    {
        float coded;

        switch(pChar)
        {
            case 'j': case 'i': case 's': case 'f': case 'm':
                coded = 0.3f + 0.3f + 0.3f; 
                break;
            case 'F': case 'P': case 'B': case 'C': case 'K': case 'J':
                coded = 0.5f;
                break;
            default:
                coded = -0.01f;
                break;
        }
        return coded;
    }
        
    /***************************************************
     *SUBMODULE: checkPassword
     *IMPORT: encoded password
     *EXPORT: -
     *    Uses the password and tries to open the lock 
     * ************************************************/
    public static void checkPassword(float password)
    {
        //testPass will eventually hold the stored password
        //test case for 'f' and 'm'
        float testPass = MAGIC + 0.9f;
        
        //test case for 'C'
        //float testPass = MAGIC + 0.5f;
        
        //test case for 'a'
        //float testPass = MAGIC - 0.01f;

        System.out.println("testPass"+testPass);
        System.out.println("password"+password);
        if ((testPass >= (password - 0.1)) && (testPass <= (password + 0.1)))
        {
            System.out.println("Alohomora");
        }
        else
        {
            System.out.println("MUGGLE!");
        }

    }

}
