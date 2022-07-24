package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Field {
    private List<Cell> cellList;

    public Field() {
        cellList=new ArrayList<>();
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <5 ; j++) {
                cellList.add(new Cell(i,j));
            }
        }
        Random random=new Random();
        cellList.get(random.nextInt(15)).setValue(2);
        cellList.get(random.nextInt(15)).setValue(2);
    }
    public void printField(){
        for (int i = 1; i <5 ; i++) {

            for (int j = 1; j <5 ; j++) {
                Cell cell = find(i,j);
                System.out.printf("%5s",cell.getValueForPrint());
            }
            System.out.println();
        }
    }
    private Cell find(int i,int j){
        for (Cell cell:cellList) {
            if ((i==cell.getRowIndex()) &&(j==cell.getColumnIndex())){
                return cell;
            }
        }
        throw new IllegalArgumentException();
    }
    public void addCellValue(){
        List<Cell> emptyCells = cellList.stream().filter(cell -> cell.getValue() == null).collect(Collectors.toList());
        Random random=new Random();
        emptyCells.get(random.nextInt(emptyCells.size())).setValue(
              random.nextInt(10)==7? 4:2
        );
    }
}
