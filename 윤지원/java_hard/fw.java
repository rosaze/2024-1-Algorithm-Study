import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fw {

    static int v, e;
    static int[][] map;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0; //자기자신으로 가는 경로 비용 항상 0으로
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from][to] = cost;
        }

        // Floyd-Warshall 알고리즘
        //map[i][k] + map[k][j] : 정점 i에서 k를 거쳐 j 로 가는 경로의 비용

        for (int k = 1; k <= v; k++) { //중간 노드
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);// 더 작은 값으로 업데이트

                    }
                    System.out.print(map[i][j] + " ");
                }
            }
        }

        // 사이클 확인
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                if (map[i][j] != Integer.MAX_VALUE && map[j][i] != Integer.MAX_VALUE) {
                    result = Math.min(result, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
}
