import java.util.*;
import java.util.Scanner;
//다익스트라
public class short2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E= sc.nextInt();

        //인접 리스트로 표현~
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            graph.add(new ArrayList<>());
        }

        //초기 상태  인접 리스트에 추가
        for( int i=0; i<E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[]{v, w});
            //graph.get(u) : u 에 연결된 모든 간선정보(목적지, 가중치)
            // u --> v 로 가는 가중치 w 를 간선 정보로 추가
        }

        //시작정점에서 각 정점까지의 최단 거리 배열
        int[] dist= new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE); //초기화
        dist[0]=0; //시작 정점

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        //Comparator. comparingInt(a -> a[1]) 우선순위 큐에서 정렬 기준. 배열 a 의 두 번째 값 a[1]을 기준으로 정렬하겠다는
        // pq 에서 거리가 작은 정점을 우선적으로 처리하도록 정렬
        pq.add(new int[]{0,0});


        while(!pq.isEmpty()) {
            int[] cur = pq.poll(); // 현재 가장 짧은 거리 값을 가진 정점 반환
            int now = cur[0]; //정점 번호
            int cost = cur[1]; // 시작점- 현재까지의 누적 비용 (거리)

            // 큐에서 꺼낸 경로 cost 가 이미 계산된 최단 거리보다 클 경우
            if (cost > dist[now]) continue;
            for (int[] edge : graph.get(now)) {
                int next = edge[0]; //현재 정점에서 연결된 다른 정점
                int weight = edge[1]; //간선의 가중치

                if (cost + weight < dist[next]) {
                    dist[next] = cost + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
// 결과 출력

        System.out.println(dist[V]);




    }
}


