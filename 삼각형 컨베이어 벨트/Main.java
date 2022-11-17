import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Deque<Integer> first = new LinkedList<>();
        Deque<Integer> second = new LinkedList<>();
        Deque<Integer> third = new LinkedList<>();

        // 컨베이어 입력
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
            first.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
            second.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
            third.add(Integer.parseInt(st.nextToken()));
        }

        // 컨베이어 이동
        for(int i=0; i < t; i++){
            int num1 = first.removeLast();
            second.addFirst(num1);

            int num2 = second.removeLast();
            third.addFirst(num2);

            int num3 = third.removeLast();
            first.addFirst(num3);
        }

        // t초후의 컨베이어 상태 출력
        for(Integer value : first)
            System.out.print(value + " ");
        System.out.println("");

        for(Integer value : second)
            System.out.print(value + " ");
        System.out.println("");

        for(Integer value : third)
            System.out.print(value + " ");
        System.out.println("");
    }
}