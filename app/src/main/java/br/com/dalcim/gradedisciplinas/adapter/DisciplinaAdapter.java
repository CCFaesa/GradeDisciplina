package br.com.dalcim.gradedisciplinas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.model.Disciplina;
import br.com.dalcim.gradedisciplinas.util.Coloradora;

/**
 * Created by Wiliam on 16/10/2016.
 */

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.Holder>{
    private LayoutInflater inflater;
    private List<Disciplina> disciplinas;
    private Listeners listeners;

    public DisciplinaAdapter(Context ctx, List<Disciplina> disciplinas, Listeners listeners) {
        inflater = LayoutInflater.from(ctx);
        this.listeners = listeners;
        this.disciplinas = disciplinas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_disciplina, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Disciplina disciplina = disciplinas.get(position);

        holder.txtDisciplina.setText(disciplina.getNome());
        holder.txtCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));

        List<Integer> cores = Coloradora.getColors(disciplina.getHorarios());
        holder.viewCor1.setBackgroundResource(cores.get(0));

        if(cores.size() > 1){
            holder.viewCor2.setVisibility(View.VISIBLE);
            holder.viewCor2.setBackgroundResource(cores.get(1));
        }else{
            holder.viewCor2.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listeners.onClick(disciplina.getId());
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listeners.onLongClick(disciplina.getId());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return disciplinas.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView txtDisciplina;
        TextView txtCargaHoraria;
        View viewCor1;
        View viewCor2;

        public Holder(View itemView) {
            super(itemView);

            txtDisciplina = (TextView) itemView.findViewById(R.id.idis_txt_disciplina);
            txtCargaHoraria = (TextView) itemView.findViewById(R.id.idis_txt_carga_horaria);
            viewCor1 = itemView.findViewById(R.id.idis_view_color1);
            viewCor2 = itemView.findViewById(R.id.idis_view_color2);
        }
    }

    public interface Listeners{
        void onClick(long id);
        void onLongClick(long id);
    }
}
