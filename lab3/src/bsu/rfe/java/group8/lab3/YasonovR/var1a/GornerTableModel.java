package bsu.rfe.java.group8.lab3.YasonovR.var1a;

import javax.swing.table.AbstractTableModel;
import java.lang.Math;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return (int) (Math.ceil((to - from) / step)) + 1;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        double result = x;
        double temp = result;
        if (col == 0) {
// Если запрашивается значение 1-го столбца, то это X
            return x;
        } else if (col == 1) {
            int i = 0;
            result = result*x;
                result = result + x*coefficients[i++];

                return result;
            }
        else {
                return temp > 0;
        }

    }





    public String getColumnName(int col) {
        switch (col) {
            case 0: return "Значение х";
            case 1: return "Значение многочлена";
            case 2: return "Значение больше нуля?";
        }
        return "";
    }
    public Class<?> getColumnClass(int col) {
        if (col != 2)
            return Double.class;
        else {
            return Boolean.class;
        }
    }
}
