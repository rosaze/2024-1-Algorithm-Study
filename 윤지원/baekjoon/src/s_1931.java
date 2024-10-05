import java.util.*;

/**
 * 문제
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 * 입력
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 *
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 *
 * 문제풀이: 뒷 시간 기준으로 정렬한 뒤, 순회하면서 겹치지 않는 회의시간 쌍을 고른다.
 * 이 알고리즘의 최적의 해를 찾는 이유: 먼저 종료 시간이 가장 빠른 회의로 정렬하고 선택하므로, 남은 시간에 더 많은 회의를 배정할 수 있는 가능성이
 * 높아진다. 또한 각 단계에서 가증한 가장 빨리 끝난느 회의를 선택하여 가장 많은 회의를 선택하게 되는 것이다.
 * 이 문제는 그리디 알고리즘의 전형적인 예시이다. 각 단계에서 현재 상황에서 가장 좋아보이는 선택을 하면, 결과적으로 전체 문제의 최적해를 찾을 수 있다.
 *
 *
 */
public class s_1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input : 회의의 수
        int N = scanner.nextInt();
        int count = 0;
        int[][] room = new int[N][2];// 회의 시작 시간, 종료 시간 입력 배열 

        for (int i = 0; i < N; i++) {
            room[i][0] = scanner.nextInt(); //시작
            room[i][1] = scanner.nextInt();// 종료
        }
        // 회의를 종료 시간 기준으로 정렬 
        Arrays.sort(room,(a,b)->{
            if (a[1]==b[1]){
                return Integer.compare(a[0],b[0]); // 종료 시간이 같으면 시작 시간 기준
            }else{
                return Integer.compare(a[1],b[1]);// 종료 시간 기준 정렬
            }
        });
        int currentEndtime=0; // 현재 회의의 종료 시간
        int cnt=0; // 선택된 회의의 수
// 모든 회의를 순회하면서 겹치지 않는 회의 선택
        for (int i=0;i<N;i++){
            if (currentEndtime<=room[i][0]){ // 이전 종료시간이 현재 회의 시작시간과 겹치지 않으먼
                cnt++;
                currentEndtime=room[i][1];
            }
        }
        System.out.println(cnt);



    }
}
