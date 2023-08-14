import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 색종이 만들기
public class Bj2630 {
    static int white;
    static int green;
    static int p[][];
    static void makeSpace(int ci, int cj, int size){
        int sum = 0;
        for(int i=ci;i<ci+size;i++){
            for(int j=cj;j<cj+size;j++){
                sum+=p[i][j];
            }
        }

        if(sum == 0){
            white++;
        } else if(sum == size * size){
            green++;
        } else{
            int half = size / 2;
            makeSpace(ci,cj,half);
            makeSpace(ci,cj+half,half);
            makeSpace(ci+half,cj,half);
            makeSpace(ci+half,cj+half,half);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        p = new int[N][N];
        white = 0;
        green = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSpace(0,0,N);

        System.out.println(white);
        System.out.println(green);
    }
}
