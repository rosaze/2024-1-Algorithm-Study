import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1546 : 평균
// https://www.acmicpc.net/problem/1546
public class Main {
    // 최댓값 고르기 => M
    // 점수 조작 => 점수/M*100
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double num, max = 0;
        double[] numArr = new double[N];

        for (int i=0; i<N; i++) {
            num = Integer.parseInt(st.nextToken());
            if (max < num) max = num;
            numArr[i] = num;
        }

        double sum = 0;

        // 점수 조작
        for (int i=0; i<numArr.length; i++) {
            sum += numArr[i]/max*100;
        }

        System.out.println(sum/N);
    }
}
