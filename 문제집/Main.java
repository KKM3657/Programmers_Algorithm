import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int N, T;
    static void topologicalSort(int[] indegree, List<List<Integer>> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0)
                pq.offer(i);
        }
 
        while(!pq.isEmpty()) {
            int node = pq.poll();
 
            for(Integer i : list.get(node)) {
                indegree[i]--;
 
                if(indegree[i] == 0)
                    pq.offer(i);
            }
 
            System.out.print(node + " ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] indegree = new int[N+1];
 
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<Integer>());
 
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
 
            // v1 -> v2
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
 
            list.get(v1).add(v2);
            indegree[v2]++;
        }
 
        topologicalSort(indegree, list);   
    }
}