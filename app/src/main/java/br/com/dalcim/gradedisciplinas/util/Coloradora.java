package br.com.dalcim.gradedisciplinas.util;

import java.util.ArrayList;
import java.util.List;

import br.com.dalcim.gradedisciplinas.R;
import br.com.dalcim.gradedisciplinas.model.Horario;

/**
 * Created by Wiliam on 18/11/2016.
 */
public abstract class Coloradora {
    public static List<Integer> getColors(long horarios) {
        ArrayList<Integer> retorno = new ArrayList<>(2);
        if((horarios & Horario.SEGUNDA_PRIMEIRO) != 0) retorno.add(R.drawable.bg_tg_seg_1);
        if((horarios & Horario.SEGUNDA_SEGUNDO) != 0) retorno.add(R.drawable.bg_tg_seg_2);
        if((horarios & Horario.TERCA_PRIMEIRO) != 0) retorno.add(R.drawable.bg_tg_ter_1);
        if((horarios & Horario.TERCA_SEGUNDO) != 0) retorno.add(R.drawable.bg_tg_ter_2);
        if((horarios & Horario.QUARTA_PRIMEIRO) != 0) retorno.add(R.drawable.bg_tg_qua_1);
        if((horarios & Horario.QUARTA_SEGUNDO) != 0) retorno.add(R.drawable.bg_tg_qua_2);
        if((horarios & Horario.QUINTA_PRIMEIRO) != 0) retorno.add(R.drawable.bg_tg_qui_1);
        if((horarios & Horario.QUINTA_SEGUNDO) != 0) retorno.add(R.drawable.bg_tg_qui_2);
        if((horarios & Horario.SEXTA_PRIMEIRO) != 0) retorno.add(R.drawable.bg_tg_sex_1);
        if((horarios & Horario.SEXTA_SEGUNDO) != 0) retorno.add(R.drawable.bg_tg_sex_2);

        return retorno;
    }

}
