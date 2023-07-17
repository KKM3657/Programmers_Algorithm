import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int value;
    int cnt;

    Pair(int value, int cnt){
        this.value = value;
        this.cnt = cnt;
    }
}
public class Main{
    static int end;
    static int[] dp;
    static boolean[] visited;

    public static void find_answer(int value){
        dp[value] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(value, 0));
        visited[value] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.value > 100000)
                continue;
            if(curr.value < 0)
                continue;

            else if(curr.value < end){
                // 2배
                if(curr.value*2 <= 100000){
                    if(visited[curr.value*2]){
                        dp[curr.value*2] = Math.min(dp[curr.value*2], curr.cnt);
                    }
                    else{
                        q.add(new Pair(curr.value*2, dp[curr.value]));
                        visited[curr.value*2] = true;
                        dp[curr.value*2] = dp[curr.value];
                    }

                }

                if(curr.value+1 <= 100000){
                    if(visited[curr.value+1]){
                        dp[curr.value+1] = Math.min(dp[curr.value+1], curr.cnt+1);
                    }
                    else{
                        q.add(new Pair(curr.value+1, dp[curr.value]+1));
                        visited[curr.value+1] = true;
                        dp[curr.value+1] = dp[curr.value]+1;
                    }

                }

            }
            if(curr.value-1 >= 0){
                if(visited[curr.value-1]){
                    dp[curr.value-1] = Math.min(dp[curr.value-1], curr.cnt+1);
                }
                else{
                    q.add(new Pair(curr.value-1, dp[curr.value]+1));
                    visited[curr.value-1] = true;
                    dp[curr.value-1] = dp[curr.value]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dp = new int[100001];
        visited = new boolean[100001];
        find_answer(start);
        System.out.println(dp[end]);
    }
}