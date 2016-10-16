package br.com.dalcim.gradedisciplinas.model;

/**
 * Created by Wiliam on 16/10/2016.
 */

public abstract class Horario {
    public static final long SEGUNDA_PRIMEIRO =     1 << 0;     //  1       0000000001
    public static final long SEGUNDA_SEGUNDO =      1 << 1;     //  2       0000000010
    public static final long TERCA_PRIMEIRO =       1 << 2;     //  4       0000000100
    public static final long TERCA_SEGUNDO =        1 << 3;     //  8       0000001000
    public static final long QUARTA_PRIMEIRO =      1 << 4;     //  16      0000010000
    public static final long QUARTA_SEGUNDO =       1 << 5;     //  32      0000100000
    public static final long QUINTA_PRIMEIRO =      1 << 6;     //  64      0001000000
    public static final long QUINTA_SEGUNDO =       1 << 7;     //  128     0010000000
    public static final long SEXTA_PRIMEIRO =       1 << 8;     //  256     0100000000
    public static final long SEXTA_SEGUNDO =        1 << 9;     //  512     1000000000
}
