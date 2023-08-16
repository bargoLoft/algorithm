import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 쿼드트리
public class Bj1992 {
    static int[][] m;
    static void movie(int si,int sj,int size){
        // 구역의 합이 전부 0이나 1이면 출력하고 종료.
        int sum = 0;

        for(int i=si;i<si+size;i++){
            for(int j=sj;j<sj+size;j++){
                sum+=m[i][j];
            }
        }
        if(sum == size*size){
            System.out.print('1');
            return;
        }
        if(sum == 0){
            System.out.print('0');
            return;
        }

        // 섞여있으면 괄호 속에 4분할로 정복.
        int half = size / 2;
        System.out.print("(");
        movie(si,sj,half);
        movie(si,sj+half,half);
        movie(si+half,sj,half);
        movie(si+half,sj+half,half);
        System.out.print(")");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 한변의 길이
        m = new int[N][N]; // 영화 데이터 배열

        // m 입력
        for(int i=0;i<N;i++){
            String s =br.readLine();
            for(int j=0;j<N;j++){
               m[i][j] = s.charAt(j)-'0';
            }
        }

        // 4분할정복
        movie(0,0,N);
    }
}
