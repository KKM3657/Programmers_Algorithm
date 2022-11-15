import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
// 양끝점 좌표를 위한 클래스
class Pair{
    int x1, x2;

    public Pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    static int n;   // 전체 선분 개수
    static int answer = 0;  // 겹치지 않는 최대 선분의 수
    static LinkedList<Pair> list = new LinkedList<>();  // 선분 리스트
    static LinkedList<Pair> select_line = new LinkedList<>();   // 선택한 선분 리스트
    // 선택한 선분이 기존에 선택한 선분과 겹치는지 판별
    public static boolean in_range(Pair pair){
        for(Pair line : select_line){
            int x1 = pair.x1, x2 = pair.x2;
            if(line.x1 <= x1 && x1 <= line.x2 || line.x1 <= x2 && x2 <= line.x2)    // 작은 범위일때
                return true;
            if(x1 <= line.x1 && line.x1 <= x2 || x1 <= line.x2 && line.x2 <= x2)    // 큰 범위일때
                return true;
        }
        return false;
    }
    // 겹치지 않는 최대 선분의 수 찾기
    public static void find_max_line(int idx, int cnt){
        if(idx == n){   // 모든 선분을 탐색한 경우
            answer = answer < cnt ? cnt : answer;   // 최대 선분을 확인
            return;
        }
        // 선분 선택
        Pair curr = list.get(idx);
        if(in_range(curr)){ // 선택한 선분이 기존에 선택한 선분과 겹치는 지 판별
            find_max_line(idx+1, cnt);  // 겹치면 다음 선분으로 넘어감
        }
        else{
            select_line.add(curr);  // 겹치지 않으면 선택하고 넘어감
            find_max_line(idx+1, cnt+1);

            select_line.remove(select_line.size()-1);   // 겹치지 않지만 선택하지 않고 넘어감
            find_max_line(idx+1, cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
       
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            list.add(new Pair(x1, x2));
        }

        find_max_line(0, 0);

        System.out.println(answer);
    }
}