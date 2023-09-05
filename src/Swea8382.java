import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 방향 전환
// 규칙 찾아서.
// N = 5 정도 까지만 하면 보임.
public class Swea8382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int difX = Math.abs(x1-x2);
            int difY = Math.abs(y1-y2);

            int ans = Math.max(difX,difY) * 2 - (difX+difY) % 2;
            System.out.printf("#%d %d\n",t,ans);
        }
    }
}
