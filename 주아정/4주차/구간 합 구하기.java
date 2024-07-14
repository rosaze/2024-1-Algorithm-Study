import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // BOJ_11659 : 구간 합 구하기 4
    // https://www.acmicpc.net/problem/11659
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        
        // 구간 합 배열에 숫자 저장
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i=1; i<N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        // 구간 합 구하기
        int i, j;
        for (int k=0; k<M; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            if (i == 1) sb.append(arr[j-1]).append("\n");
            else sb.append(arr[j-1] - arr[i-2]).append("\n");
        }

        System.out.println(sb);
    }
}
