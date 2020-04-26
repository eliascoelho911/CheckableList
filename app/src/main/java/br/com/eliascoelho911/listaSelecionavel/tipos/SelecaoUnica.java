package br.com.eliascoelho911.listaSelecionavel.tipos;

import java.util.List;

public class SelecaoUnica extends ListaSelecionavel {
    @Override
    public void botaoDaListaFoiClicado(int posicaoDoAdapterQueFoiModificado,
                                       List<Integer> posicoesDoAdapterSelecionadas) {
        for (Integer posicaoDoAdapterSelecionada : posicoesDoAdapterSelecionadas) {
            if (posicaoDoAdapterSelecionada != posicaoDoAdapterQueFoiModificado)
                super.getCompoundButton(posicaoDoAdapterSelecionada).setChecked(false);
        }
    }
}
