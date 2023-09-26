import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 스도쿠
// 미적지근.
public class Bj2239 {
    static int cnt;
    static int[][] map;
    static int[][] zero;
    static int[] zeroSelect;
    static void sudoku(int dep){
        if(dep == cnt){
            //종료
            return;
        }

        int cx = zero[dep][0];
        int cy = zero[dep][1];

        for(int i=1;i<=9;i++){

            zeroSelect[dep] = i;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        zero = new int[81][2];
        cnt = 0;

        for(int i=0;i<9;i++){
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<9;j++){
                map[i][j] = c[j]-'0';
                if(map[i][j] == 0) {
                    zero[cnt][0] = i;
                    zero[cnt][1] = j;
                    cnt++;
                }
            }
        }
        zeroSelect = new int[cnt];

        sudoku(0);
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                System.out.printf("%d",map[i][j]);
//            }
//            System.out.println();
//        }

    }
}
