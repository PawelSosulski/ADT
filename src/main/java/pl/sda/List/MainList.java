package pl.sda.List;

public class MainList {

    public static void main(String[] args) {
        IList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.size());
        long[] tab = list.getHolderView();

        for (long val:tab)
            System.out.print(val + " ");

        System.out.println();
        list.set(1,10);

        long[] tab2 = list.getHolderView();

        for (long val:tab2)
            System.out.print(val + " ");

    }
}
