package practise.testNG;

import org.testng.annotations.Test;

public class OrderTest {
	@Test(invocationCount = 10)
	public void  createOderTest() {
		System.out.println("createOderTest");
	}
	@Test(dependsOnMethods = "createOderTest", enabled = false)
	public void billingOrderTest() {
		System.out.println("billingOrderTest");
	}

}
