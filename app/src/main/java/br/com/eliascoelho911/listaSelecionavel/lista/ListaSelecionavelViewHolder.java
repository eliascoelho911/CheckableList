package br.com.eliascoelho911.listaSelecionavel.lista;

import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class ListaSelecionavelViewHolder extends RecyclerView.ViewHolder {

    public ListaSelecionavelViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract CompoundButton getCompoundButton();
}
