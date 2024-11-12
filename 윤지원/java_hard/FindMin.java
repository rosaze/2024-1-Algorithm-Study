/**
 * 문제
 * N개의 수 A1, A2, ..., AN과 L이 주어진다.
 *
 * Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
 *
 * 입력
 * 첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
 *
 * 둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
 *
 * 출력
 * 첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
 *
 * 이 문제에서는 슬라이딩 윈도우의 약점을 개선하기 위해 덱을 써야 한다.
 *  순수한 슬라이딩 윈도우라면 [a,b,c] 갱신마다 O(K)의 연산이 소요되고,
 *  이는 최악의 경우 O(K^2)을 일으키기 충분하다는 것이다.
 *
 * 시간 복잡도 : O(N)
 *
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.*;


public class FindMin {

    static class Node{
        public int value;
        public int index;
        //배열의 각 요소를 value 와 index를 갖는 노드로 표현. 인덱스 정보를 저장하여
        //슬라이딩 윈도우의 범위를 초과하는 요소를 효율적으로 제거할 수 있도록 한다.
        Node(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());// 배열의 요소들을 읽어옴

        Deque<Node> dq= new LinkedList<>(); //덱을 linkedlist 로 초기화.
        //위 덱을 슬라이딩 윈도우에 상요할 것임.
        for(int i=0; i<n;i++){//배열의 모든 요소에 대해 처리
            int current=Integer.parseInt(st.nextToken());
            // 덱의 마지막 요소가 현재 요소보다 크다면 헤당 요소 제거
            while(!dq.isEmpty() && dq.getLast().value>current){
                dq.removeLast();
            }
            dq.addLast(new Node(current,i)); //현재 요소 추가
            //현재요소와 인덱스를 Node 객체로 생성하고 덱의 끝에 추가.
            //윈도우 범위를 벗어난 요소 제거

            //슬라이딩 윈도우의 크기 L을 초과하여 인덱스 범위가 벗어난 요소는 덱의 앞에서 제거
            if(dq.getFirst().index<=i-l){//윈도우에서 벗어난 값이면 제거. 덱의 앞 요소를 확인하는 것.
                dq.removeFirst();
            }
            //덱의 첫 번째 요소 (dq.getFirst() 가 현재 윈도우에서의 최소값이므로 , 해당 값을 출력 버퍼에 추가
            //덱에 원소 추가, 제거, 추가, 제거 반복하면서, 덱의 앞에는 현재 윈도우에서 최소값을 나타내는 요소가 위치.
            bw.write(dq.getFirst().value+" ");
        }
        //모든 출력 저장한 후 flush 와 close 메서드 호출하여 출력
        bw.flush();bw.close();

    }
}
