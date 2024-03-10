package junitaccount;

/*********************************************************************
 * The LimitExceededException is thrown when an account holder attempts
 * to exceed their account limit. 
 * 
 * @author Nathan Sprague
 * @version V1.0, 02/2012
 *********************************************************************/
public class LimitExceededException extends RuntimeException {

    /***********************************************************
    * Construct a new LimitExceededException.
    * 
    * @param message  Error message. 
    ***********************************************************/
   public LimitExceededException(String message)
   {
       super(message);
   }
    
}