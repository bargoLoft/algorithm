import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//색종이
public class Bj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //색종이를 크기 1의 정사각형으로 나눔
        int[][] arr = new int[100][100];

        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //해당 크기만큼 색칠함
            for(int j=x;j<x+10;j++){
                for(int k=y;k<y+10;k++){
                    arr[j][k] = 1;
                }
            }
        }

        int cnt = 0;

        //색칠된 부분 체크
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                cnt+=arr[i][j];
            }
        }

        System.out.println(cnt);
    }
}
