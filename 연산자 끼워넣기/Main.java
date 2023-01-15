import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, oper;
    static char[] operator = new char[] {'+', '-', '*', '/'};
    public static void find_answer(int curr, int value) {
        // 최대 최소 구하기
        if(curr == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        // 사칙연산 기호 확인
        for(int i=0; i<4; i++) {
            if(oper[i] == 0)
                continue;
            oper[i] -= 1;   // 사용
            switch(operator[i]) {
                // + 인 경우
                case '+':
                    find_answer(curr+1, value + arr[curr]);
                    break;
                // - 인 경우
                case '-':
                    find_answer(curr+1, value - arr[curr]);
                    break;
                // * 인 경우
                case '*':
                    find_answer(curr+1, value * arr[curr]);
                    break;
                // / 인 경우
                case '/':
                    if(value < 0) { // 음수인 경우
                        value = -(value);
                        find_answer(curr+1, -(value / arr[curr]));
                    } else
                        find_answer(curr+1, value / arr[curr]);
                    break;
            }
            oper[i] += 1;   // 복구
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        oper = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        find_answer(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}