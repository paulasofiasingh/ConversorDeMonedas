import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        Scanner teclado = new Scanner(System.in);

        String menu = """
                ¡Bienvenid@ al conversor de monedas! =]\n
                *** Escribe el número de la opción deseada ***
                1- Dólar ===> Peso argentino
                2- Peso argentino ===> Dólar
                3- Dólar ===> Real brasileño
                4- Real brasileño ===> Dólar
                5- Dólar ===> Peso colombiano
                6- Peso colombiano ===> Dólar
                7- Salir\n
                """;

        int opcion = 0;
        double cantidad;

        System.out.println(menu);
        while (opcion != 7) {
            opcion = teclado.nextInt();
            String[] monedas = obtenerMonedas(opcion);

            if (monedas != null) {
                System.out.println("Ingresa el valor que deseas convertir:");
                cantidad = teclado.nextDouble();

                // Llama al conversor con la moneda base y objetivo
                double resultado = conversor.convertir(cantidad, monedas[0], monedas[1]);

                System.out.println("El valor " + cantidad + " " + monedas[0] + " corresponde al valor final de ===> " + resultado + " " + monedas[1]);
                System.out.println("**************************************************\n");
                System.out.println(menu);
            } else if (opcion == 7) {
                System.out.println("Saliendo del programa. Gracias por utilizar nuestros servicios.");
            } else {
                System.out.println("Opción no válida");
                System.out.println(menu);
            }
        }
    }

    // Metodo para obtener las monedas según la opción elegida
    public static String[] obtenerMonedas(int opcion) {
        switch (opcion) {
            case 1:
                return new String[]{"USD", "ARS"};
            case 2:
                return new String[]{"ARS", "USD"};
            case 3:
                return new String[]{"USD", "BRL"};
            case 4:
                return new String[]{"BRL", "USD"};
            case 5:
                return new String[]{"USD", "COP"};
            case 6:
                return new String[]{"COP", "USD"};
            case 7:
                return null; // Para salir del programa
            default:
                return null; // Opción no válida
        }
    }
}