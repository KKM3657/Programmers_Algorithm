import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[8];
        boolean ascending = true;
        boolean descending = true;
        
        // 입력
        for(int i = 0; i<8; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 순회하면서 오름차순 내림차순 확인
        for(int i = 1; i<8; i++){
            if(array[i] > array[i-1])
                descending = false;
            if(array[i] < array[i-1])
                ascending = false;
        }

        if(ascending){
            System.out.println("ascending");
        } else if(descending){
            System.out.println("descending");
        } else{
            System.out.println("mixed");
        }
    
        // if(array[0] == 1){
        //     for(int i = 1; i<8; i++){
        //         if(array[i] != i + 1){
        //             System.out.println("mixed");
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag)
        //         System.out.println("ascending");
        // } else if(array[0] == 8){
        //     for(int i = 1; i<8; i++){
        //         if(array[i] != 8 - i){
        //             System.out.println("mixed");
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag)
        //         System.out.println("descending");
        // } else{
        //     System.out.println("mixed");
    }
}