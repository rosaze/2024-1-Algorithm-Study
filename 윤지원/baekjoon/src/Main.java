/**
문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

문제 해결 : 이 문제는 DP 를 사용하여 해결한다. 작은 부분 문제를 해결하고 그 결과를 저장해 두었다가, 이를 활용하여 더 큰 문제를
해결하는 방식이다.
 핵심 로직: i-1개의 숫자로 여러 가지 합을 만들 수 있는 경우의 수를 알아야, 이를 기반으로 i개의 숫자로 j를 만드는 경우의 수를 계산
 이전 단계에서여러 가지 합을 만들 수 있는 모든 경우를 합산하여, 현재 단계에서 j를 만드는 경우를 계산


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long dp[][];
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 받기 (n,k)
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long[201][201]; //i 개의 숫자로 합이 j이 되는 경우의 수
        if (n == 1) { // 모든 숫자를 더한 결과가 1인 경우이므로, 단순히 k값을 출력.
            System.out.println((k)%1000000000);
            return;
        }
        if (k == 1) { //하나의 숫자만으로 n을 만드는 경우는 오직 하나이므로 1을 출력
            System.out.println(1);
            return;
        }
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1; //숫자 1개로 i를 만드는 경우는 오직 1개
            dp[2][i] = i+1;// 숫자 2개로 i를 만드는 경우: 첫 번째 숫자를 0부터 i까지로 설정하고, 나머지 하나를 결정
        }

        dynamicOp(2); //2부터 시작하여, k개의 숫자로 N을 만들 수 있는 경우의 수를 동적으로 계산

        System.out.println(dp[k][n]);
    }
// 함수 : 주어진 use 갑을 증가시키면서 dp 테이블을 갱신
    static void dynamicOp(int use) {
        while (true) {
            if (use > k) {
                return;
            }
            for (int i = 3; i <= use; i++) {
                long value = 0; // 경우의 수 누적해서 저장. 값을 10억으로 나눈 나머지 저장
                for (int j = 0; j <= n; j++) {
                    value += (dp[i - 1][j])%= 1000000000; //이전 단계 값을 더함
                    dp[i][j] = value%1000000000;// 값을 나머지로 저장
                }
            }
            use++;
        }
    }
}