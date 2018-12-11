package fr.laerce.cinema.model;

import java.util.List;
import java.util.Objects;

public class Film {
    private Integer id;
    private String titre;
    private Double notation;
    private String affiche;
    private String resume;
    private Personne realisateur;
    private List<Role> role;

    public Film(Integer id,String titre, Double notation, String affiche, String resume, Personne realisateur) {
        this.id=id;
        this.titre = titre;
        this.notation = notation;
        this.resume = resume;
        this.realisateur = realisateur;
        this.affiche=affiche;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getNotation() {
        return notation;
    }

    public void setNotation(Double notation) {
        this.notation = notation;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Personne getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Personne realisateur) {
        this.realisateur = realisateur;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(getTitre(), film.getTitre()) &&
                Objects.equals(getNotation(), film.getNotation()) &&
                Objects.equals(getResume(), film.getResume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitre(), getNotation(), getResume());
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", notation=" + notation +
                ", resume='" + resume + '\'' +
                ", realisateur=" + realisateur +
                '}';
    }
}
