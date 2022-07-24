package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Field {
    private List<Cell> cellList;
    private Integer score;

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
        score = 0;
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
        score = getScore();
        List<Cell> emptyCells = getEmptyCells();
        Random random=new Random();
        if(!emptyCells.isEmpty()) {
            emptyCells.get(random.nextInt(emptyCells.size())).setValue(
                    random.nextInt(10)==7? 4:2
            );
        }
    }

    private Integer getScore () {
        return cellList.stream()
                .filter(cell -> cell.getValue() != null)
                .map(cell -> cell.getValue()
                ).reduce(0, (a, b) -> a + b);
    }

    public boolean isGameOver(){
        Integer currentScore = getScore();

        if(currentScore.equals(score)) {
            System.out.println("You're loser");
            return true;
        }

        if(cellList.stream().filter(cell -> cell.getValue() != null)
                .anyMatch(cell -> cell.getValue() == 2048)) {
            System.out.println("You're winner");
            return true;
        }
        return false;
    }

    private List<Cell> getEmptyCells(){
        return  cellList.stream().filter(cell -> cell.getValue() == null).collect(Collectors.toList());
    }

    public void handleAction(char c) {
        if(c=='w') {
            for (int j = 1; j <5 ; j++) {
              Cell cell1= find(1,j);
              Cell cell2= find(2,j);
              Cell cell3= find(3,j);
              Cell cell4= find(4,j);

              if (cell1.getValue()!=null && cell1.getValue().equals(cell2.getValue())){
                  cell1.setValue(2*cell1.getValue());
                  cell2.setValue(null);
              }
                if (cell2.getValue()!=null&&cell2.getValue().equals(cell3.getValue())){
                    cell2.setValue(2*cell2.getValue());
                    cell3.setValue(null);
                }
                if (cell3.getValue()!=null&&cell3.getValue().equals(cell4.getValue())){
                    cell3.setValue(2*cell3.getValue());
                    cell4.setValue(null);
                }
                List<Integer> values= new ArrayList<>();
                values.add(cell1.getValue());
                values.add(cell2.getValue());
                values.add(cell3.getValue());
                values.add(cell4.getValue());

                List<Integer> notNulls = values.stream().filter(v -> v != null).collect(Collectors.toList());
                List<Integer> nulls = values.stream().filter(v -> v == null).collect(Collectors.toList());

                List<Integer> result = new ArrayList<>();
                result.addAll(notNulls);
                result.addAll(nulls);

                cell1.setValue(result.get(0));
                cell2.setValue(result.get(1));
                cell3.setValue(result.get(2));
                cell4.setValue(result.get(3));
            }
        }

        if(c=='a') {
            for (int i = 1; i <5 ; i++) {
                Cell cell1= find(i,1);
                Cell cell2= find(i,2);
                Cell cell3= find(i,3);
                Cell cell4= find(i,4);

                if (cell1.getValue()!=null && cell1.getValue().equals(cell2.getValue())){
                    cell1.setValue(2*cell1.getValue());
                    cell2.setValue(null);
                }
                if (cell2.getValue()!=null&&cell2.getValue().equals(cell3.getValue())){
                    cell2.setValue(2*cell2.getValue());
                    cell3.setValue(null);
                }
                if (cell3.getValue()!=null&&cell3.getValue().equals(cell4.getValue())){
                    cell3.setValue(2*cell3.getValue());
                    cell4.setValue(null);
                }
                List<Integer> values= new ArrayList<>();
                values.add(cell1.getValue());
                values.add(cell2.getValue());
                values.add(cell3.getValue());
                values.add(cell4.getValue());

                List<Integer> notNulls = values.stream().filter(v -> v != null).collect(Collectors.toList());
                List<Integer> nulls = values.stream().filter(v -> v == null).collect(Collectors.toList());

                List<Integer> result = new ArrayList<>();
                result.addAll(notNulls);
                result.addAll(nulls);

                cell1.setValue(result.get(0));
                cell2.setValue(result.get(1));
                cell3.setValue(result.get(2));
                cell4.setValue(result.get(3));
            }
        }

        if(c=='s') {
            for (int j = 1; j <5 ; j++) {
                Cell cell1= find(4,j);
                Cell cell2= find(3,j);
                Cell cell3= find(2,j);
                Cell cell4= find(1,j);

                if (cell1.getValue()!=null && cell1.getValue().equals(cell2.getValue())){
                    cell1.setValue(2*cell1.getValue());
                    cell2.setValue(null);
                }
                if (cell2.getValue()!=null&&cell2.getValue().equals(cell3.getValue())){
                    cell2.setValue(2*cell2.getValue());
                    cell3.setValue(null);
                }
                if (cell3.getValue()!=null&&cell3.getValue().equals(cell4.getValue())){
                    cell3.setValue(2*cell3.getValue());
                    cell4.setValue(null);
                }
                List<Integer> values= new ArrayList<>();
                values.add(cell1.getValue());
                values.add(cell2.getValue());
                values.add(cell3.getValue());
                values.add(cell4.getValue());

                List<Integer> notNulls = values.stream().filter(v -> v != null).collect(Collectors.toList());
                List<Integer> nulls = values.stream().filter(v -> v == null).collect(Collectors.toList());

                List<Integer> result = new ArrayList<>();
                result.addAll(notNulls);
                result.addAll(nulls);

                cell1.setValue(result.get(0));
                cell2.setValue(result.get(1));
                cell3.setValue(result.get(2));
                cell4.setValue(result.get(3));
            }
        }

        if(c=='d') {
            for (int i = 1; i <5 ; i++) {
                Cell cell1= find(i,4);
                Cell cell2= find(i,3);
                Cell cell3= find(i,2);
                Cell cell4= find(i,1);

                if (cell1.getValue()!=null && cell1.getValue().equals(cell2.getValue())){
                    cell1.setValue(2*cell1.getValue());
                    cell2.setValue(null);
                }
                if (cell2.getValue()!=null&&cell2.getValue().equals(cell3.getValue())){
                    cell2.setValue(2*cell2.getValue());
                    cell3.setValue(null);
                }
                if (cell3.getValue()!=null&&cell3.getValue().equals(cell4.getValue())){
                    cell3.setValue(2*cell3.getValue());
                    cell4.setValue(null);
                }
                List<Integer> values= new ArrayList<>();
                values.add(cell1.getValue());
                values.add(cell2.getValue());
                values.add(cell3.getValue());
                values.add(cell4.getValue());

                List<Integer> notNulls = values.stream().filter(v -> v != null).collect(Collectors.toList());
                List<Integer> nulls = values.stream().filter(v -> v == null).collect(Collectors.toList());

                List<Integer> result = new ArrayList<>();
                result.addAll(notNulls);
                result.addAll(nulls);

                cell1.setValue(result.get(0));
                cell2.setValue(result.get(1));
                cell3.setValue(result.get(2));
                cell4.setValue(result.get(3));
            }
        }
    }
}
