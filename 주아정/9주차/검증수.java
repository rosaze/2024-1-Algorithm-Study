import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // BOJ_2475 : 검증수
    // https://www.acmicpc.net/problem/2475
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, count = 0;

        for (int i=0; i<5; i++) {
            n = Integer.parseInt(st.nextToken());
            count += n*n;
        }

        System.out.println(count % 10);
    }
}
