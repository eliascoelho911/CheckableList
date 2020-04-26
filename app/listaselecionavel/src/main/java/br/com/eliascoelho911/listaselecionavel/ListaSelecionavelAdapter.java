package br.com.eliascoelho911.listaselecionavel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.com.eliascoelho911.listaselecionavel.tipos.ListaSelecionavel;

public abstract class ListaSelecionavelAdapter<T extends ListaSelecionavelViewHolder> extends RecyclerView.Adapter<T> {

    private ListaSelecionavel listaSelecionavel;

    public ListaSelecionavelAdapter(ListaSelecionavel listaSelecionavel) {
        this.listaSelecionavel = listaSelecionavel;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull T holder) {
        super.onViewAttachedToWindow(holder);
        listaSelecionavel.adicionar(holder);
    }
}
