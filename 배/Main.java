import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 크레인 정보
        int C = Integer.parseInt(br.readLine());
        ArrayList<Integer> crain = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            crain.add(Integer.parseInt(st.nextToken()));
        
        // 박스 정보
        int B = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++)
            box.add(Integer.parseInt(st.nextToken()));

        // 내림차순 정렬
        Collections.sort(crain, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        
        // 불가능한 경우
        if(box.get(0) > crain.get(0)){
            System.out.println(-1);
            System.exit(0);
        }

        // 순회하면서 크레인과 박스 매칭
        int answer = 0;
        while(!box.isEmpty()){
            int idx = 0;
            for(int i=0; i<C; ){    // 크레인 매칭
                if(idx == box.size())   // 완료한 경우
                    break;
                else if(box.get(idx) <= crain.get(i)){  // 크레인과 박스 매칭된 경우
                    box.remove(idx); // 박스 제거
                    i++;    // 다음 크레인 이동
                }
                else    // 다음 박스
                    idx++;
            }
            answer++;   // 순회 완료
        }
        System.out.println(answer);
    }
}