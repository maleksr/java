package main;

import entites.*;


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
    }
}
