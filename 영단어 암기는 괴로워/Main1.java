import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Word implements Comparable<Word>{
    String name;
    int count;

    public Word(String name, int count){
        this.name = name;
        this.count = count;
    }

    @Override
    public int compareTo(Word o){
        if(this.count == o.count) {
            if(this.name.length() == o.name.length())
                return this.name.compareTo(o.name);
            return o.name.length() - this.name.length();
        }
        else 
            return (o.count - this.count);
    }

}
public class Main {
    static int n, m; 
    static HashMap<String, Word> answer_map = new HashMap<>();
    static ArrayList<String> words = new ArrayList<>();
    static LinkedList<Word> answer = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String input = br.readLine();
            if(input.length() < m)
                continue;
            if(answer_map.containsKey(input))
                answer_map.get(input).count++;
            else{
                answer_map.put(input, new Word(input, 1));
                words.add(input);
            }
        }
        for(int i=0; i<words.size(); i++){
            answer.add(answer_map.get(words.get(i)));
        }
        Collections.sort(answer);
        for(int i=0; i<answer.size(); i++)
            bw.write(answer.get(i).name+"\n");
        bw.flush();   
    }
}