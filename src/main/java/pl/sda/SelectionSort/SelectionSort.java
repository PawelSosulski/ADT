package pl.sda.SelectionSort;


import pl.sda.List.ArrayList2x;

import java.util.Arrays;

public class SelectionSort {

    public ArrayList2x<Integer> sortBySelection(ArrayList2x<Integer> table) {
        for (int j = 0; j < table.size() - 1; j++) {
            int minIndex = j;
            for (int i = j; i < table.size() - 1; i++) {
                if (table.get(i+1) < table.get(minIndex)) {
                    minIndex = i+1;
                }
            }
            Integer tmpValue = table.get(j);
            table.set(j,table.get(minIndex));
            table.set(minIndex,tmpValue);

        }

return table;
    }
}
