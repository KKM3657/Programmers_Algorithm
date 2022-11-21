import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> deque = new LinkedList<>();

        int r_count = 0;	// 2, 3번 연산 횟수 누적 합 변수
        int l_count = 0;

        String[] input_array = br.readLine().split("");
        String[] find_array = br.readLine().split("");

        int n = input_array.length;	// 큐의 크기(1 ~ N)
        int m = find_array.length;	// 뽑으려는 숫자의 개수

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 0; i < n; i++) {
            deque.offer(input_array[i]);
        }


        for(int i = 0; i < m; i++) {
            int target_idx = deque.indexOf(find_array[i]);
            int half_idx;

            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            }
            else {
                half_idx = deque.size() / 2;
            }
            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                    String temp = deque.pollFirst();
                    deque.offerLast(temp);
                    r_count++;
                }
            }
            else {
                for(int j = 0; j < deque.size() - target_idx; j++) {
                    String temp = deque.pollLast();
                    deque.offerFirst(temp);
                    l_count++;
                }
            }
        }
        System.out.println(r_count+ l_count + m + " " + r_count + " " + l_count);
    }
}