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
            // 탱크 현재 위치, 방향
            int tankX = 0;
            int tankY = 0;
            int tankD = 0;

            char[] tankDirection = {'^','v','<','>'}; // 상,하,좌,우
            char[][] map = new char [H][W]; // 맵

            // 맵 입력
            for(int i=0;i<H;i++){
                String s = br.readLine();
                for(int j=0;j<W;j++){
                    char c = s.charAt(j);
                    if(c == '>'){
                        tankX = i;
                        tankY = j;
                        tankD = 3;
                        map[i][j] = '.';
                    } else if (c == '<') {
                        tankX = i;
                        tankY = j;
                        tankD = 2;
                        map[i][j] = '.';
                    }else if (c == '^') {
                        tankX = i;
                        tankY = j;
                        tankD = 0;
                        map[i][j] = '.';
                    }else if (c == 'v') {
                        tankX = i;
                        tankY = j;
                        tankD = 1;
                        map[i][j] = '.';
                    } else {
                        map[i][j] = c;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] arr = br.readLine().toCharArray();
            for(int i=0;i<N;i++){
                // 탱크 행동.
                char command = arr[i]; // 현재 행동
                switch (command){
                    case 'U':
                        tankD = 0; // 방향 바꾸고
                        if(tankX-1 >=0&&map[tankX-1][tankY] == '.')
                            tankX -= 1; // 갈 수 있다면 이동.
                        break;
                    case 'D':
                        tankD = 1;
                        if(tankX+1 <H && map[tankX+1][tankY] == '.')
                            tankX += 1;
                        break;
                    case 'L':
                        tankD = 2;
                        if(tankY-1 >=0&&map[tankX][tankY-1] == '.')
                            tankY -= 1;
                        break;
                    case 'R':
                        tankD = 3;
                        if(tankY+1 < W &&map[tankX][tankY+1] == '.')
                            tankY += 1;
                        break;
                    case 'S': // 빵!
                        switch (tankD){ // 방향 별로.
                            case 0:
                                for(int x = tankX-1; x>=0;x--){
                                    // 강철 벽이면 종료.
                                    if(map[x][tankY]=='#') {
                                        break;
                                    }
                                    // 그냥 벽이면 평지로 바꾸고 종료.
                                    if (map[x][tankY]=='*'){
                                        map[x][tankY] = '.';
                                        break;
                                    }
                                }
                                break;
                            case 1:
                                for(int x = tankX+1; x<H;x++){
                                    if(map[x][tankY]=='#') {
                                        break;
                                    }
                                    if (map[x][tankY]=='*'){
                                        map[x][tankY] = '.';
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                for(int y = tankY-1; y>=0;y--){
                                    if(map[tankX][y]=='#') {
                                        break;
                                    }
                                    if (map[tankX][y]=='*'){
                                        map[tankX][y] = '.';
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                for(int y = tankY+1; y<W;y++){
                                    if(map[tankX][y]=='#') {
                                        break;
                                    }
                                    if (map[tankX][y]=='*'){
                                        map[tankX][y] = '.';
                                        break;
                                    }
                                }
                                break;
                        }

                        break;
                }
            }
            System.out.print("#"+t+' ');
            // 출력.
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(i==tankX&&j==tankY){
                        // 탱크 위치에 탱크 표시
                        System.out.print(tankDirection[tankD]);
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}
