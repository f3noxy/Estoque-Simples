import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

    private String nomeDoEstoque;
    private int quantidadeDeItens = 0;
    private ArrayList<Item> listaDeItens = new ArrayList<>();

    public void setNomeDoEstoque(String nomeDoEstoque) {
        this.nomeDoEstoque = nomeDoEstoque;
    }

    public void setQuantidadeDeItens(int qtdItens){
        this.quantidadeDeItens = qtdItens;
    }

    public void setListaDeItens(ArrayList<Item> lista){
        this.listaDeItens = lista;
    }

    public String getNomeDoEstoque() {
        return nomeDoEstoque;
    }

    public int getQuantidadeDeItens(){
        return quantidadeDeItens;
    }

    public ArrayList<Item> getListaDeItens(){
        return listaDeItens;
    }

    public void updateItem(){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o número do item que você deseja alterar: ");
        int itemAlterar = teclado.nextInt();

        while(itemAlterar > this.listaDeItens.size() || itemAlterar < 0){
            System.out.print("Por favor digite um item válido a ser alterado: ");
            itemAlterar = teclado.nextInt();
        }

        teclado.nextLine();

        System.out.print("Digite quais atributos você deseja alterar (identificador e/ou quantidade): ");
        String atributosAlterar = teclado.nextLine();

        while(atributosAlterar.isEmpty() || !(atributosAlterar.toLowerCase().contains("identificador")) && !(atributosAlterar.toLowerCase().contains("quantidade"))){
            System.out.print("Por favor digite pelo menos um atributo válido a ser alterado: ");
            atributosAlterar = teclado.nextLine();
        }

        Item itemAtualizado = new Item();

        if(atributosAlterar.toLowerCase().contains("identificador")){
            System.out.print("Digite o novo identificador: ");
            String novoIdentificador = teclado.nextLine();
            itemAtualizado.setIdentificador(novoIdentificador);
            System.out.print("O identificador do item foi alterado com sucesso.\n\n");
        }
        else{
            itemAtualizado.setIdentificador(this.listaDeItens.get(itemAlterar).getIdentificador());
        }

        if(atributosAlterar.toLowerCase().contains("quantidade")){
            System.out.print("Digite a nova quantidade de itens: ");
            int novaQuantidade = teclado.nextInt();
            itemAtualizado.setQuantidade(novaQuantidade);
            System.out.print("A quantidade de itens foi alterada com sucesso.\n\n");
        }
        else{
            itemAtualizado.setQuantidade(this.listaDeItens.get(itemAlterar).getQuantidade());
        }

        this.listaDeItens.set(itemAlterar, itemAtualizado);

    }

}
