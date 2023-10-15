import java.io.*;
import java.util.*;

public class Bj11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int len = s.length();

        HashSet<String> hs = new HashSet<>();

        // 문자열 길이
        for(int i=1;i<=len;i++){
            // 시작
            for(int j=0;j<=len-i;j++){
                StringBuilder sb = new StringBuilder();
                // 끝
                for(int k=j;k<j+i;k++){
                    sb.append(s.charAt(k));
                }
                //System.out.println(sb);
                hs.add(sb.toString());
            }
        }

        System.out.println(hs.size());
    }
}
