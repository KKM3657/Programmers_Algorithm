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

        for(int i = 0; i < num; i++){
            int j = i - 1;
            int key = array[i];
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }

        for(int i = 0; i< num; i++){
            System.out.print(array[i] + " ");
        }
    }
}