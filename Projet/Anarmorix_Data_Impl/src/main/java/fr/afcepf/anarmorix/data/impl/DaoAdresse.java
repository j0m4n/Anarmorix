package fr.afcepf.anarmorix.data.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.anarmorix.data.api.IDaoAdresse;
import fr.afcepf.anarmorix.data.api.IDaoLigneCommande;
import fr.afcepf.anarmorix.entity.Adresse;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Ville;
import fr.afcepf.anarmorix.exception.AnarmorixException;
import fr.afcepf.anarmorix.exception.AnarmorixExceptionEnum;

/**
 * Classe permettant la gestion des {@link Adresse}s.
 */
@Remote(IDaoAdresse.class)
@Stateless
public class DaoAdresse implements IDaoAdresse {

    /**
     * Entity manager.
     */
    @PersistenceContext(unitName = "Anarmorix_Data_Impl")
    private EntityManager em;
    
    /**
     * Requête permettant de trouver l'ensemble des lignes d'une {@link Commande}.
     */
    private static final String REQ_RECHERCHE = "SELECT v.adresses FROM Ville v WHERE v.codeInsee = :pCodeInsee";

    /**
     * Requête permettant de récupérer une ligne commande en fonction de son Id.
     */
    private static final String REQ_LIGNE_ID = "Select a FROM Adresse a WHERE a.id = :pId";

    /**
     * Default constructor.
     */
    public DaoAdresse() {
    }

    /**
     * Méthode retournant l'ensembles des {@link Adresse}s d'une {@link Ville}.
     */
    @Override
    public List<Adresse> rechercher(Ville paramVille) throws AnarmorixException {
        try {
            List<Adresse> liste =  em.createQuery(REQ_RECHERCHE).setParameter("pCodeInsee", paramVille.getCodeInsee()).getResultList();
            if (liste.size() == 0) {
                AnarmorixException exc = new AnarmorixException("La ville demandée n'existe pas.", AnarmorixExceptionEnum.ARGUMENT_INEXISTANT);
                throw exc;
            }
            return liste;
        } catch (Exception e) {
            if (e.getMessage() == "La ville demandée n'existe pas.") {
                throw e;
            } else {
                AnarmorixException exc = new AnarmorixException("Message : " + e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
                throw exc;
            }
        }
    }

    @Override
    public Adresse ajouter(Adresse paramAdresse) throws AnarmorixException {
        // TODO Auto-generated method stub
        try {
            em.persist(paramAdresse);
            return paramAdresse;
        } catch (Exception e) {
            AnarmorixException exc =  new AnarmorixException(e.getMessage(), AnarmorixExceptionEnum.ERREUR_NON_IDENTIFIEE);
            throw exc;
        }
    }

    @Override
    public Boolean supprimer(Integer paramId) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Adresse mettreAJour(Integer paramId) throws AnarmorixException {
        // TODO Auto-generated method stub
        return null;
    }

}