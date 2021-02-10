package pl.dzw.testyjednostkowe.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalController {

    private AnimalRepo animalRepo;

    @Autowired
    public AnimalController(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public List<Animal> getAnimals(){
        List<Animal> result = new ArrayList<>();
        animalRepo.findAll().iterator().forEachRemaining(result::add);
        return result;
    }

    public Animal addAnimal(Animal animal){
        return animalRepo.save(animal);
    }
}
