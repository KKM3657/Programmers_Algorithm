import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    static int n, start;
    static int[] arr;
    static boolean[] visited;
    static LinkedList<Integer> answer_list = new LinkedList<>();
    // 깊이 우선 탐색
    public static void dfs(int curr){
        // 사이클이 생기는 경우 정답에 추가
        if(curr == start){
            answer_list.add(curr);
            return;
        }
        // 다음 지역으로 이동
        int next = arr[curr];
        // 방문 했다면 넘어감
        if(!visited[next]){
            visited[next] = true;
            dfs(next);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            start = i;
            int next =  arr[i];
            dfs(next);
        }
        Collections.sort(answer_list);
        System.out.println(answer_list.size());
        for(Integer value : answer_list)
            System.out.println(value);
    }
}