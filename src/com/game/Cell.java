package com.game;

public class Cell {
    private Integer value;
    private int rowIndex,columnIndex;

    public Cell( int rowIndex, int columnIndex) {

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public String getValueForPrint(){
        if (value==null) {
            return " |";
        } else {
            return value+"|";
        }

    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}
