import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        int opcao, qtdEstoquesCriados = -1;

        Scanner teclado = new Scanner(System.in);
        Estoques estoques = new Estoques();
        Funcoes funcoes = new Funcoes();

        do{

            opcao = funcoes.menu();

            if(opcao == 1){ // Criação de um novo estoque

                estoques.addEstoque();
                qtdEstoquesCriados++;
                funcoes.menuEstoque(estoques, qtdEstoquesCriados);

            }
            else if(opcao == 2){

                if(!(estoques.getListaDeEstoques().isEmpty())){
                    System.out.print("Digite qual estoque você deseja exibir: ");
                    int exibirEstoque = teclado.nextInt() - 1;

                    while (exibirEstoque < 0 || exibirEstoque > estoques.getListaDeEstoques().size()) {
                        System.out.print("Por favor digite um estoque válido para ser exibido: ");
                        exibirEstoque = teclado.nextInt() - 1;
                    }

                    estoques.getListaDeEstoques().get(exibirEstoque).showEstoque();
                    funcoes.menuEstoque(estoques, exibirEstoque);


                }
                else{

                    System.out.print("Não é possível exibir nenhum estoque, pois ainda não existe nenhum.\n\n");

                }

            }
            else if(opcao == 3){ // Seleção/Edição/Exibição do(s) Estoque(s)

                if(!(estoques.getListaDeEstoques().isEmpty())){
                    System.out.print("Digite qual estoque você deseja alterar: ");
                    int alterarEstoque = teclado.nextInt() - 1;

                    while (alterarEstoque < 0 || alterarEstoque > estoques.getListaDeEstoques().size()) {
                        System.out.print("Por favor digite um estoque válido para ser alterado: ");
                        alterarEstoque = teclado.nextInt() - 1;
                    }

                    funcoes.menuEstoque(estoques, alterarEstoque);

                }
                else{

                    System.out.print("Não é possível editar nenhum estoque, pois ainda não existe nenhum.\n\n");

                }

            }
//            else if(opcao == 4){ // Deletar determinado estoque
//
//
//
//            }
//            else if(opcao == 5){ // Listar os estoques criados
//
//
//
//            }
//            else if(opcao == 6){ // Deletar todos os estoques criados
//
//
//
//            }
            else if(opcao == 0){ // Sair do programa

                break;

            }
            else{

                System.out.print("Digite uma opção válida.\n");

            }

        }while(true);

    }
}