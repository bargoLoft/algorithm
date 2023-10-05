import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 찾기
// table 만들기.
// kmp 알고리즘.
public class Bj1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        // 테이블 구하기
        int[] table = new int[P.length];
        int idx = 0;

        for(int i=1;i<P.length;i++){
            while(idx>0 && P[i] != P[idx]){
                idx = table[idx-1];
            }

            if(P[i] == P[idx]){
                idx +=1;
                table[i] = idx;
            }
        }

        //
        idx = 0;
        int cnt = 0;
        for(int i=0;i<T.length;i++){
            while(idx >0 && T[i] != P[idx]){
                idx = table[idx-1];
            }

            if(T[i] == P[idx]){
                if(idx == P.length-1){
                    sb.append(i-idx+1+" ");
                    idx = table[idx];
                    cnt++;
                } else{
                    idx+=1;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}