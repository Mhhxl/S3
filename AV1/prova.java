import java.util.Scanner;
import java.util.ArrayList;
public class prova{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> numeroAviões = new ArrayList<Integer>();
    ArrayList<Integer> quantidadeAssentosLivres = new ArrayList<Integer>();
    ArrayList<String> nomePassageiros = new ArrayList<String>();
    ArrayList<Integer> numeroAviõesCadaReserva = new ArrayList<Integer>();


    loop1 :while (true) {

        System.out.println("");

        System.out.println("==MENU==");
        System.out.println("1 - Cadastrar Avião");
        System.out.println("2 - Cadastrar quantidade de assentos");
        System.out.println("3 - listar aviões ");
        System.out.println("4 - Realizar reserva");
        System.out.println("5 - Consultar reservas de um avião");
        System.out.println("6 - Pesquisar passageiro");
        System.out.println("7 - Mostrar resumo");
        System.out.println("8 - Sair");
        System.out.print("Digite a opção desejada --->>> ");
        int opcao = sc.nextInt();
        sc.nextLine();


        switch (opcao) {
            case 1:
                // Cadastrar Avião (cada avião pode permitir de 0 a  20 assentos )
                System.out.print("Digite o número do avião: ");
                if (numeroAviões.size() >= 4) {
                    System.out.println("Limite máximo de aviões atingido.");
                    break;
                }else{
                    int cadastrarAviao = sc.nextInt();
                    numeroAviões.add(cadastrarAviao);
                    System.out.print("Avião cadastrado com sucesso!");
                    continue;
                    
                }
            
            case 2:
                // Cadastrar quantidade de assentos
                System.out.print("Digite o número do avião : ");
                int numeroAviaoAssentos = sc.nextInt();
                if (numeroAviões.contains(numeroAviaoAssentos)) {
                    System.out.print("Digite a quantidade de assentos: ");
                    int quantidadeAssentos = sc.nextInt();
                    quantidadeAssentosLivres.add(quantidadeAssentos);
                    System.out.print("Quantidade de assentos cadastrada com sucesso!");
                    continue;
                } else if (quantidadeAssentosLivres.size() >= 20) {
                    System.out.print("Número máximo de assentos atingido!");
                    continue;
                } else {
                    System.out.print("Avião não encontrado. Cadastre o avião primeiro.");
                    continue;
                    
                }
                
            case 3:
                // Listar aviões
                System.out.println("Aviões cadastrados:");

                for (int i = 0; i < numeroAviões.size(); i++) {
                    System.out.println("Avião: " + numeroAviões.get(i) + " - Assentos livres: " + quantidadeAssentosLivres.get(i));

                }
                if (numeroAviões.size() == 0) {
                    System.out.println("Nenhum avião cadastrado.");
                }
                continue;
            case 4:
                // Realizar reserva
                System.out.print("Digite o número do avião: ");
                int numeroAviaoReserva = sc.nextInt();
                if (numeroAviões.contains(numeroAviaoReserva)) {
                    int index = numeroAviões.indexOf(numeroAviaoReserva);
                    if (quantidadeAssentosLivres.get(index) > 0) {
                        System.out.print("Digite o nome do passageiro: ");
                        String nomePassageiro = sc.next();
                        nomePassageiros.add(nomePassageiro);
                        numeroAviõesCadaReserva.add(numeroAviaoReserva);
                        quantidadeAssentosLivres.set(index, quantidadeAssentosLivres.get(index) - 1);
                        System.out.println("A reserva foi feita!");
                    } else {
                        System.out.println("Não tem assentos disponíveis para este avião.");
                    }
                } else {
                    System.out.println("Avião não encontrado.");
                }
                continue;
            case 5 :
                // Consultar reservas de um avião
                System.out.print("Digite o número do avião: ");
                int numeroAviaoConsulta = sc.nextInt();
                if (numeroAviões.contains(numeroAviaoConsulta)) {
                    System.out.println("Reservas para o avião " + numeroAviaoConsulta + ":" );
                    for (int i = 0; i < numeroAviõesCadaReserva.size(); i++) {
                        if (numeroAviõesCadaReserva.get(i) == numeroAviaoConsulta) {
                            System.out.println("- " + nomePassageiros.get(i));
                        }
                    }
                } else {
                    System.out.println("Avião não encontrado.");
                }
                continue;
            case 6:
                // Pesquisar passageiro
                System.out.print("Digite o nome do passageiro: ");
                String nomePassageiroPesquisa = sc.next();
                boolean encontrado = false;
                for (int i = 0; i < nomePassageiros.size(); i++) {
                    if (nomePassageiros.get(i).equals(nomePassageiroPesquisa)) {
                        System.out.println("Passageiro encontrado no avião " + numeroAviõesCadaReserva.get(i));
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Passageiro não encontrado.");
                }
                continue;
            case 7:
                // Mostrar resumo
                System.out.println("Resumo das reservas:");
                for (int i = 0; i < numeroAviões.size(); i++) {
                    System.out.println("Avião: " + numeroAviões.get(i) + " - Assentos livres: " + quantidadeAssentosLivres.get(i));
                }
                continue;
            case 8:
                // Sair
                System.out.println("Saindo...");
                break;
        }
        
        
        break loop1;
    }

    sc.close();

    }
}