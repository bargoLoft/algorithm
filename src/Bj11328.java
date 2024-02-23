import java.io.*;
import java.util.*;

public class Bj11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int[] alp = new int[26];
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            for(int j=0;j<s1.length();j++){
                alp[s1.charAt(j)-'a']++;
            }
            for(int j=0;j<s2.length();j++){
                alp[s2.charAt(j)-'a']--;
            }

            boolean isOk = true;
            for(int n : alp){
                if(n!=0){
                    isOk = false;
                    break;
                }
            }
            String output = isOk ? "Possible" : "Impossible";

            System.out.println(output);

        };
    }
}
