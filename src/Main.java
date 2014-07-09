import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by demo4 on 09.07.14.
 */

public class Main {


    public static void main(String[] arg){
        int total = 0;
        try (Reader r = new InputStreamReader(new BufferedInputStream(new FileInputStream(arg[0])))) {
            int code;
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> words = new HashMap<>();
            while ((code = r.read())!=-1){
                char ch = (char)code;
                if (Character.isLetterOrDigit(ch)) {
                    sb.append(ch);
                }else{
                    total++;
                }
                if (sb.length() > 0) {
                    String word = sb.toString();
                    sb.setLength(0);
                    Integer count = words.get(word);
                    if (count!=null){
                        words.put(word,1+count);
                    }else{
                        words.put(word,1);
                    }
                }
            }

        }catch (IOException e){
            System.err.println(e.getMessage());
        }







    }
}