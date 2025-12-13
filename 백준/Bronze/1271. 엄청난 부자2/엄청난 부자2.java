import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		BigInteger n = new BigInteger(inputs[0]);
		BigInteger m = new BigInteger(inputs[1]);

		BigInteger quotient = n.divide(m);
		BigInteger remainder = n.mod(m);

		System.out.println(quotient + "\n" + remainder);
	}
}