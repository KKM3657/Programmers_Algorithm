import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N], answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){ // 순회
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i])   // 스택에 있는 값보다 현재 값이 크면 해당하는 부분 값 갱신
                answer[stack.pop()] = arr[i];
            stack.add(i);
        }
        while(!stack.isEmpty()) // 뒤에 큰 수가 없는 경우 -1
            answer[stack.pop()] = -1;
        
        for(int i=0; i<N; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}