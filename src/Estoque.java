import java.util.ArrayList;
public class Estoque {

    private String nomeDoEstoque;
    private int quantidadeDeItens = 0;
    private ArrayList<Item> listaDeItens = new ArrayList<Item>();

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

}
