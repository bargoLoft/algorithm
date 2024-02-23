import java.io.*;
import java.util.*;

public class Bj1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] alpha1 = new int[26];
        int[] alpha2 = new int[26];
        for(int i=0;i<s1.length();i++){
            alpha1[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++){
            alpha2[s2.charAt(i)-'a']++;
        }

        int cnt = 0;
        for(int i=0;i<26;i++){
            cnt+= Math.abs(alpha1[i]-alpha2[i]);
        }

        System.out.println(cnt);
    }
}
