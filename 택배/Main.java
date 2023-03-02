import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int max_w = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][3];
        // 입력
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 도착 지점 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
            }
        });
        // 최대 무게 구하기
        int[] weight = new int[N + 1];
        for (int i = 1; i < N; i++) {
            weight[i] = max_w;
        }

        int answer = 0;
        for(int i=0; i<t; i++) {
            // 최대 박스 구하기
            int maxBoxNum = Integer.MAX_VALUE;

            for(int j = arr[i][0]; j<arr[i][1]; j++) {
                maxBoxNum = Math.min(maxBoxNum, weight[j]);
            }
            // 기준 박스를 다 넣을 수 있는 경우
            if(maxBoxNum >= arr[i][2]) {
                for(int j = arr[i][0]; j<arr[i][1]; j++) {
                    weight[j] -= arr[i][2];
                }
                answer += arr[i][2];
            } else {    // 기준 박스를 초과하여 여분만 넣는 경우
                for(int j = arr[i][0]; j<arr[i][1]; j++) {
                    weight[j] -= maxBoxNum;
                }
                answer += maxBoxNum;
            }
        }
        System.out.println(answer);
    }
}