import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.lang.Math.max;


public class bf1 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 10 && n % 2 == 0) {
            System.out.println(1);
            System.exit(0);
        } else if (n <= 10 && n % 2 == 1) {
            System.out.println(0);
            System.exit(0);
        }
        String str = String.valueOf(n);
        int strlength = str.length();
        int ans = 0;
        int start;


        start = max(1,n-9*str);

        for (int i = start; i < n; i++) {
            String num = String.valueOf(i);
            for (char ch : num.toCharArray()) {
                ans += ch - '0';
            }
            if (ans + i == n) {
                System.out.println(num);
                System.exit(0);
            }
            ans = 0;
        }
        System.out.println(0);
    }
    }
}
