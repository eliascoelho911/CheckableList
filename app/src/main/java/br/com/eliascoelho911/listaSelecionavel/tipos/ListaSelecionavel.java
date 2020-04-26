package br.com.eliascoelho911.listaSelecionavel.tipos;

import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

import br.com.eliascoelho911.listaSelecionavel.lista.ListaSelecionavelViewHolder;

public abstract class ListaSelecionavel {
    private List<ListaSelecionavelViewHolder> viewHolders = new ArrayList<>();

    public final void adicionar(ListaSelecionavelViewHolder holder) {
        if (!viewHolders.contains(holder)) {
            viewHolders.add(holder.getAdapterPosition(), holder);
        }
    }

    public final CompoundButton getCompoundButton(int adapterPosition) {
        for (ListaSelecionavelViewHolder holder : viewHolders) {
            if (holder.getAdapterPosition() == adapterPosition) {
                return holder.getCompoundButton();
            }
        }

        throw new RuntimeException("Não foi encontrado um view holder na posição " + adapterPosition);
    }

    public final List<Integer> getPosicoesSelecionadas() {
        List<Integer> posicoesSelecionadas = new ArrayList<>();
        for (ListaSelecionavelViewHolder holder : viewHolders) {
            CompoundButton compoundButton = holder.getCompoundButton();
            if (compoundButton.isChecked())
                posicoesSelecionadas.add(holder.getAdapterPosition());
        }

        return posicoesSelecionadas;
    }

    public abstract void botaoDaListaFoiClicado(int posicaoDoAdapterQueFoiModificado,
                                                List<Integer> posicoesDoAdapterSelecionadas);
}
