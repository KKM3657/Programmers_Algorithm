import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static final int MAX_K = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int p = 1;  // 자릿수 계산을 위한 변수
        for(int k = 0; k < MAX_K; k++){
            ArrayList<Integer>[] arrNew = new ArrayList[10];    // 0 ~ 9까지 저장할 ArrayList 배열 생성
            for(int i = 0; i < 10; i++)
                arrNew[i] = new ArrayList<Integer>();

            for(int i = 0; i < n; i++){
                int digit = (array[i] / p) % 10;    // 각 자리수에 대한 수 구하기
                arrNew[digit].add(array[i]);
            }

            int index = 0;
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < arrNew[i].size(); j++){  // 해당 숫자에 대해서 정렬 실시
                    array[index++] = arrNew[i].get(j);
                }
            }
            p *= 10;
        }

        for(int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }
}