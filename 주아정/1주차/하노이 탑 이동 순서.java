import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 하노이 탑 이동 순서
    // https://www.acmicpc.net/problem/11729

    // 재귀 함수는 f(n) = f(n-1) + f(n-2) 처럼 잘게 쪼개어 생각하면 쉽다.
    // 재귀 함수는 "점화식"으로 생각하면 편하다

    // n개의 원판을 1번 장대에서 3번 장대로 옮기는 것이 목표

    /**
     * 아이디어는 다음과 같다
     *
     * 1. 1번 장대에 가장 큰 원판 하나를 남긴 후 n-1개의 원판을 2번 장대로 옮김.
     * 2. 1번 장대에 남아있는 가장 큰 원판을 3번으로 옮긴다
     * 3. 2번의 n-1개의 원판을 3번으로 옮긴다
     *
     * => 재귀적 구현 (원판이 하나 남으면 print)
     */

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        sb.append( (int) Math.pow(2, n) - 1).append("\n");

        Hanoi(n, 1, 2, 3);

        System.out.println(sb);
    }

    public static void Hanoi(int N, int start, int mid, int to) {
        // N: 이동 개수
        // start : 시작 위치
        // mid : 옮기기 위해 이동해야 할 장소 (start, to가 아닌 나머지 하나의 장대)
        // to : 목표 위치

        // 원판이 하나 남으면 프린트
        if (N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        // 1번 장대 -> 2번 장대로 (n-1)개 이동
        Hanoi(N-1, start, to, mid);

        // 1번 장대 -> 3번 장대로 1개 이동 (원판이 1개이므로 프린트)
        sb.append(start).append(" ").append(to).append("\n");

        // 2번 장대 -> 3번 장대로 N-1개 이동
        Hanoi(N-1, mid, start, to);
    }
}
