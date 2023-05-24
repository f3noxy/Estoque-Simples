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

    public void removeItem(){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o indíce do item que você deseja remover: ");
        int itemRemover = teclado.nextInt();

        while(itemRemover > this.listaDeItens.size() || itemRemover < 0){
            System.out.print("Por favor digite um item válido a ser alterado: ");
            itemRemover = teclado.nextInt();
        }

        System.out.printf("O item %s foi removido com sucesso.\n\n", this.listaDeItens.get(itemRemover - 1).getIdentificador());
        this.listaDeItens.remove(itemRemover - 1);


    }

    public void showEstoque(){

        System.out.print("\n| - Nome do estoque: " + this.nomeDoEstoque + "\n");
        System.out.print("| - Quantidade de itens: " + this.quantidadeDeItens + "\n");
        System.out.print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        for(int i = 0; i < this.quantidadeDeItens; i++){
            System.out.printf("Nome do %d item: %s | ", i+1, listaDeItens.get(i).getIdentificador());
            System.out.printf("Quantidade do %d item: %d | ", i+1, listaDeItens.get(i).getQuantidade());
            System.out.printf("Data de registro do " + i+1 + " item: " + listaDeItens.get(i).getDataDeRegistro() + "\n\n");
        }

    }

}
