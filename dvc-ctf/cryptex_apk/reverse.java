    /*
    We know that: Our password is crypted to an hash, then crypted again with aes and compared to a saved password
    So, we have to decrypt the saved password with the reversed method
    */
            import java.security.MessageDigest;
            import java.util.Arrays;
            import javax.crypto.Cipher;
            import javax.crypto.spec.SecretKeySpec;


            public class reverse {

                /* renamed from: p */
                public static byte[] aes_key_generator = {-114, 62, 98, 26, 54, -7, -59, -47, 55, 88, 18, -1, -99, 116, -51, 62};
                /* renamed from: r */
                public static byte[] crypted_password = {11, -35, 55, 10, 62, 79, 125, 62, -28, 115, 77, 4, 73, 0, 11, 121, -126, 85, -83, 109, 1, -98, 35, -68, -4, -122, 14, 110, -28, 111, 22, -125};
                
                public static void main(String[] args) {
                    try {
                        byte[] aes_key_generator_copy = aes_key_generator; //making a copy of the crypted password
                        SecretKeySpec aes_secret_key = new SecretKeySpec(aes_key_generator_copy, 0, aes_key_generator_copy.length, "AES"); 
                        //generating the same aes secret key
                        try {
                            Cipher instance2 = Cipher.getInstance("AES/ECB/NoPadding"); //preparing for decryption
                            instance2.init(Cipher.DECRYPT_MODE, aes_secret_key);
                            byte[] answer_container = instance2.doFinal(crypted_password);  //decrypting and saving the hash
                            //hash rappresentation algorithm below:
                            StringBuilder hexString = new StringBuilder(2 * answer_container.length);
                            for (int i = 0; i < answer_container.length; i++) {
                                    String hex = Integer.toHexString(0xff & answer_container[i]);
                            if(hex.length() == 1) {
                                    hexString.append('0');
                                                  }
                                    hexString.append(hex);
                                                   }
                System.out.println(hexString.toString());
                System.out.println("Hash broken with https://crackstation.net/ --> JohnCena");
                        } catch (Exception e) {
                        }
                        
                    } catch (Exception e2) {
            		
                   
                }
            }
        }
