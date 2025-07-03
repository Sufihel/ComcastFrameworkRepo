package PractiseDataDrivenTesting;

public class GenerateAlphanumericRandomdata {

	public static void main(String[] args) {
		// Give the length of the expected Alphanumeric string
		int n = 25;

		// Choose character random for the string
		String alphanumericString = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";

		// create a stringbuffer size of Alphanumericstring

		StringBuilder stringBuilder = new StringBuilder(n);

		// generate a random number between 0 to the expected alphanumeric length
		for (int i = 0; i < n; i++) {
			int index = (int) (alphanumericString.length() * Math.random());

			// Adding or appending the character one by one
			stringBuilder.append(alphanumericString.charAt(index));
		}
		System.out.println(stringBuilder);
	}

}
