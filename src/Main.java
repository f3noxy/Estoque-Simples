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
                estoques.getListaDeEstoques().get(qtdEstoquesCriados).showEstoque();
                funcoes.menuEstoque(estoques, qtdEstoquesCriados);

            }
            else if(opcao == 2){

                if(!(estoques.getListaDeEstoques().isEmpty())){
                    estoques.showEstoques();
                    System.out.print("Digite qual estoque você deseja exibir: ");
                    int exibirEstoque = teclado.nextInt() - 1;

                    while (exibirEstoque < 0 || exibirEstoque > estoques.getListaDeEstoques().size() - 1) {
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
                    System.out.print("\n");

                    while (alterarEstoque < 0 || alterarEstoque > estoques.getListaDeEstoques().size() - 1) {
                        System.out.print("Por favor digite um estoque válido para ser alterado: ");
                        alterarEstoque = teclado.nextInt() - 1;
                        System.out.print("\n");
                    }

                    funcoes.menuEstoque(estoques, alterarEstoque);

                }
                else{

                    System.out.print("Não é possível editar nenhum estoque, pois ainda não existe nenhum.\n\n");

                }

            }
            else if(opcao == 4){ // Deletar determinado estoque

                if(!(estoques.getListaDeEstoques().isEmpty())){

                    estoques.removeEstoque();

                }
                else{

                    System.out.print("Não é possível deletar nenhum estoque, pois ainda não existe nenhum.\n\n");

                }
            }
            else if(opcao == 5){ // Listar os estoques criados

                if(!(estoques.getListaDeEstoques().isEmpty())){

                    estoques.showEstoques();

                }
                else{

                    System.out.print("Não é possível listar nenhum estoque, pois ainda não existe nenhum.\n\n");

                }

            }
            else if(opcao == 6){ // Mudar um item de um estoque para outro
                if(estoques.getListaDeEstoques().size() >= 2){

                    estoques.changeItemEstoque();

                }
                else{

                    System.out.print("Não é possível trocar itens entre estoques, pois ainda não existem estoques o suficiente.\n\n");

                }
            }
            else if(opcao == 7){ // Deletar todos os estoques criados

                if(!(estoques.getListaDeEstoques().isEmpty())){

                    estoques.eraseEstoques();

                }
                else{

                    System.out.print("Não é possível apagar todos os estoques, pois ainda não existe nenhum.\n\n");

                }

            }
            else if(opcao == 0){ // Sair do programa

                break;

            }
            else{

                System.out.print("Digite uma opção válida.\n");

            }
            System.out.print("\n");

        }while(true);

    }

}