import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcao;
        Scanner teclado = new Scanner(System.in);

        do{

            Funcoes funcoes = new Funcoes();

            opcao = funcoes.menu();

            if(opcao == 1){ // Criação de um novo estoque

                int opcaoEstoque;

                do {

                    String novoEstoque;

                    System.out.print("Digite o nome do novo estoque: ");
                    novoEstoque = teclado.nextLine();
                    System.out.printf("O estoque %s foi criado. \n\n", novoEstoque);

                    opcaoEstoque = funcoes.menuEstoque();

                }while(opcaoEstoque != 0);

            }
            else if(opcao == 2){ // Seleção/Edição/Exibição do(s) Estoque(s)

                int opcaoEstoque;

                do {

                    opcaoEstoque = funcoes.menuEstoque();

                }while(opcaoEstoque != 0);

            }

        }while(opcao != 0);

    }
}