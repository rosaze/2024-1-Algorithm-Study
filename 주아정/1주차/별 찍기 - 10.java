import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// BOJ_2447
// https://www.acmicpc.net/problem/2447
public class Main {

    static int n;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        star(0, 0, n, false);

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void star(int x, int y, int divideN, boolean isBlank) {
        if (isBlank) {
            for (int i=x; i<divideN+x; i++) {
                for (int j=y; j<divideN+y; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (divideN == 1) { // 더 이상 나누지 못하는 경우
            arr[x][y] = '*';
            return;
        }

        int size = divideN/3; // 쪼개진 구역 수 (27에서는 9가 하나의 쪼개진 구역이고, 9에서는 3이 하나의 쪼개진 구역)
        int count = 0; // 공백이 어디 있는지 확인하기 위한 누적 별 합계

        for (int i=x; i<divideN+x; i+=size) {
            for (int j=y; j<divideN+y; j+= size) {
                count++;
                star(i, j, size, count == 5); // count == 5 (공백인 경우)만 isBlank가 true로, 나머지는 false로 준다
            }
        }
    }
}
