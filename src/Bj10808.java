import java.io.*;
import java.util.*;
// String, chatAt
public class Bj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String word = st.nextToken();
        int[] alpha = new int[26];
        for(int i=0;i<word.length();i++){
            alpha[word.charAt(i)-'a']++;
        }

        for(int n : alpha){
            System.out.printf("%d ",n);
        }

    }
}
