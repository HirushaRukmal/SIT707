package sit707_week2;

/**
 * Hello world!
 * @author Ahsan Habib
 */
public class Main 
{
    public static void main( String[] args )
    {
        // Replace "your_username" and "your_password" with actual credentials
        String username = "your_username";
        String password = "your_password";

        // Perform login to Bunnings website
        SeleniumOperations.loginToBunnings(username, password);
    }
}