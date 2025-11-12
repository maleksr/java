package main;

import entites.*;
import exceptions.*; // pour les exceptions ZooFullException et InvalidAgeException

public class Main {
    public static void main(String[] args) {



        Zoo zoo = new Zoo("Belvedere", "Tunis", 25);

        Dolphin d1 = new Dolphin("Mammifère", "Flipper", 5, true, "Mer", 30.5f);
        Dolphin d2 = new Dolphin("Mammifère", "Blue", 8, true, "Océan", 28.0f);
        Penguin p1 = new Penguin("Oiseau", "Pingu", 3, false, "Banquise", 50.0f);
        Penguin p2 = new Penguin("Oiseau", "Skipper", 4, false, "Antarctique", 70.0f);

        zoo.addAquaticAnimal(d1);
        zoo.addAquaticAnimal(d2);
        zoo.addAquaticAnimal(p1);
        zoo.addAquaticAnimal(p2);

        zoo.makeAllSwim();
        zoo.countByType();

        System.out.println("\nProfondeur maximale des pingouins : " + zoo.maxPenguinDepth() + " m");

        Dolphin d3 = new Dolphin("Mammifère", "Flipper", 5, true, "Mer", 32.0f);
        System.out.println("d1 et d3 sont identiques ? " + d1.equals(d3));


        Zoo myZoo = new Zoo("Friguia", "Sousse", 2);


        try {
            myZoo.addAnimal(new Animal("Mammifère", "Lion", 5, true));
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        System.out.println();


        try {
            myZoo.addAnimal(new Animal("Reptile", "Serpent", -2, false));
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        System.out.println();


        try {
            myZoo.addAnimal(new Animal("Mammifère", "Tigre", 3, true));
            myZoo.addAnimal(new Animal("Mammifère", "Girafe", 7, true));
            myZoo.addAnimal(new Animal("Mammifère", "Zèbre", 4, true)); // dépassement
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("Nombre total d’animaux : " + myZoo.getAnimalCount());
        myZoo.displayAnimals();
}
    }
