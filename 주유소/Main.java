import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] road = new long[n-1];
        long[] gas = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
		long min_gas = gas[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < n - 1; i++) {
			
			if(gas[i] < min_gas) {
				min_gas = gas[i];
			}
			answer += (min_gas * road[i]);	// 총 비용 누적 합
		}
		System.out.println(answer);

    }
}