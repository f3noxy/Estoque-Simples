import java.util.Scanner;

public class Funcoes {

    public int menu(){

        Scanner teclado = new Scanner(System.in);

        int opcao;

        System.out.println("1. Criar estoque");
        System.out.println("2. Editar estoque");
        System.out.println("3. Deletar estoque");
        System.out.println("4. Listar estoques");
        System.out.println("5. Deletar todos os estoques");
        System.out.println("0. Sair");
        System.out.print("Digite o número correspodente a opção desejada: ");
        opcao = teclado.nextInt();

        return opcao;

    }

    public void menuEstoque(){

        Scanner teclado = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("1. Criar item");
            System.out.println("2. Criar item temporário");
            System.out.println("3. Atualizar item");
            System.out.println("4. Apagar item");
            System.out.println("5. Mudar item de estoque");
            System.out.println("0. Sair do estoque");
            System.out.print("Digite o número correspodente a opção desejada: ");
            opcao = teclado.nextInt();
            teclado.nextLine();


        }while(opcao != 0);

    }

}
