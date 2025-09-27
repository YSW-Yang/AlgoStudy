import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());

            int maxLen = 0;
            List<Integer> result = new ArrayList<>();

            int totalSubsets = 1 << n; // 2^n

            for (int i = 1; i < totalSubsets; i++) {
                List<Integer> subset = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(j + 1); // 숫자는 1부터 N까지
                    }
                }

                if (check(subset)) {
                    if (subset.size() > maxLen) {
                        maxLen = subset.size();
                        result = new ArrayList<>(subset);
                    }
                }
            }

            System.out.println(result.size());
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // 세 수의 조합을 골라 XOR이 0이 되는 경우가 없으면 true 반환
    static boolean check(List<Integer> v) {
        int size = v.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if ((v.get(i) ^ v.get(j) ^ v.get(k)) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
