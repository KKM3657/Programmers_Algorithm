import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] arr;
    // 해당 거리에 대한 공유기 최대 설치 갯수
    public static int isPossible(int dis){
        int count = 1;  // 0번 집에 설치 고정
        int prev_lo = arr[0];   // 0번에 공유기 설치

        for(int i=1; i<arr.length; i++) {
            int curr_lo = arr[i];   // 현재 위치
            if(curr_lo - prev_lo >= dis){   // 최소거리에 만족하는지 확인
                count++;
                prev_lo = curr_lo;  // 갱신
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        int L = 1, R = arr[arr.length - 1] - arr[0] + 1;    // 최소 거리의 최소값과 최대값
        while(L <= R){
            int mid = (L + R) / 2;  // 중간점
            if(isPossible(mid) >= M) {  // 최소 거리가 만족하는지 확인
                answer = mid;   // 만족하는 경우 정답
                L = mid+1;  // 높은 범위 확인
            }
            else{
                R = mid-1;  // 만족하지 못하여 낮은 범위 확인
            }
        }
        System.out.println(answer);
    }
}