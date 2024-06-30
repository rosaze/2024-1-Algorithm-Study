import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  // BOJ_10986 : 나머지 합
  // https://www.acmicpc.net/problem/10986
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long[] addArr = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i= 1; i<N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        // 합 배열의 모든 값에 % 연산 수행
        for (int i=0; i<N; i++) {
            int remainder = (int) (arr[i] % M);
            if (remainder == 0) count ++;
            addArr[remainder]++;
        }

        for (int i=0; i<M; i++) {
            if (addArr[i] > 1) {
                count = count + (addArr[i] * (addArr[i]-1) / 2);
            }
        }
        System.out.println(count);
     }
}
