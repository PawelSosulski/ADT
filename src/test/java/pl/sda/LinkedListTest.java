package pl.sda;

import org.junit.Test;
import pl.sda.List.IList;
import pl.sda.List.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    private final IList<Long> list = new LinkedList<>();

    @Test
    public void emptyTableShouldHaveSize_0() {
        //when
        long size = list.size();

        //then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void tableWithOneElementShouldHaveSize1() {
        //when
        list.add(0, 5L);
        long size = list.size();

        //then
        assertThat(size).isEqualTo(1);
    }

    @Test
    public void shouldInsertValuesCorrectly() {
        //when
        list.add(0, 1L);
        list.add(0, 2L);
        list.add(0, 3L);

        //then
        assertThat(list.getHolderView()).containsExactly(3L, 2L, 1L);

    }

    @Test
    public void shouldInsertValuesCorrectly2() {
        //when
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.getHolderView()).containsExactly(3L, 4L, 5L, 2L, 1L);

    }

    @Test
    public void shouldInsertCorrectlyAtTheEnd() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        list.add(5, 6L);

        //then
        assertThat(list.getHolderView()).containsExactly(3L, 4L, 5L, 2L, 1L, 6L);

    }

    @Test
    public void shouldReturnMinusOneAsIndexWhenValueIsNotPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = list.firstIndexWith(7L);

        //then
        assertThat(index_with_value_7).isEqualTo(-1);
    }

    @Test
    public void shouldReturnCorrectIndexWhenValueIsPresent() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //when
        long index_with_value_7 = list.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnFirstIndexWhenValueIsRepeated() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.add(2, 5L);
        list.add(5, 5L);

        //when
        long index_with_value_7 = list.firstIndexWith(5L);

        //then
        assertThat(index_with_value_7).isEqualTo(2);
    }

    @Test
    public void shouldReturnTrueIfListIsEmpty() {
        assertThat(list.isEmpty()).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalseIfListIsNotEmpty() {
        list.add(6L);
        assertThat(list.isEmpty()).isEqualTo(false);
    }

    @Test
    public void shoulgGetValueProperly() {
        //given
        initializeHolderWith_3_4_5_2_1();

        //then
        assertThat(list.get(2)).isEqualTo(5L);
    }

    @Test
    public void shouldSetValueProperly() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.set(2, 9L);

        //then
        list.getHolderView();
        assertThat(list.getHolderView()[2]).isEqualTo(9L);
    }

    @Test
    public void shouldDecrementSizeWhenRemove() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.remove(2);

        //then
        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void shouldRemoveValuePropoerly() {
        //given
        initializeHolderWith_3_4_5_2_1();
        list.remove(2);

        //then
        assertThat(list.firstIndexWith(5L)).isEqualTo(-1);
    }

    private void initializeHolderWith_3_4_5_2_1() {
        list.add(0, 1L);
        list.add(0, 2L);
        list.add(0, 3L);
        list.add(1, 4L);
        list.add(2, 5L);
    }
}