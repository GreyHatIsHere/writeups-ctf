import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class crypt_algorithm {

    /* renamed from: p */
    public static byte[] aes_key_generator = {-114, 62, 98, 26, 54, -7, -59, -47, 55, 88, 18, -1, -99, 116, -51, 62};

    /* renamed from: q */
    public static byte[] f3746q = {-84, 25, 77, -101, -53, -124, -100, 61, 74, 102, 50, -11, -24, 62, -54, -71};

    /* renamed from: r */
    public static byte[] crypted_password = {11, -35, 55, 10, 62, 79, 125, 62, -28, 115, 77, 4, 73, 0, 11, 121, -126, 85, -83, 109, 1, -98, 35, -68, -4, -122, 14, 110, -28, 111, 22, -125};

    /* renamed from: a12dd3a7fd3203a452eb34d91a9be20569d5e337a3384347068895c07f3e0c5a */
    public static void main(String[] args) {
        String str;
        String io = "password_submited";
        byte[] test_password = io.toString().getBytes(); //the content is stored as an array of bytes
        boolean condition = false;
        try {
            byte[] aes_key_copy = aes_key_generator; //being the aes key static member, a copy is created
            SecretKeySpec secret_key = new SecretKeySpec(aes_key_copy, 0, aes_key_copy.length, "AES"); //a secret key is created
            MessageDigest hash = MessageDigest.getInstance("SHA-256"); //preparing for the hash digest
            hash.reset();
            byte[] memorized_password_hash = hash.digest(test_password); //the key is stored as a hash
            try {
                Cipher instance2 = Cipher.getInstance("AES/ECB/NoPadding"); //preparing for the AES/ECB encrypion
                instance2.init(1, secret_key);
                byte[] answer_container = instance2.doFinal(memorized_password_hash); //the hash of the test password is encrypted with the secret aes password
           		condition = Arrays.equals(answer_container, crypted_password); //the test password is compared to a stored password
            } catch (Exception e) {
            }
            
        } catch (Exception e2) {
		
        }
        if (condition) {
            System.out.println("Congrats!! Validate the challenge with dvCTF{");
            
        } else {
            System.out.println("No");
        }
    }
    }
