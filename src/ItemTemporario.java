import java.util.Date;
public class ItemTemporario extends Item{

    private Date dataDeExpiracao;

    public Date getDataDeExpiracao() {
        return dataDeExpiracao;
    }

    public void setDataDeExpiracao(Date dataDeExpiracao) {
        this.dataDeExpiracao = dataDeExpiracao;
    }
}
