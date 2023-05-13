import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();   // 레이저가 도달하는 위치를 확인하기 위한 스택
        int[] answer = new int[N+1];

        for(int i=1; i<=N; i++){
            while(!stack.isEmpty()){    // 도달하는 위치 탐색
                if(arr[stack.peek()] <= arr[i]) // 레이저가 도달하지 않으면 pop
                    stack.pop();
                else{
                    answer[i] = stack.peek();   // 레이저가 도달하는 경우 기록
                    break;
                }
            }
            stack.push(i);  // 다음 지점으로 이동
        }
        for(int i=1; i<=N; i++)
            System.out.print(answer[i] + " ");
    }
}