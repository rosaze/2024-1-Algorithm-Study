import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // N-Queen
    // https://www.acmicpc.net/problem/9663

    static int count = 0;
    static int[] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == N) {
            count ++;
            return;
        }

        for (int i=0; i<N; i++) {
            map[depth] = i;
            if (Possibility(depth)) {
                nQueen(depth+1);
            }
        }
    }
    
    public static boolean Possibility(int col) {
        for (int i=0; i<col; i++) {
            // 같은 행에 존재
            if (map[col] == map[i]) {
                return false;
            }
            // 대각선 상에 놓여있는 경우
            else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }
        return true;
    }
}
