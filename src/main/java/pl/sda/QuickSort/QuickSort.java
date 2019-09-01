package pl.sda.QuickSort;

import pl.sda.List.IList;

public class QuickSort {


    public IList<Integer> sortByQuickSort(IList<Integer> table, int startIndex, int stopIndex) {
        if (startIndex >= stopIndex) return table;
        int pivot = stopIndex;
        pivot = splitTable(pivot, table, startIndex, stopIndex);
        sortByQuickSort(table,startIndex,pivot-1);
        return sortByQuickSort(table,pivot+1,stopIndex);

    }

    private int splitTable(int pivot, IList<Integer> table, int startIndex, int stopIndex) {
        for (int i = startIndex; i < pivot; i++) {
            if (table.get(i) >= table.get(pivot)) {
                table.add(pivot + 1, table.get(i));
                table.remove(i);
                pivot--;
                i--;
            }
        }
    return pivot;
    }

}
