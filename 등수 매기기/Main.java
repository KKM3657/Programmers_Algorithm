import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 초기화
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // 정렬
        Arrays.sort(arr);
        // 등수 차이의 최소값 구하기
        
        long answer = 0;
        for(int i=0; i<N; i++){
            answer += Math.abs(arr[i] - (i+1));
        }
        System.out.println(answer);
    }
}