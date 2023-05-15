import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N;
    static int[] end_arr;
    public static int getAnswer(int answer, int[] arr) {
        for(int i = 1; i < N; i++) {
            if (arr[i-1] != end_arr[i-1]) { // i-1이 같은지 확인후 다르면 반영
                arr[i-1] = 1 - arr[i-1];
                arr[i] = 1 - arr[i];
                answer++;
                if (i != N-1)   //  i+1 바꾸기
                    arr[i+1] = 1 - arr[i+1];
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String start = br.readLine();
        String end = br.readLine();
        int answer1 = 1, answer2 = 0;
        int[] arr1 = new int[N], arr2 = new int[N];
        end_arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr1[i] = start.charAt(i)-'0';  //1번 스위치 누른경우
            arr2[i] = start.charAt(i)-'0';  //1번 스위치 누르지 않은 경우
            end_arr[i] = end.charAt(i)-'0';
        }
        arr1[0] = 1-arr1[0];    // 1번 스위치 누른경우
        arr1[1] = 1-arr1[1];    // 1번 스위치 누른경우

        answer1 = getAnswer(answer1, arr1); // 1번 스위치 누른경우
        answer2 = getAnswer(answer2, arr2); // 1번 스위치 누르지 않은 경우

        if(arr1[N-1] != end_arr[N-1])
            answer1 = Integer.MAX_VALUE;
        if(arr2[N-1] != end_arr[N-1])
            answer2 = Integer.MAX_VALUE;

        if(answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(Math.min(answer1, answer2));
    }


}