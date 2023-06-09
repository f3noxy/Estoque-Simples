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

    public void showEstoques(){

        System.out.println("\nEstoques criados:\n");

        for(int i = 0; i < this.listaDeEstoques.size(); i++){
            System.out.printf("%d - %s (%d)\n", i+1, this.listaDeEstoques.get(i).getNomeDoEstoque(), this.listaDeEstoques.get(i).getQuantidadeDeItens());
        }

    }

    public void removeEstoque(){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite N para apagar o estoque pelo nome ou I para apagar pelo índicie: ");
        String opcaoApagar = teclado.nextLine();
        while(!(opcaoApagar.equalsIgnoreCase("N")) && !(opcaoApagar.equalsIgnoreCase("I"))){
            System.out.print("Por favor digite uma opção válida: ");
            opcaoApagar = teclado.nextLine();
        }

        if(opcaoApagar.equalsIgnoreCase("N")){

            System.out.print("Digite o nome do estoque a ser apagado: ");
            String estoqueParaApagar = teclado.nextLine();

            for(int i = 0; i < listaDeEstoques.size(); i++){
                if(listaDeEstoques.get(i).getNomeDoEstoque().equalsIgnoreCase(estoqueParaApagar)){
                    System.out.printf("O estoque %s foi apagado.\n", listaDeEstoques.get(i).getNomeDoEstoque());
                    listaDeEstoques.remove(i);
                    break;
                }
                if(i == listaDeEstoques.size() - 1){
                    System.out.printf("Nenhum estoque com o nome %s foi encontrado.\n\n", estoqueParaApagar);
                }
            }
        }
        else{

            System.out.print("Digite o índice do estoque a ser apagado: ");
            int estoqueParaApagar = teclado.nextInt() - 1;

            if(estoqueParaApagar >= listaDeEstoques.size() || estoqueParaApagar < 0){
                System.out.print("Não existe nenhum estoque com o índice informado.\n\n");
            }
            else{
                System.out.printf("O estoque %s foi apagado.\n", listaDeEstoques.get(estoqueParaApagar).getNomeDoEstoque());
                listaDeEstoques.remove(estoqueParaApagar);
            }

        }
    }

    public void changeItemEstoque(){

        Scanner teclado = new Scanner(System.in);

        this.showEstoques();
        System.out.print("Digite o índice do estoque que contém o item que será movido para outro estoque: ");
        int indEstoquePerde = teclado.nextInt() - 1;

        while(indEstoquePerde < 0 || indEstoquePerde > this.getListaDeEstoques().size() - 1){
            System.out.print("O índice do estoque informado não existe, por favor informe um válido: ");
            indEstoquePerde = teclado.nextInt() - 1;
        }

        while(this.getListaDeEstoques().get(indEstoquePerde).getListaDeItens().isEmpty()){
            System.out.print("O estoque informado não contém itens, por tanto não é possível pegar nenhum item para mover, informe um estoque válido e com itens: ");
            indEstoquePerde = teclado.nextInt() - 1;
            while(indEstoquePerde < 0 || indEstoquePerde > this.getListaDeEstoques().size() - 1) {
                System.out.print("O índice do estoque informado não existe, por favor informe um válido: ");
                indEstoquePerde = teclado.nextInt() - 1;
            }
        }

        this.showEstoques();
        System.out.print("Digite o índice do estoque que receberá o item: ");
        int indEstoqueRecebe = teclado.nextInt() - 1;

        while(indEstoqueRecebe == indEstoquePerde || indEstoqueRecebe < 0 || indEstoqueRecebe > this.getListaDeEstoques().size() - 1){
            System.out.print("O índice dos estoques informados são iguais ou o indíce informado não existe, por favor informe um válido: ");
            indEstoqueRecebe = teclado.nextInt() - 1;
        }

        this.getListaDeEstoques().get(indEstoquePerde).showItens();
        System.out.print("Digite o índice do item que você deseja realizar a troca: ");
        int indItem = teclado.nextInt() - 1;

        while(indItem > this.getListaDeEstoques().get(indEstoquePerde).getListaDeItens().size() - 1 || indItem < 0){
            System.out.print("O índice do item informado não existe, por favor digite um válido: ");
            indItem = teclado.nextInt() - 1;
        }

        Item itemTemp = this.getListaDeEstoques().get(indEstoquePerde).getListaDeItens().get(indItem);
        this.getListaDeEstoques().get(indEstoquePerde).setQuantidadeDeItens(this.getListaDeEstoques().get(indEstoquePerde).getQuantidadeDeItens() - 1);
        this.getListaDeEstoques().get(indEstoquePerde).getListaDeItens().remove(indItem);
        this.getListaDeEstoques().get(indEstoqueRecebe).getListaDeItens().add(itemTemp);
        this.getListaDeEstoques().get(indEstoqueRecebe).setQuantidadeDeItens(this.getListaDeEstoques().get(indEstoquePerde).getQuantidadeDeItens() + 1);

        System.out.printf("O item %s do estoque %s foi trocado com sucesso para o estoque %s.\n\n", itemTemp.getIdentificador(), this.getListaDeEstoques().get(indEstoquePerde).getNomeDoEstoque(), this.getListaDeEstoques().get(indEstoqueRecebe).getNomeDoEstoque());

    }
}