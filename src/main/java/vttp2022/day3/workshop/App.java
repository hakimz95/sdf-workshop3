package vttp2022.day3.workshop;

/**
 * Main Program
 */
public class App 
{
    private static String defaultDb = "db";
    public static void main( String[] args )
    {
        if(args.length > 0)
            //print out the first argument
            if(args[0] != null) {
                System.out.println( args[0] );
                App.defaultDb = args[0];
            }
        System.out.println( defaultDb );
        Repository repo = new Repository(defaultDb);
        Session session = new Session(repo); //session is the one that controls the input
        session.start();
       
    }
}
