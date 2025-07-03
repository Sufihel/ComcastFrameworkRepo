package practise.testNG;

import org.testng.annotations.DataProvider;

public class Demo {
	@DataProvider()
	public static Object[][] getData() {
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="Deepak";
		objArr[0][1]="verma";
		
		objArr[1][0]="Chetan";
		objArr[1][1]="Devgan";
		
		objArr[2][0]="Rohit";
		objArr[2][1]="Singh";
		return objArr;
		
	}
}
