import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 구성원 수
        int M = Integer.parseInt(st.nextToken());   // 파티 수

        HashSet<Integer> true_member = new HashSet<Integer>();  // 진실을 알고 있는 구성원
        ArrayList<ArrayList<Integer>> team = new ArrayList<>(); // 파티 구성원
        boolean[] teamQ = new boolean[M];   // 진실을 알고 있는 파티

        // 초기에 주어지는 진실을 알고있는 구성원
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            true_member.add(Integer.parseInt(st.nextToken()));
        }
        // 입력 + 진실을 알고있는 파티 구성원 추가
        for(int i=0; i<M; i++){
            team.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());
            int tn = Integer.parseInt(st.nextToken());
            // 파티 구성원 중에 진실을 알고 있는 사람이 있으면 추가
            for(int j=0; j<tn; j++){
                int member = Integer.parseInt(st.nextToken());
                team.get(i).add(member);
                if(true_member.contains(member))
                    teamQ[i] = true;
            }
            // 추가
            if(teamQ[i])
                true_member.addAll(team.get(i));
        }
        // 거짓으로 알고 있는 파티 찾기
        int answer = -1;
        while(true){
            int temp = 0;
            for(int i=0; i<M; i++){
                if(teamQ[i])    // 진실을 알고 있으면 넘어감
                    continue;
                for(int j=0; j<team.get(i).size(); j++){
                    if(true_member.contains(team.get(i).get(j))){ // 진실을 알고 있는 구성원이 있으면 추가
                        teamQ[i] = true;
                        break;
                    }
                }
                if(teamQ[i])
                    true_member.addAll(team.get(i));
            }
            // 진실을 알고 있는 파티 수 찾기
            for(int i=0; i<M; i++){
                if(!teamQ[i])
                    temp++;
            }
            // 결과가 바뀌지 않으면 종료
            if(answer == temp)
                break;
            else
                answer = temp;
        }
        System.out.println(answer);
    }
}