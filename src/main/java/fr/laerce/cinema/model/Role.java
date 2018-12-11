package fr.laerce.cinema.model;

public class Role {
 private Integer place;
 private  String nom;
 private Personne personne;
 private Film film;
    public Role(Integer place,String nom,Personne personne,Film film ) {
        this.place=place;
        this.nom=nom;
        this.personne=personne;
        this.film=film;
    }

    public Integer getPlace() {
        return place;
    }

    public String getNom() {
        return nom;
    }

    public Personne getPersonne() {
        return personne;
    }

    public Film getFilm() {
        return film;
    }

    @Override
    public String toString() {
        return "Role{" +
                "place=" + place +
                ", nom='" + nom + '\'' +
                ", personne=" + personne.getNom () +
                ", film=" + film.getTitre () +
                '}';
    }
}

