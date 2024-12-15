package learning_singletons;

public class Controller {
	/*
	 We must do three things to apply the Singleton pattern in our Controller class-
     1. Create a private static instance of Controller
     2. Create a private constructor
     3. Create a public method to access the Controller object
	 */
    private static Controller controller;

    private Controller(){}

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
}
