import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        long[][] DP = new long[101][21];
        
        st = new StringTokenizer(br.readLine());
        // 입력
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 초기화
        DP[1][arr[1]] = 1;
        // 모든 시행
        for(int i=2; i<=100; i++) {
            for(int j=0; j<21; j++) {
                if(DP[i-1][j]!=0){  // 기존 값이 아니라면 넘어감
                    int plus = j+arr[i];    // 더하기
                    int minus = j-arr[i];   // 빼기
                    if(0 <= plus && plus <= 20) // 범위를 벗어나지 않는 경우 추가
                        DP[i][plus] += DP[i-1][j];
                    if(0 <= minus && minus <= 20)   // 범위를 벗어나지 않는 경우 추가
                        DP[i][minus] += DP[i-1][j];
                }
            }
        }
        System.out.println(DP[N-1][arr[N]]);
    }
}

// 타임 아웃 DFS
// public class Main {
//     static int N; 
//     static long answer = 0;
//     static int[] arr;
//     public static void find_answer(int curr, int value) {
//         if(curr == N-1) {
//             if(arr[curr] == value)
//                 answer++;
//             return; 
//         }
//         if(value > 20 || value < 0)
//             return;
        
//         find_answer(curr+1, value + arr[curr]);
//         find_answer(curr+1, value - arr[curr]);
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         N = Integer.parseInt(st.nextToken());
//         arr = new int[N];
        
//         st = new StringTokenizer(br.readLine());
        
//         for(int i=0; i<N; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         find_answer(1,arr[0]);
//         System.out.println(answer);
//     }
// }