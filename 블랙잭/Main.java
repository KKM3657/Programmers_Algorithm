import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n;
    static int target;
    static int max = 0;
    static int[] array;
    static int[] visited;

    public static void find_maxCard(int curr_num, int select){
        // 3개 선택 완료한 경우
        if(select == 3){
            int sum = 0;
            // 총합 계산
            for(int i=0; i<array.length; i++){
                if(visited[i] == 1)
                    sum += array[i];
            }
            // target 숫자와 제일 가까운지 판별
            if(sum > max && sum <= target){
                max = sum;
            }
            return;
        }
        // 다음 수로 넘어감
        if(curr_num >= n){
            return;
        }

        // 선택한 경우
        visited[curr_num] = 1;
        find_maxCard(curr_num + 1, select + 1);

        // 선택하지 않은 경우
        visited[curr_num] = 0;
        find_maxCard(curr_num + 1, select);

    } 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        array = new int[n];
        visited = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        find_maxCard(0, 0);
        System.out.println(max);
    }
}