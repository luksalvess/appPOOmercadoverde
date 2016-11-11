package mercadoverde.lucas.mercadoverde;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class EstadoItemViewHolder extends RecyclerView.ViewHolder {
    public TextView textNomeDoEstado;


    public EstadoItemViewHolder(View itemView) {
        super(itemView);
        textNomeDoEstado = (TextView) itemView.findViewById(R.id.text_estado_nome);


    }
}
