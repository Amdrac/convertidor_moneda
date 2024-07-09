import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal extends ConsultaAPI{
    public static void main(String[] args) {
        Scanner entradaDatos=new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            //Menu de las monedas
            System.out.println("*** Conversor de monedas ***");
            System.out.println("ARS - Peso argentino");
            System.out.println("BOB - Peso boliviano");
            System.out.println("BRL - Real brasileño");
            System.out.println("CLP - Peso chileno");
            System.out.println("COP - Peso colombiano");
            System.out.println("USD - Dólar estadounidense");
            System.out.println("MXN - Peso mexicano");
            System.out.println("EUR - Euro");
            System.out.println("Salir - Finalizar programa");
            try {
                //Entrada del tipo de moneda
                System.out.print("Ingrese la moneda de origen: ");
                String monedaOrigen = entradaDatos.nextLine().toUpperCase();
                if (monedaOrigen.equals("Salir")) {
                    seguir = false;
                    break;
                }
                //Salida del tipo de moneda
                System.out.print("Ingrese la moneda de salida: ");
                String monedaSalida = entradaDatos.nextLine().toUpperCase();
                if (monedaSalida.equals("Salir")) {
                    seguir = false;
                    break;
                }
                //Error si tiene mas de 3 letras
                if (monedaOrigen.isEmpty() || monedaSalida.isEmpty() || monedaOrigen.length() != 3 || monedaSalida.length() != 3) {
                    throw new IllegalArgumentException("Código de moneda no válido. Debe ser de 3 caracteres.");
                }
                //Ingresando la cantidad de la moneda de entrada
                System.out.print("Ingrese la cantidad que deseas cambiar: ");
                double cantidad = entradaDatos.nextDouble();
                entradaDatos.nextLine();
                //Condicional si el valor es negativo
                if (cantidad <= 0) {
                    throw new IllegalArgumentException("La cantidad debe ser un número positivo.");
                }
                ConsultaAPI.convertirMoneda(monedaOrigen, monedaSalida, cantidad);
                //Comienzo con otra convercion
                System.out.print("\n¿Deseas hacer otra conversión? (si/no): ");
                String respuesta = entradaDatos.nextLine().toLowerCase();
                if (!respuesta.equals("si")) {
                    seguir = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un valor válido.");
                entradaDatos.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        System.out.println("Saliendo del programa.");
    }
}
