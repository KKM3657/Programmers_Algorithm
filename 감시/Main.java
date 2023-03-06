import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
class Pair{
    int x;
    int y;
    int type;
    int dir = 0;
    // 좌표
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 좌표와 타입
    Pair(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] grid;
    static ArrayList<Pair> al = new ArrayList<>();
    static int[] dx1 = new int[]{0,1,0,-1}, dy1 = new int[]{1,0,-1,0};  // 4방향
    static int[] dx2 = new int[]{0,1,-1,0}, dy2 = new int[]{1,0,0,-1};  // 2방향
    // 한쪽 방향으로 움직이기
    public static void move1(int[][] temp, int cx, int cy, int dir){
        while(true){
            int nx = cx + dx1[dir], ny = cy + dy1[dir]; // 다음 위치
            if(0 > nx || nx >= N || 0 > ny || ny >= M)  // 격자점 벗어나면 멈춤
                break;
            if(temp[nx][ny] == 6)   // 벽에 막히면 멈춤
                break;
            temp[nx][ny] = 8;
            cx = nx;
            cy = ny;
        }
        return;
    }
    // 2방향을 위한 이동
    public static void move2(int[][] temp, int cx, int cy, int dir){
        while(true){
            int nx = cx + dx2[dir], ny = cy + dy2[dir]; // 다음 위치
            if(0 > nx || nx >= N || 0 > ny || ny >= M)  // 격자점 벗어나면 멈춤
                break;
            if(temp[nx][ny] == 6)   // 벽에 막히면 멈춤
                break;
            temp[nx][ny] = 8;
            cx = nx;
            cy = ny;
        }
        return;
    }
    // 1번 cctv(단방향)
    public static void cctv1(int[][] temp, Pair p) {
        int cx = p.x, cy = p.y;
        move1(temp, cx, cy, p.dir);
        return;
    }
    // 2번 cctv(양방향)
    public static void cctv2(int[][] temp, Pair p) {
        int cx = p.x, cy = p.y;
        move2(temp, cx, cy, p.dir);
        move2(temp, cx, cy, 3-p.dir);
        return;
    }
    // 3번 cctv(ㄱ자 모양)
    public static void cctv3(int[][] temp, Pair p) {
        int cx = p.x, cy = p.y;
        move1(temp, cx, cy, p.dir);
        move1(temp, cx, cy, (p.dir + 3) % 4);
        return;
    }
    // 4번 cctv(ㅗ,ㅜ.ㅓ,ㅏ)
    public static void cctv4(int[][] temp, Pair p) {
        int cx = p.x, cy = p.y;
        for(int i=0; i<4; i++){
            if(i == p.dir)
                continue;
            move1(temp, cx, cy, i);
        }
        return;
    }
    // 5번 cctv(4방향)
    public static void cctv5(int[][] temp, Pair p) {
        int cx = p.x, cy = p.y;
        for(int i=0; i<4; i++)
            move1(temp, cx, cy, i);
        return;
    }
    // 사각지대 계산
    public static int cal_grid() {
        // 배열 복사
        int[][] temp = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        // cctv 경로 탐색
        for(int i=0; i<al.size(); i++) {
            Pair cp = al.get(i);
            //1번
            if(cp.type == 1){
                cctv1(temp, cp);
            }
            else if(cp.type == 2){
                cctv2(temp, cp);
            }
            else if(cp.type == 3){
                cctv3(temp, cp);
            }
            else if(cp.type == 4){
                cctv4(temp, cp);
            }
            else{
                cctv5(temp, cp);
            }
        }
        // cctv 사각지대 탐색
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                //System.out.print(temp[i][j] + " ");
                if(temp[i][j] == 0)
                    cnt++;
            }
            //System.out.println();
        }
        return cnt;
    }
    // 백트래킹을 이용한 탐색
    public static void find_answer(int curr) {
        // 모든 경우 탐색
        if(curr == al.size()){
            answer = Math.min(answer, cal_grid());
            return;
        }
        Pair cp = al.get(curr);
        //  해당 cctv인 경우 방향 선택
        if(cp.type == 2){
            //방향
            for(int i=0; i<2; i++){
                cp.dir = i;
                find_answer(curr+1);
            }
        }
        else if(cp.type == 5){
            find_answer(curr+1);
        }
        else {   // 나머지 cctv는 4방향
            //방향
            for(int i=0; i<4; i++){
                cp.dir = i;
                find_answer(curr+1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] != 0 && grid[i][j] != 6)
                    al.add(new Pair(i,j,grid[i][j]));
            }
        }
        find_answer(0);
        System.out.println(answer);
    }
}