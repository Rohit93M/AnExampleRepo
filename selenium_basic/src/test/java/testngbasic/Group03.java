package testngbasic;

import org.testng.annotations.Test;

public class Group03 {

@Test (groups = "functional")
public void product() {
System.out.println("product");
}

@Test (groups = "integration")
public void payment() {
System.out.println("payment");
}

@Test (groups = {"smoke", "integration"})
public void signup() {
System.out.println("signup");
}

}
