public class Pix implements Pagamento{
    
    @Override 
    public void pagar(double valor){
        System.out.println("Pagamento realizado via PIX");
        System.out.println("Valor pago: R$" +valor);
    }
}
