package pl.sda.SelectionSort;

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


        Object[] table = tableToSort.getHolderView();
        System.out.println("Tablica nie posortowana");
        for (Object elem : table){
            System.out.println(elem);
        }

        SelectionSort sort = new SelectionSort();
        ArrayList2x<Integer> tableSort = (ArrayList2x<Integer>)sort.sortBySelection(tableToSort);

        table = tableSort.getHolderView();
        System.out.println("Tablica posortowana");
        for (Object elem : table){
            System.out.println(elem);
        }

    }
}
