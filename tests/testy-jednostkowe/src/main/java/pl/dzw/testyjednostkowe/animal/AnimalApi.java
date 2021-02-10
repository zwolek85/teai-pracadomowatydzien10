package pl.dzw.testyjednostkowe.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalApi {

    private AnimalController animalController;

    @Autowired
    public AnimalApi(AnimalController animalController) {
        this.animalController = animalController;
    }

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals() {
        return animalController.getAnimals();
    }

    @PostMapping ("/animals")
    public void postAnimals(@RequestBody Animal animal) {
        animalController.addAnimal(animal);
    }
}
