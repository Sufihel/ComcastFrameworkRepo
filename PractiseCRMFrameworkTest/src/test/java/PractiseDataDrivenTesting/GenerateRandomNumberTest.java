package PractiseDataDrivenTesting;

import java.util.Random;

public class GenerateRandomNumberTest {

	public static void main(String[] args) {
		Random random=new Random();
		int randomnum= random.nextInt(1000);
		System.out.println(randomnum);

	}

}
