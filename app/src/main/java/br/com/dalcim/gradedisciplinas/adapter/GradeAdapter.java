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
import br.com.dalcim.gradedisciplinas.model.Grade;
import br.com.dalcim.gradedisciplinas.model.Horario;

/**
 * Created by Wiliam on 16/10/2016.
 */

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.Holder> {

    private LayoutInflater inflater;
    private List<Grade> grades;

    public GradeAdapter(Context context, List<Grade> grades) {
        inflater = LayoutInflater.from(context);
        this.grades = grades;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_grade, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Grade grade = grades.get(position);

        holder.txtSeg1.setText("");
        holder.txtSeg2.setText("");
        holder.txtTer1.setText("");
        holder.txtTer2.setText("");
        holder.txtQua1.setText("");
        holder.txtQua2.setText("");
        holder.txtQui1.setText("");
        holder.txtQui2.setText("");
        holder.txtSex1.setText("");
        holder.txtSex2.setText("");

        for (Disciplina disciplina : grade.getDisciplinas()) {
            if((disciplina.getHorarios() & Horario.SEGUNDA_PRIMEIRO) != 0)
                holder.txtSeg1.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.SEGUNDA_SEGUNDO) != 0)
                holder.txtSeg2.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.TERCA_PRIMEIRO) != 0)
                holder.txtTer1.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.TERCA_SEGUNDO) != 0)
                holder.txtTer2.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.QUARTA_PRIMEIRO) != 0)
                holder.txtQua1.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.QUARTA_SEGUNDO) != 0)
                holder.txtQua2.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.QUINTA_PRIMEIRO) != 0)
                holder.txtQui1.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.QUINTA_SEGUNDO) != 0)
                holder.txtQui2.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.SEXTA_PRIMEIRO) != 0)
                holder.txtSex1.setText(disciplina.getNome());

            if((disciplina.getHorarios() & Horario.SEXTA_SEGUNDO) != 0)
                holder.txtSex2.setText(disciplina.getNome());
        }
    }

    @Override
    public int getItemCount() {
        return grades.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView txtSeg1;
        TextView txtSeg2;
        TextView txtTer1;
        TextView txtTer2;
        TextView txtQua1;
        TextView txtQua2;
        TextView txtQui1;
        TextView txtQui2;
        TextView txtSex1;
        TextView txtSex2;

        public Holder(View itemView) {
            super(itemView);

            txtSeg1 = (TextView) itemView.findViewById(R.id.igra_txt_seg1);
            txtSeg2 = (TextView) itemView.findViewById(R.id.igra_txt_seg2);
            txtTer1 = (TextView) itemView.findViewById(R.id.igra_txt_ter1);
            txtTer2 = (TextView) itemView.findViewById(R.id.igra_txt_ter2);
            txtQua1 = (TextView) itemView.findViewById(R.id.igra_txt_qua1);
            txtQua2 = (TextView) itemView.findViewById(R.id.igra_txt_qua2);
            txtQui1 = (TextView) itemView.findViewById(R.id.igra_txt_qui1);
            txtQui2 = (TextView) itemView.findViewById(R.id.igra_txt_qui2);
            txtSex1 = (TextView) itemView.findViewById(R.id.igra_txt_sex1);
            txtSex2 = (TextView) itemView.findViewById(R.id.igra_txt_sex2);
        }
    }
}