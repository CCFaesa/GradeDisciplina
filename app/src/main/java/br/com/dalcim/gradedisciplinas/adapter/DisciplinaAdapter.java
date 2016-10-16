package br.com.dalcim.gradedisciplinas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.model.Disciplina;

/**
 * Created by Wiliam on 16/10/2016.
 */

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.Holder>{
    private LayoutInflater inflater;
    private List<Disciplina> disciplinas;

    public DisciplinaAdapter(Context ctx, List<Disciplina> disciplinas) {
        inflater = LayoutInflater.from(ctx);
        this.disciplinas = disciplinas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_disciplina, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Disciplina disciplina = disciplinas.get(position);

        holder.txtDisciplina.setText(disciplina.getNome());
        holder.txtCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));
        holder.txtHorarios.setText(String.valueOf(disciplina.getHorarios()));
    }

    @Override
    public int getItemCount() {
        return disciplinas.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView txtDisciplina;
        TextView txtCargaHoraria;
        TextView txtHorarios;

        public Holder(View itemView) {
            super(itemView);

            txtDisciplina = (TextView) itemView.findViewById(R.id.idis_txt_disciplina);
            txtCargaHoraria = (TextView) itemView.findViewById(R.id.idis_txt_carga_horaria);
            txtHorarios = (TextView) itemView.findViewById(R.id.idis_txt_horarios);
        }
    }
}
