import java.util.Date;
public class Item {

    private String identificador;
    private int quantidade;
    private Date dataDeRegistro = new Date();

    public String getIdentificador(){
        return identificador;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public Date getDataDeRegistro(){
        return dataDeRegistro;
    }

    public void setIdentificador(String id){
        identificador = id;
    }

    public void setQuantidade(int qtd){
        this.quantidade = qtd;
    }

    public void setDataDeRegistro(Date data){
        this.dataDeRegistro = data;
    }

}
