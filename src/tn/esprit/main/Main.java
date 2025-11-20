package tn.esprit.main;

import tn.esprit.entities.Departement;
import tn.esprit.entities.DepartementHashSet;

public class Main {
    public static void main(String[] args) {

        // Création de la structure HashSet
        DepartementHashSet ds = new DepartementHashSet();

        // --- Création des départements ---
        Departement d1 = new Departement(1, "Informatique", 25);
        Departement d2 = new Departement(2, "Mathématiques", 15);
        Departement d3 = new Departement(3, "Physique", 20);
        Departement d4 = new Departement(2, "Mathématiques", 15); // Duplicate, doit être rejeté

        System.out.println("=== AJOUT ===");
        ds.ajouterDepartement(d1);
        ds.ajouterDepartement(d2);
        ds.ajouterDepartement(d3);
        ds.ajouterDepartement(d4); // test duplicate

        ds.afficherDepartements();

        // --- Recherche par nom ---
        System.out.println("\n=== RECHERCHE PAR NOM ===");
        System.out.println("Recherche Informatique : " + ds.rechercherDepartement("Informatique"));
        System.out.println("Recherche Biologie : " + ds.rechercherDepartement("Biologie"));

        // --- Recherche par objet ---
        System.out.println("\n=== RECHERCHE PAR OBJET ===");
        System.out.println("Recherche d1 : " + ds.rechercherDepartement(d1));
        System.out.println("Recherche d4 (duplicate) : " + ds.rechercherDepartement(d4));

        // --- Suppression ---
        System.out.println("\n=== SUPPRESSION ===");
        ds.supprimerDepartement(d2);
        ds.afficherDepartements();

        // --- Tri par ID ---
        System.out.println("\n=== TRI PAR ID ===");
        ds.trierDepartementsParId();

        // --- Tri par nom & nombre d'employés ---
        System.out.println("\n=== TRI PAR NOM + NOMBRE EMPLOYES ===");
        ds.trierDepartementsParNomEtNombreEmployes();

        System.out.println("\n=== FIN DU TEST ===");
    }
}
