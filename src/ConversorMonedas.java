public class ConversorMonedas {

    public double convertir(double cantidad, String monedaBase, String monedaObjetivo) {
        ApiMonedas api = new ApiMonedas();

        // Obtiene la tasa de conversión desde la API
        double tasaConversion = api.obtenerTasaDeConversion(monedaBase, monedaObjetivo);

        // Realiza el cálculo de la conversión
        return cantidad * tasaConversion;
    }
}

