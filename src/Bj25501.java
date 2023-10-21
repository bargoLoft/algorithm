import java.io.*;
import java.util.*;

// 재귀의 귀재

// 재귀. 귀재.
public class Bj25501 {
    static int cnt;
    static int recursion(String s, int l, int r){
        cnt++;
        if(l>=r) return 1;
        else if(s.charAt(l)!= s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    static int isPalindrome(String s){
        return recursion(s,0,s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int i=1;i<=T;i++){
            cnt = 0;
            System.out.println(isPalindrome(br.readLine()) + " " + cnt);
        }

    }
}
