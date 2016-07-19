package Random;

/**
 * Created by nicurat on 7/19/16.
 */
public class Utilities {

    //Se le agrega el utilities para ya setear desde un principio cuanto seria la cantidad de bytes
    // que va a tomar cada string en el raf. Si el largo del string es menor que la cantidad entonces
    // se llena con espacios. pero si es mas larga que la cantidad se borra la parte que la sobrepase.
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
