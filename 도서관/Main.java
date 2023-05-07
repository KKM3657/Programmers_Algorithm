import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> pos = new ArrayList<>(); // 양수 리스트
        ArrayList<Integer> neg = new ArrayList<>(); // 음수 리스트

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value < 0)
                neg.add(value);
            else
                pos.add(value);
        }
        Collections.sort(neg);  // 음수는 오름차순 정렬
        Collections.sort(pos, Collections.reverseOrder());  // 양수는 내림차순 정렬
        
        int max = 0;
        if(!neg.isEmpty() && !pos.isEmpty()){   // 두 리스트에 값이 있으면 절대값이 최대인 값을 탐색
            if(Math.abs(neg.get(0)) < Math.abs(pos.get(0)))
                max = Math.abs(pos.get(0));
            else
                max = Math.abs(neg.get(0));
        }
        else if(neg.isEmpty())  // 하나라도 빈 리스트면 최대값은 고정
            max = Math.abs(pos.get(0));
        else
            max = Math.abs(neg.get(0));
        
        int answer = 0;
        // 양수
        for(int i=0; i<pos.size(); i++){
            if(i % K == 0)
                answer += (pos.get(i) * 2);
        }
        // 음수
        for(int i=0; i<neg.size(); i++){
            if(i % K == 0)
                answer -= (neg.get(i) * 2);
        }
        answer -= max;  // 0으로 되돌아갈 필요가 없음
        System.out.println(answer); 
    }
}