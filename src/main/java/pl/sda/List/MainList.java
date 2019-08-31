package pl.sda.List;

public class MainList {

    public static void main(String[] args) {
        IList<Long> list = new LinkedList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
//        System.out.println(list.size());

        System.out.println(list.get(2));

       Object[]tab= list.getHolderView();

        for (int i = 0; i < tab.length; ++i)
        System.out.print(tab[i] + " ");

  //      System.out.println(list.size());
        System.out.println();
        list.set(1, 10L);

        //long[] tab2 = list.getHolderView();

        //for (long val:tab2)
        //  System.out.print(val + " ");

    }
}
