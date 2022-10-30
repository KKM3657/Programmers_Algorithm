import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n;
    static int[] arr;
    static int[] merge_arr;
    // 병합
    public static void merge_arr(int low, int mid, int high){
        int i = low, j = mid + 1;
        int k = low;
        // 나눠진 배열 두개를 하나씩 비교해서 병합
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j])
                merge_arr[k++] = arr[i++];
            else
                merge_arr[k++] = arr[j++];
        }
        // 1번 배열에 원소가 남은경우
        while(i <= mid)
            merge_arr[k++] = arr[i++];
        // 2번 배열에 원소가 남은경우
        while(j <= high)
            merge_arr[k++] = arr[j++];
        // 원래 배열에 넣기
        for(int num = low; num <= high; num++)
            arr[num] = merge_arr[num];
    }
    // 병합 정렬
    public static void merge_sort(int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            merge_sort(low, mid);   // 앞부분 배열
            merge_sort(mid+1, high);    // 뒷부분 배열
            merge_arr(low, mid, high);  // 병합 실시
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        merge_arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }
}