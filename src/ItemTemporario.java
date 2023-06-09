import java.util.Date;
public class ItemTemporario extends Item{

    private Date dataDeExpiracao = new Date();

    public Date getDataDeExpiracao() {
        return dataDeExpiracao;
    }

    public void setDataDeExpiracao(Date dataDeExpiracao) {
        this.dataDeExpiracao = dataDeExpiracao;
    }
}
