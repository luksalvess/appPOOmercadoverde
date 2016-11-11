package mercadoverde.lucas.mercadoverde;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class EstadoItemRecyclerAdapter extends RecyclerView.Adapter<EstadoItemViewHolder> {



    private List<EstadoItems> sLista;
    private Context sContext;

    public EstadoItemRecyclerAdapter(Context context, List<EstadoItems> lista){
        sLista = lista;
        sContext = context;
    }

    @Override
    public EstadoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.estado_filtro, parent,false);
        return new EstadoItemViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(EstadoItemViewHolder holder, int position) {
        EstadoItems item = sLista.get(position);
        holder.textNomeDoEstado.setText(item.getnomeEstado());

    }

    @Override
    public int getItemCount() {
        return sLista.size();
    }
    public EstadoItems getItem(int position){
        return sLista.get(position);
    }
}
