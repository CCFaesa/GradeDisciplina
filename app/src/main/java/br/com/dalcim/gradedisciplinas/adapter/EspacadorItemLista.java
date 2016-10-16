package br.com.dalcim.gradedisciplinas.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Wiliam on 16/10/2016.
 */

public class EspacadorItemLista extends RecyclerView.ItemDecoration {
    private int espacamento;

    public EspacadorItemLista(Context context, @DimenRes int dimenSize) {
        this.espacamento = context.getResources().getDimensionPixelSize(dimenSize);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = espacamento;       // ADD MARGIN BOTTOM EM TODOS OS ITENS

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = espacamento;      // ADD MARGIN TOP SOMENTE NA PRIMEIRA LINHA
        }
    }

}
