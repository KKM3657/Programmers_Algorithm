import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        long lo = 1;
		long hi = K;
		
		// lower-bound
		while(lo < hi) {
			
			long mid = (lo + hi) / 2;	// 임의의 x(mid)를 중간 값으로 잡는다.
			long count = 0;
			
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			
			// count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻
			if(K <= count) {
				hi = mid;
			}
			else {
				lo = mid + 1;
			}
		}
		
		System.out.println(lo);
	}
}