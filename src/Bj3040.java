import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[9]; // 난쟁이 모자 배열
        int sum = 0;

        // 모자 적힌 수 총합
        for(int i=0;i<9;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }

        //오름차순 정렬
        for(int i=8;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        sum-=100; // 올바른 애들 숫자 합 100을 뺀 놈들이 범인

        // 조합으로 확인
        loop: for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                // 범인 찾았으면 범인 빼고 출력.
                if(arr[i]+arr[j]==sum){
                    for(int k=0;k<9;k++){
                        if(k!=i&&k!=j){
                            System.out.println(arr[k]);
                        }
                    }
                    break loop;
                }
            }
        }
    }
}
