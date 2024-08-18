package testngbasic;

import org.testng.annotations.Test;

public class Group02 {

@Test (groups = "functional")
public void createNewAccount() {
System.out.println("createNewAccount");
}

@Test (groups = "system")
public void friendRequest() {
System.out.println("friendRequest");
}

@Test (groups = "integration")
public void home() {
System.out.println("home");
}

}