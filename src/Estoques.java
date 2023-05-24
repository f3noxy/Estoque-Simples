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
}
