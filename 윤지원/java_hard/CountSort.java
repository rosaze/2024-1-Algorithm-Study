import java.io.*;

public class CountSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[2000001];

        for (int i = 0; i < N; i++) { //등장횟수 카운트
            count[Integer.parseInt(br.readLine()) + 1000000]++;
        }
        for (int i = 0; i < 2000001; i++) {//카운팅된 숫자 출력
            while (count[i] > 0) {
                sb.append((i - 1000000)).append('\n');
                count[i]--;

            }
        }
        System.out.print(sb);
        br.close();
    }

    }

