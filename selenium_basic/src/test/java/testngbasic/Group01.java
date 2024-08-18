package testngbasic;

import org.testng.annotations.Test;

public class Group01 {

@Test(groups = "functional")
public void login() { 
System.out.println("login");
}

@Test(groups = "system")
public void forgottenPwd() { 
System.out.println("forgottenPwd");
}

@Test (groups = {"integration", "functional"})
public void profile() { 
System.out.println("profile");
}

@Test (groups = {"smoke", "functional"})
public void logout() { 
System.out.println("logout");
}

}
