import java.util.Scanner;
import java.util.*;

public class olympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //수빈
        int b = sc.nextInt();//동생
        int cnt = 0; //최종 시간

        //큐와 방문 배열 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        //현재 위치, 걸린 시간
        queue.add(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); //현재 위치와 시간
            int num = current[0];
            int time = current[1];

            //동생의 위치에 도달한 경우
            if (num == b) {
                cnt = time;
                break;
            }
            //현재 위치가 유효하고 아직 방문하지 않았음
            if (num >= 0 && num <= 100000 && !visited[num]) {
                visited[num] = true; // 방문 처리
                queue.add(new int[]{num * 2, time});
                queue.add(new int[]{num - 1, time + 1});
                queue.add(new int[]{num + 1, time + 1});
            }
        }
        System.out.println(cnt);
    }
}


