import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] box = new int[100];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<100;i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int maxIdx = 0;
        int min = 1001;
        int minIdx = 0;

        for(int d=0;d<N;d++){
            max = -1;
            min = 1001;
            for(int i=0;i<100;i++) {
                if(box[i]>max){
                    max = box[i];
                    maxIdx = i;
                }
                if(box[i]<min){
                    min= box[i];
                    minIdx = i;
                }
            }
            box[maxIdx]--;
            box[minIdx]++;
            System.out.println(box[maxIdx] +" "+ box[minIdx]);
        }

        max = box[0];
        min = box[0];

        for(int i=0;i<100;i++) {


            if(box[i]>max){
                max = box[i];
                maxIdx = i;
            }
            if(box[i]<min){
                min= box[i];
                minIdx = i;
            }
        }

        System.out.println(box[maxIdx]-box[minIdx]);
    }
}
