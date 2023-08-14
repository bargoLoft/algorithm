import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 종이접기.
public class Bj20187 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken()); // 가로세로 접은 횟수
        int[] fold = new int[2*k]; // 접는 순서 배열
        int length = 1<<k; // 종이 한 변의 길이
        int[][] p = new int[length][length]; // 종이 2차원 배열

        st =  new StringTokenizer(br.readLine());

        // 접는 순서 입력
        for(int i=0;i<2*k;i++){
            fold[i] = st.nextToken().charAt(0);
        }

        // 구멍 뚫기.
        st =  new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());

        int binaryI=0;
        int binaryJ=0;

        // 뚫은 위치 찾기 R -> 1 L -> 0, D -> 1, U -> 0 이진수로.
        for(int i=0;i<2*k;i++){
            int c = fold[i];
            if (c=='U') {
                binaryI = binaryI<<1;
            }else if (c=='D') {
                binaryI = binaryI<<1;
                binaryI++;
            }
            if(c=='L'){
                binaryJ = binaryJ<<1;
            } else if (c=='R') {
                binaryJ = binaryJ<<1;
                binaryJ++;
            }
        }

        binaryI%=2; // 0
        binaryJ%=2; // 0

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                p[i][j] += (((i%2) ^ binaryI)^(h/2))* 2;
                p[i][j] += (((j%2) ^ binaryJ)^(h%2));
            }
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                sb.append(p[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
