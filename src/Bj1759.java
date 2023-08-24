import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1759 {
    static int L;
    static int C;
    static int[] isUsed;
    static char[] box;
    static int[] pw;
    static char[] aeiou = {'a','e','i','o','u'};

    static void password(int dep){
        if(dep == L){
            // 종료..
            int aeiouCnt = 0; // 모음 개수 확인.
            for(int i=0;i<5;i++){
                for(int j=0;j<L;j++){
                    if(pw[j] == aeiou[i])
                        aeiouCnt++;
                }
            }

            // 모음이 1개보다 많고, 모음 아닌(=자음)이 2개 이상이면 출력.
            if(aeiouCnt >=1 && L - aeiouCnt >=2){
                for(int c: pw){
                    System.out.printf("%c",c);
                }
                System.out.println();
            }
            return;
        }

        // BFS
        for(int i=0;i<C;i++){
            if(isUsed[i]==1){
                continue;
            }
            // 오름차순 아니면 꽥.
            if(dep!=0 && pw[dep-1] > box[i])
                continue;
            isUsed[i] = 1;
            pw[dep] = box[i];
            password(dep+1);
            isUsed[i] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        isUsed = new int[C]; // 사용했는 지 확인
        box = new char[C]; // 쓸 수 있는 문자들
        pw = new int[L]; // 비밀번호.

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            box[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(box);

        // 최소 한 개의 모음과 최소 두개의 자음.
        // 알파벳 증가차순.
        password(0);

    }
}
