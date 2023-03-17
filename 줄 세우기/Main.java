import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> temp = new LinkedList<>();
        int[] degree = new int[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            degree[v2]++;
        }

        for(int i=1; i<=N; i++) {
            if(degree[i] == 0)
                temp.add(i);
        }

        while(!temp.isEmpty()){
            int node = temp.poll();

            for(Integer i : list.get(node)){
                degree[i]--;
                if(degree[i] == 0){
                    temp.add(i);
                }
            }
            System.out.print(node + " ");
        }
    }
}