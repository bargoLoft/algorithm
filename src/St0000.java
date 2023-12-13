import java.util.*;
import java.io.*;

public class St0000 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        char[] c = s.toCharArray();

        System.out.println();
        for(int i=0;i<s.length();i++){
            System.out.println(c[i]);
        }
        System.out.println(s);
    }
}