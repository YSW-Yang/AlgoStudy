import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long MOD = 1000000;

        long csod = 0;
        
        for (long i = 2; i * 2 <= n; i++) {
            long count = (n / i) - 1;
            csod = (csod + (i * count)) % MOD;
        }

        System.out.println(csod);
    }
}