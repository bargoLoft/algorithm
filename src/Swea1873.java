import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int tankX = 0;
            int tankY = 0;
            int tankD = 0;

            char[][] pan = new char [H][W];

            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    char c = st.nextToken().charAt(0);
                    if(c == '>'){
                        tankX = i;
                        tankY = j;
                        tankD = 3;
                        pan[i][j] = '.';
                    } else if (c == '<') {
                        tankX = i;
                        tankY = j;
                        tankD = 2;
                        pan[i][j] = '.';
                    }else if (c == '^') {
                        tankX = i;
                        tankY = j;
                        tankD = 0;
                        pan[i][j] = '.';
                    }else if (c == 'v') {
                        tankX = i;
                        tankY = j;
                        tankD = 1;
                        pan[i][j] = '.';
                    } else {
                        pan[i][j] = c;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            for(int i=0;i<N;i++){
                // 탱크 행동.
                char command = arr[i];
                switch (command){
                    case 'U':
                        tankD = 0;
                        if(tankX-1 >=0&&pan[tankX-1][tankY] == '.')
                            tankX -= 1;
                        break;
                    case 'D':
                        tankD = 1;
                        if(tankX+1 <H && pan[tankX+1][tankY] == '.')
                            tankX += 1;
                        break;
                    case 'L':
                        tankD = 2;
                        if(tankY-1 >=0&&pan[tankX][tankY-1] == '.')
                            tankY -= 1;
                        break;
                    case 'R':
                        tankD = 3;
                        if(tankY+1 < W &&pan[tankX][tankY+1] == '.')
                            tankY += 1;
                        break;
                    case 'S':

                        break;
                }
            }
        }
    }
}
