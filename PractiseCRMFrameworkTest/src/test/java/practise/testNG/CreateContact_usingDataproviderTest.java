package practise.testNG;

import org.testng.annotations.Test;

public class CreateContact_usingDataproviderTest {
	@Test(dataProvider = "getData", dataProviderClass = Demo.class)
	public void createContact(String firstName, String lastName) {
		System.out.println("First Name= " + firstName + " Last Name= " + lastName);
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		Object[][] objArr= new Object[3][2];
//		objArr[0][0]="Deepak";
//		objArr[0][1]="verma";
//		
//		objArr[1][0]="Chetan";
//		objArr[1][1]="Devgan";
//		
//		objArr[2][0]="Rohit";
//		objArr[2][1]="Singh";
//		return objArr;
//		
//	}

}
