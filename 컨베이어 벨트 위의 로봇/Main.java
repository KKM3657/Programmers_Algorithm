import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;


public class Main {
    static int n, k, ans_cnt = 1;
    static LinkedList<Pair> line1 = new LinkedList<>(); // 위 컨베이어 벨트
    static LinkedList<Pair> line2 = new LinkedList<>(); // 아래 컨메이어 벨트

    // 내구도, 로봇 유무
    static class Pair{
        int dur_a;
        boolean robot;

        Pair(int dur_a, boolean robot){
            this.dur_a = dur_a;
            this.robot = robot;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int zero_cnt = 0, robot_cnt = 0;

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            line1.add(new Pair(Integer.parseInt(st.nextToken()), false));

        for(int i=0; i<n; i++)
            line2.addFirst(new Pair(Integer.parseInt(st.nextToken()), false));

        while(true){
            // 회전
            Pair o1 = line1.remove(line1.size()-1); // 아래로 이동하기 위한 추출
            Pair o2 = line2.removeFirst();  // 위로 이동하기 위한 추출

            line1.addFirst(o2);
            line2.add(o1);

            Pair up = line1.get(n-1);
            // 로봇 내리기
            if(up.robot) {
                up.robot = false;
                robot_cnt--;
            }

            // 로봇 이동
            if(robot_cnt != 0) {
                // 로봇 한칸 이동하기
                for (int i = n-1; i > 0; i--) {
                    Pair curr = line1.get(i-1); // 현재 위치
                    Pair next = line1.get(i);   // 다음 위치
                    // 현재 위치에 로봇이 있고 다음으로 이동할 위치에 로봇이 없고 내구성이 있는 경우 이동
                    if (curr.robot && !next.robot && next.dur_a != 0) {
                            curr.robot = false;
                            next.robot = true;
                            next.dur_a -= 1;
                            // 내구성이 0이 되면 값 추가
                            if (next.dur_a == 0)
                                zero_cnt++;
                    }
                }
                // 로봇 내리기
                if(line1.get(n-1).robot) {
                    line1.get(n-1).robot = false;
                    robot_cnt--;
                }
            }
            // 로봇 올리기
            Pair land = line1.get(0);
            // 내구성이 있으면 로봇 올리기
            if(land.dur_a > 0){
                robot_cnt++;
                line1.get(0).robot = true;
                line1.get(0).dur_a -= 1;
                // 내구성이 0이 되면 값 추가
                if(line1.get(0).dur_a == 0)
                    zero_cnt++;
            }

            // 종료
            if(zero_cnt >= k){
                System.out.println(ans_cnt);
                break;
            }
            ans_cnt++;
        }
    }
}