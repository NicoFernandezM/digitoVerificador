import java.util.Scanner;

public class DigitoVerificador {
    public static void main(String[] args) {
        pedirRut();
    }

    public static void pedirRut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese su rut sin puntos ni digito verificador.");
        String line = scanner.nextLine();
        verificarNumeroRut(line);
        scanner.close();
    }

    public static void verificarNumeroRut(String line) {
        try {
            int rut = Integer.parseInt(line);
            verificarTamañoRut(rut);
        } catch (NumberFormatException e) {
            pedirRut();
        }
    }

    public static void verificarTamañoRut(int rut) {
        int valorMaximo = 99999999;
        int valorMinimo = 1000000;
        if (rut < valorMinimo || rut > valorMaximo) {
            pedirRut();
        } else {
            convertirIntAArreglo(rut);
        }
    }

    public static void convertirIntAArreglo(int rut) {
        char[] chars = String.valueOf(rut).toCharArray();
        invertirRut(chars);
    }

    public static void invertirRut(char[] rut) {
        char[] rutInvertido = new char[rut.length];

        for (int i = rut.length - 1, j = 0; i >= 0; i--, j++) {
            rutInvertido[j] = rut[i];
        }

        cadenaParaMultiplicar(rutInvertido);
    }

    public static void cadenaParaMultiplicar(char[] rutInvertido) {
        int[] cadenaParaMultiplicar = new int[rutInvertido.length];
        int numeroMultiplicador = 2;

        for (int i = 0; i < rutInvertido.length; i++) {
            if (numeroMultiplicador < 8) {
                cadenaParaMultiplicar[i] = numeroMultiplicador;
                numeroMultiplicador++;
            } else {
                numeroMultiplicador = 2;
                i--;
            }
        }

        multiplicarCadenas(cadenaParaMultiplicar, rutInvertido);
    }

    public static void multiplicarCadenas(int[] cadenaParaMultiplicar, char[] rutInvertido) {
        int multiplicacionCadenas = 0;

        for (int i = 0; i < rutInvertido.length; i++) {
            int digitoRutAMultiplicar = convertirCharAInt(rutInvertido[i]);
            int auxMultiplicacion = cadenaParaMultiplicar[i] * digitoRutAMultiplicar;
            multiplicacionCadenas += auxMultiplicacion;
        }

        int division = multiplicacionCadenas / 11;
        int multiplicacionFinal = division * 11;
        int resultadoDigitoVerificador = 11 - (multiplicacionCadenas - multiplicacionFinal);
        imprimirDigitoVerificador(resultadoDigitoVerificador);
    }

    public static int convertirCharAInt(char caracterRutInvertido) {
        String digitoString = String.valueOf(caracterRutInvertido);
        return Integer.parseInt(digitoString);
    }

    public static void imprimirDigitoVerificador(int resultadoDigitoVerificador) {

        if (resultadoDigitoVerificador == 11) {
            System.out.println("El dígito verificador es: 0");

        } else if (resultadoDigitoVerificador == 10) {
            System.out.println("El dígito verificador es: k");

        } else {
            System.out.println("El dígito verificador es: " + resultadoDigitoVerificador);
        }
    }
}