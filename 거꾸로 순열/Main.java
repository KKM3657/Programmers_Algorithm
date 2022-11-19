import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
public class Main {
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static int[] visited;
    // 순열 출력
    public static void answer_print(){
        for(Integer value : stack){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    // 거꾸로 순열 탐색
    public static void find_num(int curr){
        if(curr == 0){
            answer_print();
            return;
        }
        for(int i=n; i>0; i--){
            if(visited[i] == 1)
                continue;
            visited[i] = 1;
            stack.add(i);
            find_num(curr-1);
            visited[i] = 0;
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n+1];
        find_num(n);
    }
}