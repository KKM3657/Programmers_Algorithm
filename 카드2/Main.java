import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        // 카드 나열
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        // 조건 시행
        while(q.size() != 1){
            q.poll();   // 1개 제거
            int value = q.poll();   // 제일 위에있는 카드 밑으로 보내기
            q.add(value);
        }

        System.out.println(q.peek());
    }
}