import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                arr1[i][j] = Integer.parseInt(br.readLine());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                arr2[i][j] = Integer.parseInt(br.readLine());
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.println(arr1[i][j] + arr2[i][j] + " ");
                if (j==M-1) System.out.println();
            }
        }
    }
}
