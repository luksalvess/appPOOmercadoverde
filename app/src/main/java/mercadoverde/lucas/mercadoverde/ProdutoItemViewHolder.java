package mercadoverde.lucas.mercadoverde;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ProdutoItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageProduto;
    public TextView nomeProduto;
    public TextView precoProduto;
    public TextView dataProduto;



    public ProdutoItemViewHolder(View itemView) {
        super(itemView);
        imageProduto = (ImageView) itemView.findViewById(R.id.image_produto);
        nomeProduto = (TextView)   itemView.findViewById(R.id.nome_produto);
        precoProduto = (TextView)  itemView.findViewById(R.id.preco_produto);
        dataProduto = (TextView)  itemView.findViewById(R.id.data_produto);

    }
}
