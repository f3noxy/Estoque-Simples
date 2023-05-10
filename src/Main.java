public class Main {
    public static void main(String[] args){

        int opcao;

        Estoques estoques = new Estoques();
        Funcoes funcoes = new Funcoes();

        do{

            opcao = funcoes.menu();

            if(opcao == 1){ // Criação de um novo estoque

                estoques.addEstoque();
                funcoes.menuEstoque();

            }
            else if(opcao == 2){ // Seleção/Edição/Exibição do(s) Estoque(s)

                funcoes.menuEstoque();

            }
//            else if(opcao == 3){ // Deletar determinado estoque
//
//
//
//            }
//            else if(opcao == 4){ // Listar os estoques criados
//
//
//
//            }
//            else if(opcao == 5){ // Deletar todos os estoques criados
//
//
//
//            }
            else if(opcao == 0){ // Sair do programa

                break;

            }
            else{

                System.out.print("Digite uma opção válida. \n");

            }

        }while(true);

    }
}