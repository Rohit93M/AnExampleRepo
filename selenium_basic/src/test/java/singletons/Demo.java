package singletons;

import learning_singletons.Controller;

public class Demo {
	
    public static void main(String[] args) {
    	
        Controller c1 = Controller.getInstance();
        Controller c2 = Controller.getInstance();
        Controller c3 = Controller.getInstance();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        
        //Since all hash codes are identical, we are dealing with a unique instance of Controller
    }
}
