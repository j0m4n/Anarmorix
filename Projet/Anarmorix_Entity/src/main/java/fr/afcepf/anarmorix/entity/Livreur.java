package fr.afcepf.anarmorix.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entité représentant un livreur.
 */
@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends Professionnel {

    /**
     * Numéro pour sérialisation.
     */
    @Transient
    private static final long serialVersionUID = 1L;

    /**
     * Société de livraison employant le livreur.
     */
    @ManyToOne
    @JoinColumn(name = "id_societe", nullable = true, foreignKey = @ForeignKey(name = "FK_Livreur_Societe"))
    private SocieteDeLivraison societe;

    /**
     * Liste des tournées effectuées par le livreur.
     */
    @OneToMany(mappedBy = "livreur")
    private List<Tournee> tournees;

    /**
     * Default constructor.
     */
    public Livreur() {
    }

    /**
     * Constructeur surchargé.
     * @param paramSociete the societe to set
     */
    public Livreur(SocieteDeLivraison paramSociete) {
        super();
        societe = paramSociete;
    }

    /**
     * @return the societe
     */
    public SocieteDeLivraison getSociete() {
        return societe;
    }

    /**
     * @param paramSociete the societe to set
     */
    public void setSociete(SocieteDeLivraison paramSociete) {
        societe = paramSociete;
    }

    /**
     * @return the tournees
     */
    public List<Tournee> getTournees() {
        return tournees;
    }

    /**
     * @param paramTournees the tournees to set
     */
    public void setTournees(List<Tournee> paramTournees) {
        tournees = paramTournees;
    }

}