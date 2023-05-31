import java.util.ArrayList;
import java.util.Scanner;

public class Estoques {

    private ArrayList<Estoque> listaDeEstoques = new ArrayList<>();

    public ArrayList<Estoque> getListaDeEstoques() {
        return listaDeEstoques;
    }

    public void setListaDeEstoques(ArrayList<Estoque> listaDeEstoques) {
        this.listaDeEstoques = listaDeEstoques;
    }

    public void addEstoque(){

        Scanner teclado = new Scanner(System.in);

        String nomeNovoEstoque;
        System.out.print("Digite o nome do novo estoque: ");
        nomeNovoEstoque = teclado.nextLine();
        Estoque novoEstoque = new Estoque();
        novoEstoque.setNomeDoEstoque(nomeNovoEstoque);
        listaDeEstoques.add(novoEstoque);

        System.out.printf("O estoque %s foi criado. \n\n", nomeNovoEstoque);

    }

    public void eraseEstoques(){

        Scanner teclado = new Scanner(System.in);

        System.out.print("\nVocê tem certeza que deseja DELETAR todos os estoques existentes?\nDigite SIM para confirmar a ação: ");
        String avaliarConfirmacao = teclado.nextLine();

        if(avaliarConfirmacao.equalsIgnoreCase("sim")){

            ArrayList<Estoque> novaListaEstoques = new ArrayList<>();
            setListaDeEstoques(novaListaEstoques);
            System.out.print("Todos os estoques foram deletados.\n\n");

        }
        else{

            System.out.print("\nVocê não digitou o código correto para a confirmação, então os estoques não foram deletados.\n\n");

        }

    }
}
