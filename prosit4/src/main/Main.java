package main;
import entites.Animal;
import entites.Zoo;

public class Main {
    public static void main(String[] args) {

        Animal lion = new Animal("Félidé", "Lion", 5, true);
        Animal tigre = new Animal("Félidé", "Tigre", 5, true);
        Animal girafe = new Animal("Giraffidae", "Girafe", 7, false);

        Zoo myZoo = new Zoo("Zoo de Tunis", "Tunis", 20);
        Zoo otherZoo = new Zoo("Zoo de Sousse", "Sousse", 15);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tigre);
        otherZoo.addAnimal(girafe);

        myZoo.displayZoo();
        myZoo.displayAnimals();

        int i = myZoo.searchAnimal("Tigre");
        System.out.println("Indice du Tigre trouvé : " + i);

        System.out.println(myZoo);
        System.out.println(lion);

        System.out.println("\nSuppression du Tigre...");
        boolean removed = myZoo.removeAnimal("Tigre");
        System.out.println("Suppression réussie ? " + removed);
        myZoo.displayAnimals();

        Zoo plusGrand = Zoo.comparerZoo(myZoo, otherZoo);
        if (plusGrand != null) {
            System.out.println("\nLe zoo avec le plus d'animaux est : " + plusGrand.getName());
        }


    }
}