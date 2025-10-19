package entites;

public class Zoo {
    static final int MAX_CAGES = 25;
    private Animal[] animals = new Animal[MAX_CAGES];
    private Aquatic[] aquaticAnimals = new Aquatic[10]; // Instruction 25
    private String name;
    private String city;
    private int nbrCages;
    private int animalCount = 0;
    private int aquaticCount = 0;

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.nbrCages = nbrCages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne peut pas être vide");
        }
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public void setNbrCages(int nbrCages) {
        this.nbrCages = nbrCages;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void displayZoo() {
        System.out.println("Nom du Zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
        System.out.println("Nombre d'animaux : " + animalCount);
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

    public int searchAnimal(String animalName) {
        for (int i = 0; i < animalCount; i++) {
            if (animalName.equalsIgnoreCase(animals[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter : " + animal.getName());
            return false;
        }
        if (searchAnimal(animal.getName()) != -1) {
            System.out.println("L'animal existe déjà : " + animal.getName());
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


    public void addAquaticAnimal(Aquatic a) {
        if (aquaticCount < aquaticAnimals.length) {
            aquaticAnimals[aquaticCount++] = a;
        } else {
            System.out.println("La section aquatique est pleine !");
        }
    }


    public void makeAllSwim() {
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim();
        }
    }


    public float maxPenguinDepth() {
        float max = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > max) {
                    max = p.getSwimmingDepth();
                }
            }
        }
        return max;
    }


    public void countByType() {
        int dolphins = 0, penguins = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) dolphins++;
            else if (aquaticAnimals[i] instanceof Penguin) penguins++;
        }
        System.out.println("Nombre de dauphins : " + dolphins);
        System.out.println("Nombre de pingouins : " + penguins);
    }
}
