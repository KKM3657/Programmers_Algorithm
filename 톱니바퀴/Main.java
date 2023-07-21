import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    static int N = 4, north = 0, south = 1;
    static int cw = 1, ccw = -1;
    static LinkedList<Integer>[] ll = new LinkedList[4];
    static int[][] prev = new int[4][2];

    public static void move_Gear(int pos, int dir){
        //시계방향
        if(dir == cw){
            int temp = ll[pos].removeLast();
            ll[pos].addFirst(temp);
        }
        else{
            int temp = ll[pos].removeFirst();
            ll[pos].addLast(temp);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++){
            ll[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<8; j++){
                ll[i].add((int)(input.charAt(j) - '0'));
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            // 접점부 갱신
            for(int i=0; i<4; i++){
                prev[i][0] = ll[i].get(2);
                prev[i][1] = ll[i].get(6);
            }

            // 처음 톱니바퀴 회전
            move_Gear(pos, dir);

            int prev_dir = dir; // 이전 방향
            // 나머지 톱니바퀴 회전 앞쪽
            for(int i=pos; i>0; i--){
                // 다른 극이면 이동
                if(prev[i][1] != prev[i-1][0]){
                    if(prev_dir == 1) {//시계방향 인 경우
                        move_Gear(i-1, ccw);
                        prev_dir = 0;
                    }
                    else {//반시계방향 인 경우
                        move_Gear(i-1, cw);
                        prev_dir = 1;
                    }
                }
                else{
                    break;
                }
            }

            prev_dir = dir;
            // 나머지 톱니바퀴 회전 뒤쪽
            for(int i=pos; i<3; i++){
                if(prev[i][0] != prev[i+1][1]){
                    if(prev_dir == 1) {//시계방향 인 경우
                        move_Gear(i+1, ccw);
                        prev_dir = 0;
                    }
                    else {//반시계방향 인 경우
                        move_Gear(i+1, cw);
                        prev_dir = 1;
                    }
                }
                else{
                    break;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<4; i++){
            if(ll[i].get(0) == south) {
                answer += Math.pow(2,i);
            }
        }
        System.out.println(answer);
    }
}