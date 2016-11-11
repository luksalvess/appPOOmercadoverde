
package mercadoverde.lucas.mercadoverde;



public class ProdutoCliente {
    private String nome;
    private float precoProduto;
    private String urlDaFotoDoProduto;
    private int dt_anuncio;


    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }


    public void setpreco(float preco) {
        this.precoProduto = preco;
    }

    public void setdt_anuncio(int dt_anuncio) {
        this.dt_anuncio = dt_anuncio;
    }


    public void seturlDaFotoDoProduto(String urlDaFotoDoProduto) {
        this.urlDaFotoDoProduto = urlDaFotoDoProduto;

    }

    public String getNome() {
        return nome;
    }

    public float getprecoProduto() {
        return precoProduto;
    }

    public int getdataProduto() {
        return dt_anuncio;
    }

    public String geturlDaFotoDoProduto() {
        return urlDaFotoDoProduto;
    }

}

