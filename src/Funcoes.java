import java.util.Scanner;

public class Funcoes {

    public int menu(){

        Scanner teclado = new Scanner(System.in);

        int opcao;

        System.out.println("1. Criar estoque");
        System.out.println("2. Exibir estoque");
        System.out.println("3. Editar estoque");
        System.out.println("4. Deletar estoque");
        System.out.println("5. Listar estoques");
        System.out.println("6. Mudar item de estoque");
        System.out.println("7. Deletar todos os estoques");
        System.out.println("0. Sair");
        System.out.print("Digite o número correspodente a opção desejada: ");
        opcao = teclado.nextInt();

        return opcao;

    }

    public void menuEstoque(Estoques estoques, int estoque){

        Scanner teclado = new Scanner(System.in);

        int opcao, contador = 0;

        do {

            if(contador > 0){

                estoques.getListaDeEstoques().get(estoque).showEstoque();

            }

            System.out.println("1. Criar item");
            System.out.println("2. Criar item temporário");
            System.out.println("3. Atualizar item");
            System.out.println("4. Apagar item");
            System.out.println("5. Apagar todos os itens do estoque");
            System.out.println("0. Sair do estoque");
            System.out.print("Digite o número correspodente a opção desejada: ");
            opcao = teclado.nextInt();

            if(opcao == 1){

                estoques.getListaDeEstoques().get(estoque).addItem();

            }
            else if(opcao == 2){

                estoques.getListaDeEstoques().get(estoque).addItemTemporario();

            }
            else if(opcao == 3){

                if(estoques.getListaDeEstoques().get(estoque).getQuantidadeDeItens() != 0){

                    estoques.getListaDeEstoques().get(estoque).updateItem();

                }
                else{

                    System.out.print("Não é possível atualizar itens, pois ainda não existe nenhum item nesse estoque.\n\n");

                }

            }
            else if(opcao == 4){
                if(estoques.getListaDeEstoques().get(estoque).getQuantidadeDeItens() != 0){

                    estoques.getListaDeEstoques().get(estoque).removeItem();

                }
                else{

                    System.out.print("Não é possível remover itens, pois ainda não existe nenhum item nesse estoque.\n\n");

                }
            }
            else if(opcao == 5){
                if(estoques.getListaDeEstoques().get(estoque).getQuantidadeDeItens() != 0){

                    estoques.getListaDeEstoques().get(estoque).eraseEstoque();

                }
                else{

                    System.out.print("Não é possível apagar todos os do itens, pois ainda não existe nenhum item nesse estoque.\n\n");

                }
            }
            else if(opcao == 0){

                break;

            }
            else{

                System.out.print("Por favor digite uma opção válida.\n\n\n");

            }
            contador++;
        }while(true);

    }

    public void formatarTabela(String paraFormatar){
        for(int j = 5; j <= 50; j += 5){
            if(paraFormatar.length() <= j){
                int x = (55 - j)/5;
                while(x > 0){
                    System.out.print("\t");
                    x--;
                }
                break;
            }
        }
    }

}