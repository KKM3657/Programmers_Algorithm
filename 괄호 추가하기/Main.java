import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n, answer = 0;
    static ArrayList<Integer> arr1 = new ArrayList<>();
    static ArrayList<String> arr2 = new ArrayList<>();
    public static int calculate_value(String operator, int first, int second){
        if(operator.equals("+"))
            return first + second;
        else if(operator.equals("-"))
            return first - second;
        else
            return first * second;
    }
    public static void find_maxValue(int opIdx, int result){
        if(opIdx >= arr2.size()){
            answer = Math.max(answer, result);
            return;
        }
        int value1 = calculate_value(arr2.get(opIdx), result, arr1.get(opIdx+1));
        find_maxValue(opIdx+1, value1);

        if (opIdx + 1 < arr2.size()) {
            int value2 = calculate_value(arr2.get(opIdx + 1), arr1.get(opIdx+1), arr1.get(opIdx+2));
            find_maxValue(opIdx+2, calculate_value(arr2.get(opIdx), result, value2));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split("");
        for(int i=0; i<n; i++){
            String token = input[i];
            if(token.equals("+")||token.equals("-")||token.equals("*")){
                arr2.add(token);
                continue;
            }
            arr1.add(Integer.parseInt(token));
        }
        
        find_maxValue(0,0);
        System.out.println(answer);
    }
}