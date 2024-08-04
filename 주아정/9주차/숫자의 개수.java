import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // BOJ_2577 : 숫자의 개수
    // https://www.acmicpc.net/problem/2577
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N=1;
        int[] num = new int[10];

        for (int i=0; i<3; i++) {
            N *= Integer.parseInt(br.readLine());
        }

        while (N != 0) {
            num[N % 10]++; // 일의 자리
            N /= 10;
        }

        for (int i=0; i<10; i++) {
            sb.append(num[i]).append("\n");
        }

        System.out.println(sb);
    }
}
