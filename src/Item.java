import java.util.Date;
public class Item {

    private String Identificador;
    private int quantidade;
    private Date dataDeRegistro = new Date();

    public String getIdentificador(){
        return Identificador;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public Date getDataDeRegistro(){
        return dataDeRegistro;
    }

    public void setIdentificador(String id){
        Identificador = id;
    }

    public void setQuantidade(int qtd){
        this.quantidade = qtd;
    }

    public void setDataDeRegistro(Date data){
        this.dataDeRegistro = data;
    }

}
