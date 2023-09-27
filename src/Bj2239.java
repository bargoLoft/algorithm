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
    static int find;
    static int rowCheck(int num, int x, int y){
        for(int i=0;i<9;i++){
            if(map[x][i] == num) return 0;
        }
        return 1;
    }
    static int colCheck(int num, int x, int y){
        for(int i=0;i<9;i++){
            if(map[i][y] == num) return 0;
        }
        return 1;
    }
    static int squareCheck(int num, int x, int y){
        for(int i=(x/3)*3;i<((x/3)+1)*3;i++){
            for(int j=(y/3)*3;j<((y/3)+1)*3;j++){
                if(map[i][j] == num) return 0;
            }
        }
        return 1;
    }
    static void sudoku(int dep){
            if(find == 1) return;

            if(dep == cnt){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            find = 1;
            //종료
            return;
        }

        int cx = zero[dep][0];
        int cy = zero[dep][1];

        for(int i=1;i<=9;i++){
            if(rowCheck(i,cx,cy) == 0) continue;
            if(colCheck(i,cx,cy) == 0) continue;
            if(squareCheck(i,cx,cy) == 0) continue;
            map[cx][cy] = i;
            zeroSelect[dep] = i;
            sudoku(dep+1);
            map[cx][cy] = 0;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        zero = new int[81][2];
        cnt = 0;
        find = 0;

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
    }
}
