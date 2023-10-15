import java.io.*;
import java.util.*;
// 소트인사이드

// 역순 정렬은 Collections.reverseOrder();
// 객체만 됨 int -> Integer
public class Bj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String s = br.readLine();
        Integer[] arr = new Integer[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        Arrays.sort(arr,Collections.reverseOrder());

        for(int i=0;i<s.length();i++){
            System.out.print(arr[i]);
        }
    }
}
