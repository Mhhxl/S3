public class CaclApp {
    public static void main(String[] args) {
        Calculadora Calc = new Calculadora();
        System.out.println(Calc.somar(10, 5));
        System.out.println(Calc.somar(10, 5, 20));
        System.out.println(Calc.somar(10.5, 5.2));
    }
}
