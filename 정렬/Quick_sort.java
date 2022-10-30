import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    public static void swap(int a_index, int b_index){
        int temp = arr[a_index];
        arr[a_index] = arr[b_index];
        arr[b_index] = temp;
    }
    public static int select_pivot(int low, int high){
        return arr[high];
    }
    // 분할하기
    public static int partition(int low, int high){
        int pivot = select_pivot(low, high);
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(i, j);
            }
        }
        swap(i+1, high);
        return i+1;
    }
    // 퀵 정렬
    public static void quick_sort(int low, int high){
        if(low < high){
            int pos = partition(low, high);
            quick_sort(low, pos-1);   // 앞부분 배열
            quick_sort(pos+1, high);    // 뒷부분 배열
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quick_sort(0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }
}