package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomValuesTest {
    private final Opinion opinion1 = new Opinion();
    private final Opinion opinion2 = new Opinion();
    private final List<Opinion> testOpinionList = new ArrayList<>
            (Arrays.asList(opinion1, opinion2));
    private final Place place1 = new Place();
    private final Place place2 = new Place();
    private final List<Place> testPlaceList = new ArrayList<>
            (Arrays.asList(place1, place2));
    RandomValues randomValues = new RandomValues();

    @Test
    void shouldReturnInputListWhenOutputElementsIsBiggerThenListSize() {
        List randomList = randomValues.outputList(4, testOpinionList);
        assertThat(randomList.size()).isEqualTo(2);
    }

    @Test
    void shouldReturnEmptyListWhenOutputElementsIsZero() {
        List randomList = randomValues.outputList(0, testOpinionList);
        assertThat(randomList.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnEmptyListWhenOutputElementsIsLowerThenZero() {
        List randomList = randomValues.outputList(-2, testOpinionList);
        assertThat(randomList.size()).isEqualTo(0);
    }

    @Test
    void shouldReturnRandomObjectFromList() {
        Opinion opinion = randomValues.randomObjectFromList(testOpinionList);

        assertThat(opinion).isIn(testOpinionList);
    }
}