import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   // 입력된 점수 개수
        long n_S = Long.parseLong(st.nextToken());  // 새로운 점수
        int P = Integer.parseInt(st.nextToken());   // 보이는 점수 개수
        int answer = -1;    // 정답

        LinkedList<Long> ll = new LinkedList<>();
        if(N != 0)  // 점수판에 아무것도 없을때
            st = new StringTokenizer(br.readLine());
        else{
            System.out.println(1);
            System.exit(0);
        }

        for(int i=0; i<N; i++)
            ll.add(Long.parseLong(st.nextToken()));

        Collections.sort(ll, Collections.reverseOrder());   // 정렬
        int S = -1, cnt = 0;
        for(int L=0; L<ll.size(); L++){ // 새로운 점수가 들어갈 위치 찾기
            if(ll.get(L) >= n_S){   // 새로운 점수가 작으면 다음 점수 확인
                if(ll.get(L) == n_S && cnt == 0){   // 동점자 처리
                    S = L;
                    cnt++;
                }
            }
            else{   // 자리 찾음
                answer = L;
                break;
            }
        }
        if(answer == -1){   // 입력된 점수보다 새로운 점수가 작은 경우
            if(ll.size() < P){  // 보이는 점수 개수보다 작은 경우 표시
                if(S != -1){    // 동점자 처리
                    if(ll.get(S) == n_S)
                        System.out.println(S + 1);
                    else    // 마지막 등수
                        System.out.println(answer + 1);
                }
                else    // 마지막 등수
                    System.out.println(ll.size()+1);
                System.exit(0); // 종료
            } 
            else    // 점수판에 보이지 않는 경우
                System.out.println(-1);
            System.exit(0);
        }
        if(answer > P - 1) // 보이는 점수보다 새로운 점수가 작은 경우
            System.out.println(-1);
        else{
            if(S != -1){    // 동점자 처리
                if(ll.get(S) == n_S)
                    System.out.println(S + 1);
            }
            else    // 정답
                System.out.println(answer + 1);
        }
    }
}