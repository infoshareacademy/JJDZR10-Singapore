package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.Type;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @Mock
    private PlaceRepository placeRepositoryMock;
    @InjectMocks
    private PlaceService placeService;
    private final City gdansk = new City(1L, "Gdańsk" );
    private final Place parkOliwski = new Place(1L, "Park Oliwski", gdansk, Type.NATURE);
    private final Place katedraOliwska = new Place(2L, "Katedra Oliwski", gdansk, Type.MONUMENT);
    private final Place mandu = new Place(3L, "Pierogarnia Mandu", gdansk, Type.RESTAURANT);


    @Test
    void shouldCreatePlace() {
        //given
        Place place = new Place();
        when(placeRepositoryMock.save(place)).thenReturn(place);
        //when
        Place savedPlace = placeService.createPlace(place);
        //then
        verify(placeRepositoryMock, times(1)).save(place);
        assertEquals(place, savedPlace);
    }

    @Test
    void shouldFindPlaces() {
        //given
        when(placeRepositoryMock.findAll()).thenReturn(Arrays.asList(parkOliwski, katedraOliwska, mandu));
        //when
        List<Place> resultPlaceList = placeService.findPlaces();
        //then
        assertThat(resultPlaceList).hasSize(3);
    }
    @Test
    void shouldFindPlaceById(){
        //given
        when(placeRepositoryMock.findById(anyLong())).thenReturn(Optional.of(katedraOliwska));
        //when
        Place myPlace = placeService.findById(2L);
        //then
        assertEquals(myPlace.getId(),2);
    }
    @Test
    void shouldFindListByTypeOfPlace(){
        //given
        when(placeRepositoryMock.findAll()).thenReturn(Arrays.asList(parkOliwski, katedraOliwska, mandu));
        //when
        List<Place> resultPlaceList = placeService.filterListByTypeOfPlace(Type.MONUMENT.getPlaceType());
        //then
        assertThat(resultPlaceList).hasSize(1);
    }
    @Test
    void shouldFindPlacesByCityId(){
        //given
        when(placeRepositoryMock.findAll()).thenReturn(Arrays.asList(parkOliwski, katedraOliwska, mandu));
        //when
        List<Place> resultPlaceList = placeService.findPlacesByCityId(1L);
        //then
        assertThat(resultPlaceList).hasSize(3);
    }


}