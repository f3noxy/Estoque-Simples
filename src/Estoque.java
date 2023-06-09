import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Estoque {

    private String nomeDoEstoque;
    private int quantidadeDeItens = 0;
    private ArrayList<Item> listaDeItens = new ArrayList<>();

    private ArrayList<ItemTemporario> listaDeItensTemporarios = new ArrayList<>();

    public void setNomeDoEstoque(String nomeDoEstoque) {
        this.nomeDoEstoque = nomeDoEstoque;
    }

    public void setQuantidadeDeItens(int qtdItens) {
        this.quantidadeDeItens = qtdItens;
    }

    public void setListaDeItens(ArrayList<Item> lista) {
        this.listaDeItens = lista;
    }

    public String getNomeDoEstoque() {
        return nomeDoEstoque;
    }

    public int getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public ArrayList<ItemTemporario> getListaDeItensTemporarios() {
        return listaDeItensTemporarios;
    }

    public void setListaDeItensTemporarios(ArrayList<ItemTemporario> listaDeItensTemporarios) {
        this.listaDeItensTemporarios = listaDeItensTemporarios;
    }

    public void addItem() {

        Scanner teclado = new Scanner(System.in);
        Item novoItem = new Item();

        System.out.print("Digite o nome do novo item: ");
        novoItem.setIdentificador(teclado.nextLine());

        System.out.print("Digite a quantidade de itens do novo item: ");
        int quantidadeNovoItem = teclado.nextInt();

        while(quantidadeNovoItem < 0){
            System.out.print("Digite uma quantidade válida para o novo item: ");
            quantidadeNovoItem = teclado.nextInt();
        }
        novoItem.setQuantidade(quantidadeNovoItem);

        novoItem.setDataDeRegistro(new Date());

        this.listaDeItens.add(novoItem);
        this.quantidadeDeItens++;

        System.out.printf("O item %s com a quantidade %d foi criado na data %s com sucesso.\n\n", novoItem.getIdentificador(), novoItem.getQuantidade(), novoItem.getDataDeRegistro().toString());

    }

    public void addItemTemporario(){

        Scanner teclado = new Scanner(System.in);
        ItemTemporario novoItemTemporario = new ItemTemporario();

        System.out.print("Digite o nome do novo item temporário: ");
        novoItemTemporario.setIdentificador(teclado.nextLine());

        System.out.print("Digite a quantidade de itens do novo item: ");
        int quantidadeNovoItem = teclado.nextInt();

        while(quantidadeNovoItem < 0){
            System.out.print("Digite uma quantidade válida para o novo item: ");
            quantidadeNovoItem = teclado.nextInt();
        }
        novoItemTemporario.setQuantidade(quantidadeNovoItem);

        novoItemTemporario.setDataDeRegistro(new Date());

        System.out.print("Digite em quantos dias o item temporário será apagado: ");
        long diasParaApagar = teclado.nextLong();

        novoItemTemporario.getDataDeExpiracao().setTime(novoItemTemporario.getDataDeRegistro().getTime() + (diasParaApagar*86400000));

        this.listaDeItensTemporarios.add(novoItemTemporario);
        this.quantidadeDeItens++;

        System.out.printf("O item %s com a quantidade %d foi criado na data %s com sucesso.\n", novoItemTemporario.getIdentificador(), novoItemTemporario.getQuantidade(), novoItemTemporario.getDataDeRegistro().toString());
        System.out.printf("O item será apagado automaticamente na data de %s.\n\n", novoItemTemporario.getDataDeExpiracao().toString());

    }

    public void checkItemTemporario() {

        int quantidadeItensTemporarioApagados = 0;

        if(!(this.listaDeItensTemporarios.isEmpty())){
            for(int i = 0; i < this.listaDeItensTemporarios.size(); i++){
                if(this.listaDeItensTemporarios.get(i).getDataDeExpiracao().before(new Date())){
                    getListaDeItensTemporarios().remove(i);
                    quantidadeItensTemporarioApagados++;
                    this.quantidadeDeItens--;
                }
            }
        }

        if(quantidadeItensTemporarioApagados > 0){
            System.out.printf("Foram apagados %d itens temporários desde a ultima vez que você abriu esse estoque.\n\n", quantidadeItensTemporarioApagados);
        }

    }
    public void updateItem() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o número do item que você deseja alterar: ");
        int itemAlterar = teclado.nextInt();

        while (itemAlterar > this.listaDeItens.size() || itemAlterar < 0) {
            System.out.print("Por favor digite um item válido a ser alterado: ");
            itemAlterar = teclado.nextInt();
        }

        teclado.nextLine();

        System.out.print("Digite quais atributos você deseja alterar (identificador e/ou quantidade): ");
        String atributosAlterar = teclado.nextLine();

        while (atributosAlterar.isEmpty() || !(atributosAlterar.toLowerCase().contains("identificador")) && !(atributosAlterar.toLowerCase().contains("quantidade"))) {
            System.out.print("Por favor digite pelo menos um atributo válido a ser alterado: ");
            atributosAlterar = teclado.nextLine();
        }

        Item itemAtualizado = new Item();

        if (atributosAlterar.toLowerCase().contains("identificador")) {
            System.out.print("Digite o novo identificador: ");
            String novoIdentificador = teclado.nextLine();
            itemAtualizado.setIdentificador(novoIdentificador);
            System.out.print("O identificador do item foi alterado com sucesso.\n\n");
        } else {
            itemAtualizado.setIdentificador(this.listaDeItens.get(itemAlterar).getIdentificador());
        }

        if (atributosAlterar.toLowerCase().contains("quantidade")) {
            System.out.print("Digite a nova quantidade de itens: ");
            int novaQuantidade = teclado.nextInt();
            itemAtualizado.setQuantidade(novaQuantidade);
            System.out.print("A quantidade de itens foi alterada com sucesso.\n\n");
        } else {
            itemAtualizado.setQuantidade(this.listaDeItens.get(itemAlterar).getQuantidade());
        }

        this.listaDeItens.set(itemAlterar, itemAtualizado);

    }

    public void removeItem() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o indíce do item que você deseja remover: ");
        int itemRemover = teclado.nextInt();

        while (itemRemover > this.listaDeItens.size() || itemRemover < 0) {
            System.out.print("Por favor digite um item válido a ser alterado: ");
            itemRemover = teclado.nextInt();
        }

        System.out.printf("O item %s foi removido com sucesso.\n\n", this.listaDeItens.get(itemRemover - 1).getIdentificador());
        this.quantidadeDeItens--;
        this.listaDeItens.remove(itemRemover - 1);

    }

    public void showEstoque() {

        Funcoes funcoes = new Funcoes();

        checkItemTemporario();
        boolean adicionou = false;
        if(getListaDeItens().size() < getQuantidadeDeItens()) {
            for (int x = 0; x < getListaDeItensTemporarios().size(); x++) {
                getListaDeItens().add(getListaDeItensTemporarios().get(x));
            }
            adicionou = true;
        }

        System.out.print("\n| - Nome do estoque: " + getNomeDoEstoque() + "\n");
        System.out.print("| - Quantidade de itens: " + getQuantidadeDeItens() + "\n");
        System.out.print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        System.out.print("NOME\t\t\t\t\t\t\t\t\t\tQUANTIDADE\t\t\t\t\t\t\t\t\tDATA DE REGISTRO\t\t\t\t┃\n");
        System.out.print("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        for(int i = 0; i < this.quantidadeDeItens; i++){
            System.out.print(this.getListaDeItens().get(i).getIdentificador());
            funcoes.formatarTabela(this.getListaDeItens().get(i).getIdentificador());
            System.out.print(this.getListaDeItens().get(i).getQuantidade());
            funcoes.formatarTabela(Integer.toString(this.listaDeItens.get(i).getQuantidade()));
            System.out.print(this.getListaDeItens().get(i).getDataDeRegistro());
            System.out.print("\n");
        }
        System.out.print("\n");
        int y = (getListaDeItens().size() - getListaDeItensTemporarios().size());
        if(adicionou) {
            for (int x = getListaDeItens().size() - 1; x >= y; x--) {
                getListaDeItens().remove(x);
            }
        }
    }

    public void eraseEstoque() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("\nVocê tem certeza que deseja DELETAR todos os itens existentes?\nDigite SIM para confirmar a ação: ");
        String avaliarConfirmacao = teclado.nextLine();

        if (avaliarConfirmacao.equalsIgnoreCase("sim")) {

            ArrayList<Item> novaListaItens = new ArrayList<>();
            setListaDeItens(novaListaItens);
            setQuantidadeDeItens(0);
            System.out.printf("Os itens no estoque %s foram apagados.\n\n", getNomeDoEstoque());

        } else {

            System.out.print("\nVocê não digitou o código correto para a confirmação, então os itens não foram deletados.\n\n");

        }

    }

    public void showItens() {

        System.out.printf("\nItens criados no estoque %s:\n\n", this.getNomeDoEstoque());

        boolean adicionou = false;
        if(getListaDeItens().size() < getQuantidadeDeItens()) {
            for (int x = 0; x < getListaDeItensTemporarios().size(); x++) {
                getListaDeItens().add(getListaDeItensTemporarios().get(x));
            }
            adicionou = true;
        }

        for (int i = 0; i < this.listaDeItens.size(); i++) {
            System.out.printf("%d - %s \n", i + 1, this.listaDeItens.get(i).getIdentificador());
        }

        int y = (getListaDeItens().size() - getListaDeItensTemporarios().size());
        if(adicionou) {
            for (int x = getListaDeItens().size() - 1; x >= y; x--) {
                getListaDeItens().remove(x);
            }
        }

    }

}