import java.util.*;
import java.util.Scanner;

public class HideAndSeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //수빈
        int b = sc.nextInt();//동생
        int cnt = 0; //최종 시간

        //큐와 방문 배열 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        //초기 상태 큐에 추가: 현재 위치, 걸린 시간
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
                //가능한 이동 큐에 추가
                queue.add(new int[]{num * 2, time+1});
                queue.add(new int[]{num - 1, time + 1});
                queue.add(new int[]{num + 1, time + 1});
            }
        }
        //backtracking

        List<Integer> path= new ArrayList<>();
        int currentPos=b;
        while(currentPos!=a) {
            path.add(currentPos);
            if (currentPos % 2 == 0 && visited[currentPos / 2]) {
                currentPos /= 2;
            } else if (currentPos - 1 >= 0 && visited[currentPos - 1]) {
                currentPos -= 2;
            } else if (currentPos + 1 <= 100000 && visited[currentPos + 1]) {
                currentPos += 1;
            }
    }
        path.add(a);
        Collections.reverse(path);
        System.out.println(cnt);
        for (int pos : path) {
            System.out.print(pos + " ");
        }
        System.out.println(); // 줄바꿈

        /*System.out.println(String.join(" ", path.stream()
                .map(String::valueOf)
                .toArray(String[]::new)));

         */
    }
}
