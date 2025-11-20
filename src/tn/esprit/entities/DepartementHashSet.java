package tn.esprit.entities;
import tn.esprit.interfaces.IDepartement;



import java.util.*;

public class DepartementHashSet implements IDepartement<Departement> {

    private HashSet<Departement> departements;

    public DepartementHashSet() {
        departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(Departement d) {
        if (departements.add(d)) {
            System.out.println("Département ajouté : " + d.getNomDepartement());
        } else {
            System.out.println("Département déjà existant : " + d.getNomDepartement());
        }
    }

    @Override
    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement d : departements) {
            if (d.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return departements.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        if (departements.remove(d)) {
            System.out.println("Département supprimé : " + d.getNomDepartement());
        } else {
            System.out.println("Impossible de supprimer : département introuvable");
        }
    }

    @Override
    public void afficherDepartements() {
        System.out.println("\n--- Liste des départements ---");
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    @Override
    public void trierDepartementsParId() {
        List<Departement> list = new ArrayList<>(departements);
        list.sort(Comparator.comparingInt(Departement::getId));

        System.out.println("\n--- Départements triés par ID ---");
        for (Departement d : list) {
            System.out.println(d);
        }
    }

    @Override
    public void trierDepartementsParNomEtNombreEmployes() {
        List<Departement> list = new ArrayList<>(departements);

        list.sort(Comparator
                .comparing(Departement::getNomDepartement)
                .thenComparingInt(Departement::getNombreEmployes));

        System.out.println("\n--- Départements triés par nom puis nombre d'employés ---");
        for (Departement d : list) {
            System.out.println(d);
        }
    }
}
