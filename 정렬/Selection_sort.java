import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] array = new int[num];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i< num - 1; i++){
            int min = i;
            for(int j = i+1; j < num; j++){
                if(array[j] < array[min])
                    min = j;
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        for(int i = 0 ; i< num; i++){
            System.out.print(array[i] + " ");
        }
    }
}