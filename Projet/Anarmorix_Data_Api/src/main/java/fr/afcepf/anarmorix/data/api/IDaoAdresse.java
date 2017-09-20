package fr.afcepf.anarmorix.data.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Ville;

/**
 * 
 */
public interface IDaoAdresse {

    /**
     * @param numero 
     * @param voie 
     * @return
     */
    public List<Ville> rechercher(Integer numero, String voie);

    /**
     * @param adresse 
     * @return
     */
    public Adresse ajouter(Adresse adresse);

    /**
     * @param id 
     * @return
     */
    public Boolean supprimer(Integer id);

    /**
     * @param id 
     * @return
     */
    public Adresse mettreAJour(Integer id);

}