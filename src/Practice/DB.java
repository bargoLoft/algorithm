package Practice;

import java.util.ArrayList;

public class DB {
    private static ArrayList<String[]> UserData = new ArrayList();

    // 유저 생성
    public void set_USER(String ID, String Hasing_Password, String SALT){
        String [] temp = {ID, Hasing_Password, SALT};
        UserData.add(temp);
    }

    // ID와 비밀번호가 일치하는 지 체크.
    public boolean check(String ID, String Hasing_password){
        for(int i=0;i< UserData.size();i++){
            if(ID.equals(UserData.get(i)[0])){
                if(Hasing_password.equals(UserData.get(i)[1])){
                    return true;
                }
            }
        }
        return false;
    }
    // 해당 ID의 SALT 값 찾기
    public String get_SALT(String ID){
        String err = null;
        for(int i=0;i<UserData.size();i++){
            if(ID.equals(UserData.get(i)[0])){
                return UserData.get(i)[2];
            }
        }
        return err;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String[] temp : UserData) {
            sb.append("ID : " +temp[0] + "\nPassword : " + temp[1] + "\nSALT : "+ temp[2]).append("\n\n");
        }
        return sb.toString();
    }
}
