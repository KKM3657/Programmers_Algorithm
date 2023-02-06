import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] H = new int[20000];   // 햄버거 배열
        int[] P = new int[20000];   // 사람 배열
        
        String input = br.readLine();
        int l1 = 0, l2 = 0; // 저장
        for(int i=0; i<N; i++) {
            char c = input.charAt(i);
            if(c == 'H') {  // 햄버거인 경우 햄버거 배열에 저장
                H[l1] = i;
                l1++;
            }
            else {  // 사람일 경우 사람 배열에 저장
                P[l2] = i;
                l2++;
            }
        }
        
        int answer = 0; // 정답
        int idx1 = 0, idx2 = 0; // 인덱스
        for (int p = idx1; p < l2; p++) {   // 사람 순회
            for (int h = idx2; h < l1; h++) {   // 햄버거 순회
                int val1 = P[p], val2 = H[h];   // 값
                if(val1 > val2){    // 사람의 인덱스가 더 클 경우
                    if(val1 - val2 <= K){   // 차이가 K이하이면 선택
                        answer++;
                        idx2++; // 다음 햄버거로 이동
                        break;
                    }
                    idx2++; // 다음 햄버거가 조건에 만족하는지 확인
                } else {    // 사람의 인덱스가 더 작은 경우
                    if(val2 - val1 <= K) {  // 차이가 K이하이면 선택, 만족하는 햄버거가 없으면 다음 사람으로 넘어감
                        answer++;
                        idx2++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}