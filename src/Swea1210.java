import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1210 {
    static int[][] b = new int[100][100];
    static void Move(int r,int c,int d){
        //System.out.printf("%d %d %d\n",r,c,d);
        // 종료부
        if(r==0){
            System.out.print(c+"\n");
            return;
        }
        // 구현부

        // 위로 올라왔으면
        if(d==0){
            // 좌로 이동 가능하면 죄로 이동
            if(c>0&&b[r][c-1]==1){
                Move(r,c-1,-1);
            } else if(c<99&&b[r][c+1]==1){ // 우로 이동 가능하면 우로 이동
                Move(r,c+1,1);
            } else{ // 뭣도 아니면 위로 이동.
                Move(r-1,c,0);
            }
        } else{ // 좌, 우로 왔으면
            if(c+d >= 0 && c+d <100 && b[r][c+d]==1){ // 그쪽으로 또 갈 수 있으면 이동
                Move(r,c+d,d);
            } else{ // 아니면 위로 이동
                Move(r-1,c,0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 끝나면 t<10으로 변경
        for(int t=1;t<=10;t++){
            System.out.print("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            for(int i=0;i<100;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++){
                    b[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int row = 99;
            int col = 0;

            for(int i=0;i<100;i++){
                if(b[99][i]==2)
                    col = i;
            }
//
//            System.out.println(row);
            //System.out.println(col);

            Move(row -1,col,0);

        }
//
    }
}
