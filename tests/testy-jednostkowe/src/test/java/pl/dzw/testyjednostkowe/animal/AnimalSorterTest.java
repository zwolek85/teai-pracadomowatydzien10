package pl.dzw.testyjednostkowe.animal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.exceptions.Reporter;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


public class AnimalSorterTest {


    AnimalSorterTest(){
        System.out.println("start");
    }

    @BeforeEach
    public void init(){
        System.out.println("init");
    }


    @Test
    void sortDataFromApi() {
        //given
        AnimalSorter animalSorterSpy = spy(AnimalSorter.class);
        Mockito.doReturn(properData()).when(animalSorterSpy).getDataFromApi();
        String[] sorted = {"Kot", "Koń", "Pies",};
        Assertions.assertArrayEquals(sorted, animalSorterSpy.sortDataFromApi());

    }

    public String[] properData() {
        String[] animals = {"Pies", "Kot", "Koń"};
        return animals;
    }
}
