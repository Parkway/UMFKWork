/*****************************************
 * Created by Lance Douglas on 4/7/2017
 *****************************************/

public class DivideByZeroException extends Exception
{
    public DivideByZeroException( )
    {

    }

    public DivideByZeroException(String message)
    {
        super(message);
    }
}
