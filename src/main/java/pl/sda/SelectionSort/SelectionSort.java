package pl.sda.SelectionSort;


import pl.sda.List.ArrayList;
import pl.sda.List.ArrayList2x;
import pl.sda.List.IList;

import java.util.Arrays;
import java.util.Objects;

public class SelectionSort <T> {

    public IList<Integer> sortBySelection(IList<Integer> table) {
                    for (int j = 0; j < table.size() - 1; j++) {
                int minIndex = j;
                for (int i = j; i < table.size() - 1; i++) {
                    if (table.get(i + 1) < table.get(minIndex)) {
                        minIndex = i + 1;
                    }
                }
                Integer tmpValue =table.get(j);
                table.set(j, table.get(minIndex));
                table.set(minIndex, tmpValue);

            }
return table;
    }
}
