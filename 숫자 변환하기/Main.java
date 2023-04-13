import java.util.Queue;
import java.util.LinkedList;
class Oper{
    int value;
    int cnt;
    
    Oper(int value, int cnt){
        this.value = value;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        boolean[] visited = new boolean[1000001];   // 방문기록
        Queue<Oper> q = new LinkedList<>(); // 큐
        q.add(new Oper(x, 0));
        visited[x] = true;  // 시작점 방문
        // 큐가 빌때까지 반복
        while(!q.isEmpty()) {
            Oper curr = q.poll();   // 현재 위치
            if(curr.value == y) // 목표값에 도달하면 멈춤
                return curr.cnt;
            else {
                // + n인 경우
                if(curr.value + n <= y && !visited[curr.value + n]){
                    q.add(new Oper(curr.value + n, curr.cnt+1));
                    visited[curr.value + n] = true;
                }
                // * 2인 경우
                if(curr.value * 2 <= y && !visited[curr.value * 2]){
                    q.add(new Oper(curr.value * 2, curr.cnt+1));
                    visited[curr.value * 2] = true;
                }
                // * 3인 경우
                if(curr.value * 3 <= y && !visited[curr.value * 3]){
                    q.add(new Oper(curr.value * 3, curr.cnt+1));
                    visited[curr.value * 3] = true;
                }
            }
        }
        return -1;
    }
}