/**
 *문제
 * N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.
 *
 * 버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다.
 *
 * 출력
 * 첫째 줄에 Swap 횟수를 출력한다
 *
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class bubble {
    public static int[] array; // 원본배열, 최종 정렬된 결과를 담는 배열로, 병합 과정에서 정렬된 값을 채워 넣으며 점차 정렬 상태로 완료
    // 재귀저긍로 배열을 작은 단위로 나눈 후, 정렬된 작은 부분 배열들을 병합하여 array 에 순차적으로 채워 넣음
    //array[k] 에 오른쪽 배열 값이 들어가면, 해당 값이 정렬 과정에서 앞에 있는 값을 몇 개 밀어냈는지를 기준으로 swap 횟수 증가
    public static int[] temp;// 병합 과정에서 사용할 임시 배열
    public static long swap;// swap 횟수 저장할 변수, 최종 출력 결과

    //병합 정렬의 함수: 배열을 두 부분으로 나누고, 각각을 재귀적으로 정렬한 후 병합
    public static void MergeSort(int a, int b){
        if(b-a<1){return;} //배열 크기 1 이하인 경우 재귀 종료
        int middle= a+(b-a)/2;// 중간 지점 계산
        MergeSort(a,middle);// 왼쪽 절반은 재귀적으로 정렬
        MergeSort(middle+1,b);// 오른쪽 절반을 재귀적으로 정렬

        for(int i=a;i<=b; i++){temp[i]=array[i];} //temp 배열에 현재 범위의 배열 요소 복사

        int k=a; // 병합된 배열을 작성할 인덱스
        int left=a; //왼쪽 부분 배열의 시작 인덱스
        int right=middle+1; //오른쪽 부분 배열의 시작 인덱스
        //왼쪽과 오른쪽 부분 배열의 요소들을 하나씩 비교하여 작은 값을 array 에 넣고, k 증가
        while(left<=middle && right <=b){
            if(temp[left]<=temp[right]){ //중요!!!!!!!!!!!!!!!이거떄매 틀림
                array[k++] =temp[left++]; //왼쪽이 오른쪽 요소 보다 작아서 순서대로 배열에 추가
            } else{ // 오른쪽이 왼쪽 요소보다 작기 때문에 실제로 swap 발생
                array[k]= temp[right++];
                swap+=(right -1-k); //오른쪽 요소가 왼쪽 요소보다 작다면 swap 횟수 추가
                // 정렬되지 않은 오른쪽 요소가 현재 k 위치에 들어가면서 발생한 뒤처짐 횟수 의미
                k++;
            }
        }
        while(left<=middle){ // 왼쪽 부분에 남은 요소 처리
            array[k++]=temp[left++];
        }
        //첫번째 while 문에서 왼쪽 부분 배열이 모두 채워진 경우-> 오른쪽 부분 배열의 나머지 요소들을 array 에 채워 넣음
        while(right<=b){// 오른쪽 부분에 남은 요소 처리
            array[k++]=temp[right++];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()); // 배열의 크기 입력 받음
        StringTokenizer st= new StringTokenizer(br.readLine()); //배열 요소 입력받음
        array= new int[N+1];
        temp=new int[N+1];
        for(int i=1; i<=N; i++){
            array[i]=Integer.parseInt(st.nextToken());
        }
        swap=0;
        MergeSort(1,N); // 병합 정렬 및 swap 횟수 계산 수행
        StringBuilder sb= new StringBuilder();
        sb.append(swap); //swap 횟수 결과 출력
        System.out.println(sb);

    }
}
