import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][3];
        int[] team_t = new int[3];  // 팀 점수 저장

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " :");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 팀
            arr[i][1] = Integer.parseInt(st.nextToken());   // 시
            arr[i][2] = Integer.parseInt(st.nextToken());   // 분
        }

        // 시 분을 오름차순으로 정렬
        Arrays.sort(arr, (a, b) -> {
            return a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]; 
        });

        int curr = 0, team_a = 0, team_b = 0;   // 이기고 있는 시간
        
        for(int i=0; i<48; i++) {   // 시
            for(int j=0; j<60; j++){    // 분
                if(curr < n && i == arr[curr][1] && j == arr[curr][2]){ // 점수 반영
                    team_t[arr[curr][0]]++;
                    curr++;
                }
                if(team_t[1] > team_t[2])   // 1팀이 이기고 있는 시간
                    team_a++;
                else if(team_t[1] < team_t[2])  // 2팀이 이기고 있는 시간
                    team_b++;
            }
        }
        System.out.printf("%02d:%02d\n",team_a/60, team_a%60);
        System.out.printf("%02d:%02d\n",team_b/60, team_b%60);
    }
}