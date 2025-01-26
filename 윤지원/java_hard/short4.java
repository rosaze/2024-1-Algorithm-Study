import java.util.*;
import java.util.Scanner;

//1번부터 정점까지 가는 데 거치는 정점들 번호 출력하는 문제
public class short4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[]{v, w});
        }
        int start = sc.nextInt(); // 출발 정점
        int end = sc.nextInt();   // 도착 정점

        int[] dist = new int[V+1];
        int[] prev = new int[V+1]; // 최단 경로 추적을 위한 이전 정점 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1); // 이전 정점 배열 초기화
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] edge : graph.get(now)) {
                int next = edge[0];
                int weight = edge[1];

                if (cost + weight < dist[next]) {
                    dist[next] = cost + weight;
                    prev[next] = now; // 최단 경로 갱신 시 이전 정점 저장
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        // 경로가 없는 경우 처리
        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(dist[end]); //최소거리

        // 경로 저장을 위한 StringBuilder 사용
        StringBuilder path = new StringBuilder();
        for(int at = end; at != -1; at = prev[at]) {
            path.insert(0, at + " ");
        }
        // 마지막 공백 제거하고 출력
        System.out.println(path.toString().trim().split(" ").length);
        //System.out.println(path.toString().trim());
    }
}