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
    // 개선된 pivot 선정 알고리즘
    public static int select_pivot(int low, int high){
        // 원소가 4개 이상이면 중앙값으로 선정
        if(high - low + 1 >= 4){
            int a = arr[low], c = arr[high];
            int b = arr[low + (high - low) / 2];
            if (a >= b) {
                if (b >= c) {
                    swap(low + (high - low) / 2, high);
                    return b;
                }
                else if (a <= c) {
                    swap(low, high);
                    return a;
                }
                else {
                    return c;
                }
            }
            else if (a > c) {
                swap(low, high);
                return a;
            }
            else if (b > c) {
                return c;
            }
            else {
                swap(low + (high - low) / 2, high);
                return b;
            }
        } 
        else{   // 4개 미만일때
            return arr[high];
        }
    }
    // 분할하기
    public static int partition(int low, int high){
        int pivot = select_pivot(low, high);    // pivot 선정
        // 자리 옮기기
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(i, j);
            }
        }
        // pivot  옮기기
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