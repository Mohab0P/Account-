package junitaccount;

/*********************************************************************
 * The SuspiciousReturnException is thrown if a customer makes a return
 * that appears to be invalid. 
 * 
 * @author Nathan Sprague
 * @version V1.0, 02/2012
 *********************************************************************/
public class InvalidReturnException extends RuntimeException {

    /***********************************************************
     * Construct a new SuspiciousReturnException.
     * 
     * @param message  Error message. 
     ***********************************************************/
    public InvalidReturnException(String message)
    {
        super(message);
    }
}