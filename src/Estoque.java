import java.util.Date;
public class Estoque {

    private int quantidadeDeItens;
    private String listaDeItens;

    public void setQuantidadeDeItens(int qtdItens){

        this.quantidadeDeItens = qtdItens;

    }

    public void setListaDeItens(String lista){

        this.listaDeItens = lista;

    }

    public int getQuantidadeDeItens(){

        return quantidadeDeItens;

    }

    public String getListaDeItens(){

        return listaDeItens;

    }


}
