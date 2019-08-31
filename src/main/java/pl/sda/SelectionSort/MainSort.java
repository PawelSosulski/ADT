package pl.sda.SelectionSort;

import pl.sda.List.ArrayList;
import pl.sda.List.ArrayList2x;

import java.util.Random;

public class MainSort {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList2x<Integer> tableToSort = new ArrayList2x<>();

        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));
        tableToSort.add(random.nextInt(100));


        Object[] table = new Integer[tableToSort.size()];
                table = tableToSort.getHolderView();
        System.out.println("Tablica nie posortowana");
        for (Object elem : table){
            System.out.println((Integer)elem);
        }

        SelectionSort sort = new SelectionSort();
        ArrayList2x<Integer> tableSort = new ArrayList2x<>();

        tableSort = sort.sortBySelection(tableToSort);

        table = tableSort.getHolderView();
        System.out.println("Tablica posortowana");
        for (Object elem : table){
            System.out.println((Integer)elem);
        }

    }
}
