import java.util.Scanner;
import java.util.ArrayList;
public class hotel{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        
        
        ArrayList<Integer> quartos = new ArrayList();
        ArrayList<Integer> camas = new ArrayList();
        ArrayList<String> hospede = new ArrayList();
        ArrayList<Integer> quartoReservado = new ArrayList();
        
        
        
        int totalQuartos = 0;
        int totalReservas = 0;
        
        loopExterno1 :while (true) { // isso se chama label, basicamente eu dou um nome ao meu loop pra conseguir encerrar ele no final (usei pq tava dando erro no break e fiquei com preguiça de arrumar)
            
            System.out.println("== MENU ==");
            System.out.println("1 - Registrar número de quartos");
            System.out.println("2 - Registrar quantidade de camas");
            System.out.println("3 - Reservar quarto");
            System.out.println("4 - Consultar reservas por quarto");
            System.out.println("5 - Consultar reservas por hóspede ");
            System.out.println("6 - Sair");
            int escolhaMenu = sc.nextInt();
            sc.nextLine();
            
            switch (escolhaMenu) {
                case 1:
                    System.out.print("Qual o numero do quarto que deseja cadastrar? -->> ");
                    int cadastrarQuarto = sc.nextInt();
                    sc.nextLine();
                    
                    
                    if (quartos.size() == 5){
                        System.out.print("O limite de quartos cadastrados chegou ao limite!!! ");
                        
                    }else if (quartos.contains(cadastrarQuarto)){
                        System.out.println("O quarto " + cadastrarQuarto + " ja foi cadastrado");
                        
                    }else{
                        System.out.println("Quarto cadastrado com sucesso");
                        quartos.add(cadastrarQuarto);
                        totalQuartos++;

                    }
                    
                    break;
                    
                case 2:
                        for(int i = 0; i < quartos.size(); i++ ){
                            System.out.print("Quantas camas tem o quarto "+ quartos.get(i)+ "?");
                            int quantidadeCamas = sc.nextInt();
                            sc.nextLine();
                            camas.add(quantidadeCamas);

                            System.out.println("No quarto " +quartos.get(i) + "tem " +quantidadeCamas+ " camas");
                            
                            
                        }
                        break;
                        case 3:
                            System.out.println("Qual quarto gostaria de reservar?");
                            int ReservarQuarto = sc.nextInt();
                            sc.nextLine();


                            
                            
                    int posicao = quartos.indexOf(ReservarQuarto); // aqui eu peguei o valor do quarto pra descobrir em qual indice ele tava dentro da lista

                        if (!quartos.contains(ReservarQuarto)){ // o ! aqui quer dizer não, se dentro do array quarto não tiver o valor dgitado no "Reservar quarto" usamos o ! pra dizer (não, isso não esta aqui ou não isso não está acontecendo)
                            System.out.println("o quarto" + ReservarQuarto + "não existe !!!");


                        } else if (camas.get(posicao) == 0){
                                System.out.println("O quarto" + ReservarQuarto + "Não tem camas!!! '");
                             //camas.get(posicao); cara eu nn sei como eu n tava conseguindo raciocinar isso, o valor do indice do quarto está na variavel posicao, aqui eu consigo acessar esse valor
                            }else if (hospede.size() >= 25){
                                System.out.print("O hotel alcançou o limite máximo de reservas");
                                
                            }else {
                                System.out.println("Qual o nome do hóspede que deseja fazer a reserva? ");
                                String nomeHospede = sc.nextLine();
                                hospede.add(nomeHospede);
                                quartoReservado.add(ReservarQuarto);
                                camas.set(posicao, camas.get(posicao) -1 ); // o set subistitui um indice, então esotu subistituindo o indice da variavel posição 
                                System.out.println("Reserva feita com sucesso !!");
                                
                                

                            }
                            



                        break;
                case 4:
                    System.out.print("Qual quarto gostaria de consultar? --->>>");
                    int consultarQuarto = sc.nextInt();
                    sc.nextLine();

                        boolean encontrou = false;
                    
                    if (!quartos.contains(consultarQuarto)){
                        System.out.println("Esse quarto não existe");
                    }else{
                        for (int i = 0; i < quartoReservado.size(); i++) {
                           if (quartoReservado.get(i) == consultarQuarto) {
                            System.out.println(hospede.get(i));
                            encontrou = true;
                            }
                        }   
                        if (!encontrou){
                            System.out.println("Não há reservas nesse quarto ");
                        }
                    }
                    
                    break;
                    
                case 5:
                    boolean encontrouHospede = false; 
                    System.out.print("Qual o nome do hospede que deseja consultar? --->>>  ");
                    String consultarHospede = sc.nextLine();
                 // para fazer a comparação de 2 strings usamos o .equals(), porém ele é sensivel a letras maiusculas e minusculas então podemos usar
                 // .eqyualsignorecase()

                 for (int i = 0; i < hospede.size(); i++){
                    if (hospede.get(i).equals(consultarHospede)) {
                        System.out.println(quartoReservado.get(i));
                           encontrouHospede = true;


                    }
                }
                   if (!encontrouHospede){
                        System.out.print("Não tem reservas para esté hóspede");
                    }
                 break;





                case 6:
                            System.out.println("Saindo...");
                            sc.close();
                         break loopExterno1; // aqui eu encerro o loop com o nome q eu dei pra ele, é um ngc até q legal e poupou mt t
                            
                
                    }
                    
        }  
        
    }
}