import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수들의 합 5
// https://www.acmicpc.net/problem/2018
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1, end = 1, sum = 1, count = 1;

        while (end != N) {
            if (sum == N) {
                count += 1;
                end += 1;
                sum += end;
            }
            else if (sum < N) {
                end += 1;
                sum += end;
            }
            else {
                sum -= start;
                start += 1;
            }
        }

        System.out.println(count);
    }
}
