import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
class Pair implements Comparable<Pair>{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    // 기준에 따른 compareTo 오버라이딩 정의
    @Override
    public int compareTo(Pair p){
        if(this.x + this.y != p.x + p.y)
            return (this.x + this.y) - (p.x + p.y);
        else{
            if(this.x != p.x)
                return this.x - p.x;
            else
                return this.y - p.y;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Pair(x,y));
        }

        for(int i=0; i<k; i++){
            Pair temp = pq.poll();
            pq.add(new Pair(temp.x+2, temp.y+2));
        }
        Pair answer = pq.poll();
        System.out.println(answer.x + " " + answer.y);
    }
}