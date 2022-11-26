import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    static int n;
    static int[] number = new int[]{4,5,6}; // 숫자 배열
    static StringBuilder sb = new StringBuilder();  // 문자열
    // 가능한 수열인지 판별
    public static boolean is_possible(){
        int len = 1;
        while(true){
            // 시작과 끝점1
            int end1 = sb.length() - 1, start1 = end1 - len + 1;
            // 시작과 끝점2
            int end2 = start1 - 1, start2 = end2 - len + 1;
            
            // 범위를 넘기는 경우 넘어감
            if(start2 < 0)
                break;
            
            // 문자 비교를 위한 문자열 생성
            String st1 = sb.substring(start1, end1 + 1);
            String st2 = sb.substring(start2, end2 + 1);
            
            if(st1.equals(st2)){
                return false;
            }
            len++;
        }
        return true;
    }
    public static void solution(int curr){
        // 끝점인 경우
        if(curr == n){
            System.out.println(sb.toString());
            System.exit(0);
        }
        // 4,5,6이 들어가서 가능한 수열인지 판별
        for(int i=0; i<3; i++){
            sb.append(number[i]);
            // 가능한 수열이면 계속 진행 아니면 넘어감
            if(is_possible())
                solution(curr+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        solution(0); 
    }
}