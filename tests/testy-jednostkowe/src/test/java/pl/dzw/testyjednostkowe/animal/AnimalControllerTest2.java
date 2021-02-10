package pl.dzw.testyjednostkowe.animal;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
@ExtendWith(MockitoExtension.class)
class AnimalControllerTest2 {

    @Mock
    private AnimalRepo animalRepo;

    @InjectMocks
    private AnimalController animalController;

    @Test
    public void should_get_animals() {
        //given
        BDDMockito.given(animalRepo.findAll()).willReturn(properData());
        //when
        List<Animal> animals = animalController.getAnimals();
        //then
        Assertions.assertEquals(properData().size(),animals.size());
    }

    private List<Animal> properData() {
        return Lists.list(new Animal("Tygrys"), new Animal("Kangur"));
    }

}
