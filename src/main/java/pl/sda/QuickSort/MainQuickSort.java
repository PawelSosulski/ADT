package pl.sda.QuickSort;

import pl.sda.List.ArrayList2x;
import pl.sda.List.IList;
import pl.sda.SelectionSort.SelectionSort;

import java.util.Random;

public class MainQuickSort {

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

        QuickSort sort = new QuickSort();
        ArrayList2x<Integer> tableSort = (ArrayList2x<Integer>)sort.sortByQuickSort(tableToSort,0,tableToSort.size()-1);

        table = tableSort.getHolderView();
        System.out.println("Tablica posortowana");
        for (Object elem : table){
            System.out.println(elem);
        }

    }
    }


