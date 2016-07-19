/**
 * Created by nicurat on 7/19/16.
 */
public class Utilities {

    public static String adapt(String s, int cant){
        String r = s;
        if(s.length() > cant){
            r = s.substring(0, cant);
        } else{
            for(int i = s.length(); i < cant; i++){
                r = r + " ";
            }
        }
        return r;
    }
}
