import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n, m, cnt=0;
    static boolean[] visited;
    static ArrayList<Integer>[] al;
    public static void dfs(int curr){
        for(int i=0; i<al[curr].size(); i++){
            int next = al[curr].get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
                cnt++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        al = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++)
            al[i] = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1, b = Integer.parseInt(st.nextToken())-1;
            al[a].add(b);
            al[b].add(a);
        }

        visited[0] = true;
        dfs(0);
        System.out.print(cnt);
    }
}