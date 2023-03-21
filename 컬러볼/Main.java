import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Ball {
	int idx;
	int s;
	int c;

	Ball(int idx, int c, int s){
		this.idx = idx;
		this.c = c;
		this.s = s;
	}	
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Ball[] ball = new Ball[N];	// 공

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			ball[i] = new Ball(i, color, size);
		}
		Arrays.sort(ball, (a,b) -> (a.s - b.s));	// 크기 별로 정렬
		
		int[] result = new int[N];
        int[] colors = new int[N + 1];
        int b_idx = 0;
        int sum = 0;
		for(int i=0; i<N; i++){
			Ball cur = ball[i];	// 해당하는 공
            while(ball[b_idx].s < cur.s) {	// 1번 공부터 크기가 작은 공을 탐색
                sum += ball[b_idx].s;	// 크기가 작은 공의 합
                colors[ball[b_idx].c] += ball[b_idx].s;	// 중복된 색깔인 공의 합
                b_idx++;
            }
            result[cur.idx] = sum - colors[cur.c];	// 조건을 만족하는 공의 크기 합
		}
		for(int i=0; i<N; i++){
			System.out.println(result[i]);
		}
    }
}