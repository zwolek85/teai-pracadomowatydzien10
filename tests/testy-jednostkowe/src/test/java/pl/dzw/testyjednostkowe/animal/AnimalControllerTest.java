package pl.dzw.testyjednostkowe.animal;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.List;

import static org.mockito.Mockito.mock;

class AnimalControllerTest {

    @Test
    public void should_get_animals() {
        //given
        AnimalController animalController = mock(AnimalController.class);
        BDDMockito.given(animalController.getAnimals()).willReturn(properData());
        //when
        List<Animal> animals = animalController.getAnimals();
        //then
        Assertions.assertEquals(properData().size(),animals.size());
    }

    private List<Animal> properData() {
        return Lists.list(new Animal("Tygrys"), new Animal("Kangur"));
    }

}
