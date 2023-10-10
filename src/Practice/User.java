package Practice;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class User {
    private static final int SALT_SIZE = 16; // Salt 16bit로 설정.
    private static DB db = new DB();

    // DB에 유저 입력
    public void set_User(String ID, byte[] Password) throws Exception{
        String SALT = getSALT();
        db.set_USER(ID,Hashing(Password, SALT),SALT);
    }

    // DB와 대조하여 로그인 성공 / 실패 판별
    public void get_User(String ID, byte[] password) throws Exception {
        String temp_salt = db.get_SALT(ID);
        String temp_pass = Hashing(password, temp_salt);

        if(db.check(ID,temp_pass)){
            System.out.println("로그인 성공");
        } else{
            System.out.println("로그인 실패");
        }
    }

    // 해싱.
    private String Hashing(byte[] password, String Salt) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // key-stretching
        for(int i=0;i<10000;i++){
            String temp = bytesToHex(password) + Salt;
            md.update(temp.getBytes());
            password = md.digest();
        }

        return bytesToHex(password);
    }

    // 랜덤 salt 생성.
    private String getSALT() throws Exception{
        SecureRandom rnd = new SecureRandom();

        byte[] temp = new byte[SALT_SIZE];
        rnd.nextBytes(temp);

        return bytesToHex(temp);
    }

    // 문자열 -> 16진수로 변경.
    private String bytesToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        // 256비트로 생성 -> 32Byte -> 1Byte(8bit) -> 16진수 2자리로 변환
        for(byte b : bytes){
            builder.append(String.format("%02x",b));
        }

        return builder.toString();
    }

    // DB 출력.
    public void get_DB() {
        System.out.println("\n================DB출력================\n");
        System.out.println(db);
    }

}
