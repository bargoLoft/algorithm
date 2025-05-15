import java.io.*;
import java.sql.Array;
import java.util.*;

public class Bj2800 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Integer> str = new Stack<Integer>();
        List<int[]> pairs= new ArrayList<>();

        // 괄호 쌍 위치 저장
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                str.add(i);
            } else if(s.charAt(i) == ')'){
                int start = str.pop();
                pairs.add(new int[] {start, i});
            }
        }

        int size = pairs.size();
        Set<String> resultSet = new HashSet<>();


        // 비트마스킹으로 제거 경우의 수 계산
        for(int i=1; i < (1 << size);i++){
            boolean[] toRemove = new boolean[s.length()];

            for(int j=0; j < size; j++){
                if((i &(1 << j)) != 0){
                    toRemove[pairs.get(j)[0]] = true;
                    toRemove[pairs.get(j)[1]] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int k=0; k<s.length();k++){
                if(!toRemove[k]){
                    sb.append(s.charAt(k));
                }
            }
            resultSet.add(sb.toString());
        }

        List<String> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        for(String result: resultList){
            System.out.println(result);
        }
    }
}
