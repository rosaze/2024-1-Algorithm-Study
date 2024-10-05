//
/**
문제
 주어진 G값이 현재 몸무게의 제곱과 기억하고 있던 몸무게의 제곱의 차이라는 점에서,
 두 제곱수의 차를 만족하는 현재 몸무게를 찾아야 하는 문제

 풀이 :
 코드 설명
 약수 구하기: i가
 출력
 첫째 줄부터 한 줄에 하나씩 가능한 성원이의 현재 몸무게를 오름차순으로 출력한다. 가능한 몸무게가 없을 때는 -1을 출력한다. 현재 몸무게는 자연수로 떨어지지 않을 수도 있는데, 이런 경우는 제외해야 한다.
 G의 약수인지 확인하고, 약수이면 그에 대응하는 x와 y를 계산합니다.
 자연수 조건 확인: x와 y가 둘 다 짝수이거나 둘 다 홀수여야만 r과 l이 자연수가 될 수 있습니다.
 r과 l 비교:
 r>l이어야 하고,
 l≥1이어야 r과 l이 자연수 조건을 만족합니다.
 결과 출력: 가능한 r 값을 오름차순으로 정렬해 출력하며, 가능한 값이 없으면 -1을 출력합니다.
 주요 포인트
 r과 l이 자연수가 되어야 하기 때문에 (x + y)와 (x - y)가 모두 짝수 또는 모두 홀수인 경우만 처리합니다.
 r이 l보다 큰 경우에만 결과를 출력하도록 조건을 추가했습니다.
 반례로 주신 코드에서 l = 0이 되는 경우도 처리하여 제외했습니다.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long G = scanner.nextLong();  // 입력 G값
        ArrayList<Long> results = new ArrayList<>();

        // G의 약수들을 구해서 처리
        for (long i = 1; i * i <= G; i++) {
            if (G % i == 0) {
                long x = G / i;  // x = r + l
                long y = i;      // y = r - l

                // x와 y가 모두 홀수이거나 모두 짝수여야만 r과 l이 자연수로 나옴
                if ((x + y) % 2 == 0 && (x - y) % 2 == 0) {
                    long r = (x + y) / 2;
                    long l = (x - y) / 2;

                    // r과 l이 자연수이고, r이 l보다 클 때만 출력
                    if (r > l && l >= 1) {
                        results.add(r);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            System.out.println(-1);  // 가능한 몸무게가 없을 경우 -1 출력
        } else {
            Collections.sort(results);  // 결과를 오름차순으로 정렬
            for (long r : results) {
                System.out.println(r);
            }
        }
    }
}


