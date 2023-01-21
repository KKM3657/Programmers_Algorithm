import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Main {
    static int N, M, L, K;
    static ArrayList<Pair> al = new ArrayList<>();
    public static int boundStar(int x, int y) {
        int result = 0;
        for(Pair pair : al){    // 좌표안에 들어가는지 판별
            if(x <= pair.x && pair.x <= x+L && y <= pair.y && pair.y <= y+L) 
                result++;
        }
        return result;
    }
    public static void find_answer() {
        int answer = 0;
        for(Pair value : al) {  // x좌표 고정
            for(Pair temp: al) {    // y좌표 고정
                answer = Math.max(answer, boundStar(value.x, temp.y));
            }
        }
        System.out.println(K-answer);   // 정답
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //가로
        M = Integer.parseInt(st.nextToken());   //세로
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            al.add(new Pair(x,y));
        }
        find_answer();
    }
}