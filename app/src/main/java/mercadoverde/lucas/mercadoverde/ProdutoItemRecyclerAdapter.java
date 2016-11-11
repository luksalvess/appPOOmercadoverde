package mercadoverde.lucas.mercadoverde;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ProdutoItemRecyclerAdapter extends RecyclerView.Adapter<ProdutoItemViewHolder> {

    private List<ProdutoCliente> mLista;
    private Context mContext;
    public ProdutoItemRecyclerAdapter(Context context, List<ProdutoCliente> lista){
        mLista = lista;
        mContext = context;
    }
    @Override
    public ProdutoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent,false);

        return new ProdutoItemViewHolder(layoutView);

    }

    @Override
    public void onBindViewHolder(ProdutoItemViewHolder holder, int position) {
        ProdutoCliente item = mLista.get(position);
        holder.nomeProduto.setText(item.getNome());
        holder.precoProduto.setText(Float.toString(item.getprecoProduto()) );
        holder.dataProduto.setText(""+item.getdataProduto());
        Picasso.with(mContext).load(item.geturlDaFotoDoProduto()).into(holder.imageProduto);

    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }
    public ProdutoCliente getItem(int position){
        return mLista.get(position);
    }

    public void clear(){
        mLista.clear();
    }

    public void addAll(List<ProdutoCliente> lista){
        mLista.addAll(lista);
    }


}
