public class Cliente extends  Pessoa implements Pagamento{
    
    public Cliente(String nome) {
        super(nome);
    }


    public void pagar(double valor){

        System.out.println("Pagamento realizado: R$" +valor);
    }
    
    public  void comprar(String Produto, int quantidade, double valor){
        System.out.println("Produto comprado: " +Produto);
        System.out.println("Quantidade: " +quantidade);
        System.out.println("Valor Unitário: " +valor);
        System.out.println("Total: R$" +(quantidade*valor));

        
    }














}



