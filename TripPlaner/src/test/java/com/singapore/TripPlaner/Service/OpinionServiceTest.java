package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Repository.OpinionRepository;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OpinionServiceTest {
    @Mock
    private OpinionRepository opinionRepositoryMock;
    @InjectMocks
    private OpinionService opinionService;
    @Mock
    private PlaceRepository placeRepositoryMock;

    User user = new User();
    private final Opinion opinionRate5 = new Opinion(1L,
            "Superb",
            5,
            user,
            new Place()
    );
    private final Opinion opinionRate1 = new Opinion(1L,
            "Boring",
            1,
            user,
            new Place()
    );
    private final Opinion newOpinion = new Opinion(
            3L,
            "Just fine",
            6,
            user,
            new Place()
    );
    List<Opinion> opinions = Arrays.asList(opinionRate1, opinionRate5);
    private final Place place =
            new Place(1L,
                    "Bazylika Mariacka",
                    "Description",
                    10,
                    3.0,
                    List.of(new Image(), new Image()),
                    new City(),
                    opinions,
                    Type.MONUMENT
            );
    Place newPlace = new Place(1L,
            "Bazylika Mariacka",
            "Description",
            10,
            3.0,
            List.of(),
            new City(),
            opinions,
            Type.MONUMENT
    );


    @Test
    void shouldGetAllOpinions() {
        when(opinionRepositoryMock.findAll()).thenReturn(opinions);

        List<Opinion> result = opinionService.getAllOpinions();

        assertThat(result).hasSize(2)
                .contains(opinionRate1, opinionRate5);
    }

    @Test
    void shouldFindOpinionWithGivenId() {
        when(opinionRepositoryMock.findById(anyLong())).thenReturn(Optional.of(opinionRate1));

        Opinion opinionById = opinionService.findById(1L);

        assertThat(opinionById).isEqualTo(opinionRate1);
    }

    @Test
    void shouldNotFindAnyOpinionWithWrongIdAndThrownException() {
        doThrow(new OpinionNotFoundException("Opinion with id '3' does not exist")).when(opinionRepositoryMock).findById(eq(3L));

        assertThatThrownBy(() -> opinionService.findById(3L))
                .isInstanceOf(OpinionNotFoundException.class)
                .hasMessage("Opinion with id '3' does not exist");
    }

    @Test
    void editPlaceOpinionById() {
    }

    @Test
    void removePlaceOpinionById() {
    }

    @Test
    void addOpinionShouldChangePlaceRate() {
        when(opinionRepositoryMock.findAllOpinionByPlace(newPlace))
                .thenReturn(newPlace.getOpinions());

        opinionService.addOpinionToPlace(newOpinion, newPlace, user);

        assertThat(newPlace.getRate()).isEqualTo(4.0);
    }

    @Test
    void shouldAddOpinionToPlaceSetPlaceOpinionsList() {
        opinionService.addOpinionToPlace(newOpinion, place, user);

        assertThat(place.getOpinions().size()).isEqualTo(3);
        assertThat(place.getOpinions())
                .contains(opinionRate1, opinionRate5, newOpinion);
    }

    @Test
    void shouldAddOpinionToPlaceSavePlace() {
        Place newPlace = new Place();
        when(placeRepositoryMock.save(newPlace)).thenReturn(newPlace);

        opinionService.addOpinionToPlace(newOpinion, newPlace, user);

        verify(placeRepositoryMock, times(1)).save(newPlace);
    }

    @Test
    void addOpinionShouldSaveOpinion() {
        when(opinionRepositoryMock.save(newOpinion)).thenReturn(newOpinion);

        opinionService.addOpinionToPlace(newOpinion, place, user);

        verify(opinionRepositoryMock, times(1)).save(newOpinion);
    }

    @Test
    void addOpinionShouldUpdatePlace() {
        opinionService.addOpinionToPlace(newOpinion, newPlace, user);

        assertThat(newPlace.getOpinions()).contains(newOpinion);
    }

}