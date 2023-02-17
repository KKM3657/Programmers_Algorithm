import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
// 좌표와 시간을 위한 클래스
class Pair{
    int x;
    int t;

    Pair(int x, int t){
        this.x = x;
        this.t = t;
    }
}
public class Main {
    static int N, K;
    static int[] visited = new int[100001]; // 이전 방문위치 기록
    // 너비 우선 탐색
    public static int bfs() {
        Queue<Pair> q = new LinkedList<>(); // 다음 방문 위치
        q.add(new Pair(N,0));   // 초기화
        int answer = 0;
        // 좌표가 같은 경우
        if(N == K){
            return answer;
        }

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            // 3가지 경우 탐색
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = curr.x - 1;    // -1인 경우
                else if (i == 1) nx = curr.x + 1;   // +1인 경우
                else nx = curr.x * 2;   // *2인 경우

                if (nx < 0 || nx > 100000)  // 범위를 벗어나면 넘어감
                    continue;

                if (visited[nx] == -1) {    // 이전에 방문한 적이 없으면 기록
                    visited[nx] = curr.x;
                    if (nx == K) {  // 정답
                        answer = curr.t + 1;
                        break;
                    }
                    q.add(new Pair(nx, curr.t + 1));    //다음으로 이동할 위치 저장
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(visited, -1);

        int answer = bfs();

        // 순서대로 구하기 위해 stack 에 담았다가 다시 pop
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(visited[index]);
            index = visited[index];
        }

        // 최종 출력
        StringBuilder sb = new StringBuilder();
        sb.append(answer + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}