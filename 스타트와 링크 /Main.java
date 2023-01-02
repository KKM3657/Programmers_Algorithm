import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int n, hNum, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static LinkedList<Integer> team_s = new LinkedList<>();
    static LinkedList<Integer> team_l = new LinkedList<>();
    public static int calculate_score(LinkedList<Integer> team_list){
        int total = 0;
        // 팀 점수 계산
        for(int i=0; i<hNum; i++){
            for(int j=0; j<hNum; j++)
                total += arr[team_list.get(i)][team_list.get(j)]; 
        }
        return total;
    }
    // 완전탐색
    public static void find_answer(int curr){
        // 팀 선택 완료
        if(curr == n){
            int score1 = calculate_score(team_s);
            int score2 = calculate_score(team_l);
            // 점수 차이가 최소가 되는지 확인
            answer = Math.min(answer, Math.abs(score1 - score2));
            return;
        }
        // 스타트 팀을 다 뽑은 경우
        if(team_s.size() == hNum){
            team_l.add(curr);
            find_answer(curr+1);

            team_l.remove(team_l.size()-1);
            return;
        }
        // 링크 팀을 다 뽑은 경우 
        else if(team_l.size() == hNum){
            team_s.add(curr);
            find_answer(curr+1);

            team_s.remove(team_s.size()-1);
            return;
        }
        // 스타트 팀 선택
        team_s.add(curr);
        find_answer(curr+1);
        team_s.remove(team_s.size()-1);
        // 링크 팀 선택
        team_l.add(curr);
        find_answer(curr+1);
        team_l.remove(team_l.size()-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        hNum = n / 2;

        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        team_s.add(0);  // 중복되는 경우를 없애기 위해 고정
        find_answer(1);
        System.out.println(answer);
    }
}