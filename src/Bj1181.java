import java.io.*;
import java.util.*;
// 단어 정렬.

// compareTo 에서 문자열 비교는
// s.compareTo(word.s)로
public class Bj1181 {
    static class Word implements Comparable<Word>{
        String s;
        int len;
        char c;

        public Word(String s, int len) {
            this.s = s;
            this.len = len;
        }

        @Override
        public int compareTo(Word word){
            if(this.len < word.len) return -1;
            else if(this.len == word.len){
                return this.s.compareTo(word.s);
            }
            return 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Word[] arr = new Word[N];

        for(int i=0;i<N;i++){
            String s =  br.readLine();
            arr[i] = new Word(s,s.length());
        }

        Arrays.sort(arr);

        TreeSet<Word> s = new TreeSet();

        for(int i=0;i<N;i++){
            s.add(arr[i]);
        }

        for(Word w:s){
            sb.append(w.s+"\n");
        }

        System.out.println(sb);
    }
}
