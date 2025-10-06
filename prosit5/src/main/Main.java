package main;

import entites.*;

public class Main {
    public static void main(String[] args) {


        Aquatic fish = new Aquatic();
        Terrestrial cat = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();



        Aquatic shark = new Aquatic("Poisson", "Requin", 12, false, "Océan");
        Terrestrial elephant = new Terrestrial("Mammifère", "Éléphant", 25, true, 4);
        Dolphin flipper = new Dolphin("Mammifère marin", "Flipper", 8, true, "Mer", 35.5f);
        Penguin pingo = new Penguin("Oiseau marin", "Pingo", 3, false, "Bassin", 12.3f);

        System.out.println(shark);
        System.out.println(elephant);
        System.out.println(flipper);
        System.out.println(pingo);



        shark.swim();
        flipper.swim();
        pingo.swim();



        Zoo zooTunis = new Zoo("Zoo de Tunis", "Tunis", 10);
        Zoo zooSousse = new Zoo("Zoo de Sousse", "Sousse", 8);

        zooTunis.addAnimal(shark);
        zooTunis.addAnimal(elephant);
        zooTunis.addAnimal(flipper);

        zooSousse.addAnimal(pingo);

        zooTunis.displayZoo();
        zooTunis.displayAnimals();

        zooSousse.displayZoo();
        zooSousse.displayAnimals();




        int index = zooTunis.searchAnimal("Flipper");
        System.out.println("Indice de Flipper trouvé : " + index);

        boolean removed = zooTunis.removeAnimal("Flipper");
        System.out.println("Suppression réussie ? " + removed);
        zooTunis.displayAnimals();



        Zoo plusGrand = Zoo.comparerZoo(zooTunis, zooSousse);
        System.out.println("Le zoo avec le plus d’animaux est : " + plusGrand.getName());

    }
}
