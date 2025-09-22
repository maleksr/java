public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;


    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    public String toString() {
        return "Animal [Nom = " + name +
                ", Famille = " + family +
                ", Âge = " + age +
                ", Mammifère = " + isMammal + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal)) return false;
        Animal other = (Animal) obj;
        return this.name.equalsIgnoreCase(other.name);
    }
}
