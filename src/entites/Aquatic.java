package entites;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() {
        super("", "", 0, false);
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public  abstract void swim() ;

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aquatic aquatic = (Aquatic) obj;
        return age == aquatic.age &&
                name.equals(aquatic.name) &&
                habitat.equals(aquatic.habitat);
    }

    @Override
    public String toString() {
        return "Aquatic{name='" + name + "', age=" + age + ", habitat='" + habitat + "'}";
    }
}
