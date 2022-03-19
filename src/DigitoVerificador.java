import java.util.Scanner;
import java.util.ArrayList;

public class DigitoVerificador {
    public static void main(String[] args) {
        pedirRut();
    }

    public static void pedirRut() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor ingrese su rut sin puntos ni digito verificador.");
        String line = scanner.nextLine();
        //scanner.close(); Me manda error si pongo esto
        verificarNumeroRut(line);
    }

    public static void verificarNumeroRut(String line) {
        try {
            int rut = Integer.parseInt(line);
            verificarTamañoRut(rut);
        }catch(NumberFormatException e) {
            pedirRut();
        }
    }

    public static void verificarTamañoRut(int rut) {
        int valorMaximo = 99999999;
        int valorMinimo = 1000000;

        if(rut < valorMinimo || rut > valorMaximo) {
            pedirRut();
        }else {
            convertirIntAArreglo(rut);
        }
    }  

    public static void convertirIntAArreglo(int rut) {
        char [] chars = String.valueOf(rut).toCharArray();
        //imprimir(chars);
        invertirRut(chars);
    }

    public static void imprimir(char[] chars) {
        for(int i = 0; i < chars.length; i++ ) {
            System.out.println(chars[i]);
        }
    }

    public static void invertirRut(char[] rut) {
        char [] rutInvertido = new char [rut.length];

        for(int i = rut.length - 1; i >= 0; i--) {
            rutInvertido [rut.length - 1] = rut[i];  
            System.out.println(rut[i]);
        }

        cadenaParaMultiplicar(rutInvertido);
    }

    public static void cadenaParaMultiplicar(char[] rutInvertido) {
        int [] cadenaParaMultiplicar = new int[rutInvertido.length];
        int numeroMultiplicador = 2;

        for(int i = 0; i < rutInvertido.length; i++) {
            if(numeroMultiplicador < 8) {
                cadenaParaMultiplicar[i] = numeroMultiplicador;
                numeroMultiplicador++;
                System.out.println(cadenaParaMultiplicar[i]);
            }else {
                numeroMultiplicador = 2;
                i--;
            }
        }

        //multiplicarCadenas(cadenaParaMultiplicar, rutInvertido);
    }

    /*public static void multiplicarCadenas(int [] cadenaParaMultiplicar, char [] rutInvertido) {
        int multiplicacionCadenas = 0;
        int digitoRutAMultiplicar = 0;
        int auxMultiplicacion = 0;

        for(int i = 0; i < rutInvertido.length; i++) {
            digitoRutAMultiplicar = convertirCharAInt(rutInvertido, i);
            auxMultiplicacion = cadenaParaMultiplicar[i] * digitoRutAMultiplicar;
            multiplicacionCadenas = auxMultiplicacion + multiplicacionCadenas;
        }

        System.out.println(multiplicacionCadenas);
    }

    public static int convertirCharAInt(char [] rutInvertido, int i) {
        String digitoString = String.valueOf(rutInvertido[i]);
        int digitoRutAMultiplicar = Integer.parseInt(digitoString);
        System.out.println(digitoRutAMultiplicar);
        return digitoRutAMultiplicar;
    }*/

    public static void resultadoResta(int multiplicacionCadenas, int multiplicacionFinal) {
        int resultadoDigitoVerificador = multiplicacionCadenas - multiplicacionFinal;

        imprimirDigitoVerificador(resultadoDigitoVerificador);
    }

    public static void imprimirDigitoVerificador(int resultadoDigitoVerificador) {
        
        if(resultadoDigitoVerificador == 11) {
            System.out.println("El dígito verificador es: 0");

        }else if(resultadoDigitoVerificador == 10) {
            System.out.println("El dígito verificador es: k");

        }else {
            System.out.println("El dígito verificador es: " + resultadoDigitoVerificador);
        }
    }
}