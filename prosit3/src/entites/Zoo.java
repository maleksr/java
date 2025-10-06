public class Zoo {
    private static final int MAX_CAGES = 25;
    Animal[] animals = new Animal[MAX_CAGES];
    String name;
    String city;
    int nbrCages;
    int animalCount = 0;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
    }

    public void displayZoo() {
        System.out.println("Nom du Zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d’animaux : " + animalCount);
    }

    @Override
    public String toString() {
        return "Zoo [Nom = " + name +
                ", Ville = " + city +
                ", Nombre de cages = " + nbrCages +
                ", Animaux présents = " + animalCount + "]";
    }


    public void displayAnimals() {
        if (animalCount == 0) {
            System.out.println("Aucun animal dans le zoo.");
        } else {
            for (int i = 0; i < animalCount; i++) {
                System.out.println("Animal " + (i + 1) + ": " + animals[i]);
            }
        }
    }


    int searchAnimal(String animalName) {
        for (int i = 0; i < animalCount; i++) {
            if (animalName.equalsIgnoreCase(animals[i].name)) {
                return i;
            }
        }
        return -1;
    }


    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println(" Le zoo est plein, impossible d’ajouter : " + animal.name);
            return false;
        }
        if (searchAnimal(animal.name) != -1) {
            System.out.println(" L’animal existe déjà : " + animal.name);
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public boolean removeAnimal(String animalName) {
        int index = searchAnimal(animalName);
        if (index == -1) return false;


        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }


    public boolean isZooFull() {
        return animalCount >= MAX_CAGES;
    }


    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount >= z2.animalCount) {
            return z1;
        } else {
            return z2;
        }
    }
}
