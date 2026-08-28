package atividades_vetor;
import java.time.*;
import java.util.Scanner;
import java.util.ArrayList;

// Uma loja precisa de um sistema simples para controlar seus produtos.
// Você deverá criar um programa em Java que permita:
// Funcionalidades obrigatórias
// 1-Cadastrar produto
// -Solicitar nome do produto
// -Solicitar quantidade em estoque
// -Armazenar em arrays
// 2-Listar produtos
// -Mostrar todos os produtos cadastrados
// -Exibir índice, nome e quantidade
// 3-Pesquisar produto
// -Buscar pelo nome
// -Mostrar dados se encontrado
// 4-Alterar produto
// -Buscar produto pelo nome
// -Permitir alterar nome e quantidade
// 5-Remover produto
// -Buscar pelo nome
// -Remover deslocando os elementos do array
// 6-Sair do sistema
// Regras do Sistema:
// Capacidade máxima: 5 produtos
// Controlar cadastros com variável qtd
// Não deixar espaços vazios no array ao remover
public class vetor7 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> produtos = new ArrayList<>();
        
        int quantidade_produtos = 0;
        
        while (true) {
            
            System.out.println("==MENU==");
            System.out.println("1- Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Pesquisar produto");
            System.out.println("4 - Alterar produto");
            System.out.println("5 - Sair");

        int escolha_menu = sc.nextInt();
        sc.nextLine();
        
        switch (escolha_menu) {
            case 1:
                System.out.println("Qual o produto deseja cadastrar?");
                String cadastrar_produto = sc.nextLine();
                produtos.add(cadastrar_produto);
                System.out.println("O produto " +cadastrar_produto+ " foi cadastrado com sucesso");
                quantidade_produtos += 1;
                break;
            case 2:
                 for (int i = 0; i < produtos.size(); i++){
                    System.out.println(produtos.get(i));
                    }
                    break;
            case 4:
                    for(int i =0; i < produtos.size(); i ++){
                        System.out.println(i + " = " + produtos.get(i));

                    }
                    
                    System.out.println("Digite o indice do produto -->> ");
                    int atualizar_indice = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Digite o novo produto -->> ");
                    String novoproduto = sc.nextLine();
                    
                    produtos.set(atualizar_indice, novoproduto); // o .set servep pra subistituir um indice dentro da lista
                    break;
                    
                    case 3:
                        for(int i =0; i < produtos.size(); i ++){
                            System.out.println(i + " = " + produtos.get(i));
                            System.out.println("Digite o indice do produto que deseja pesquisar -->> ");
                            int remover_produto = sc.nextInt();
                            sc.nextLine();
                            produtos.remove(remover_produto);// no .remove coloca apenas de um argumento, o indice q quer apagar
                        }
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        TimeUnit.SECONDS.sleep(5);
                        break;
                            
                        }
                        
                    }
                    
                    
                sc.close();
            }
            

    }
}