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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> true_member = new HashSet<Integer>();
        ArrayList<ArrayList<Integer>> team = new ArrayList<>();
        boolean[] teamQ = new boolean[M];

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=0; i<num; i++){
            true_member.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<M; i++){
            if(i>0 && teamQ[i])
                true_member.addAll(team.get(i-1));
            team.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());
            int tn = Integer.parseInt(st.nextToken());
            for(int j=0; j<tn; j++){
                int member = Integer.parseInt(st.nextToken());
                team.get(i).add(member);
                if(true_member.contains(member))
                    teamQ[i] = true;
            }
        }
        for(int i=0; i<M; i++){
            if(teamQ[i])
                if(teamQ[i]) {
                    true_member.addAll(team.get(i));
                }
        }
        int answer = -1;
        while(true){
            int temp = 0;
            for(int i=0; i<M; i++){
                if(teamQ[i])
                    continue;
                for(int j=0; j<team.get(i).size(); j++){
                    int temp_member = team.get(i).get(j);
                    if(true_member.contains(temp_member)){
                        teamQ[i] = true;
                    }
                    if(teamQ[i])
                        true_member.add(temp_member);
                }
            }
            for(int i=0; i<M; i++){
                if(!teamQ[i])
                    temp++;
            }
            if(answer == temp)
                break;
            else
                answer = temp;
        }

        System.out.println(answer);
    }
}