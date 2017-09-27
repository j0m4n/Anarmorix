package fr.afcepf.anarmorix.business.api;

import java.util.List;

import fr.afcepf.anarmorix.entity.Exploitation;
import fr.afcepf.anarmorix.entity.Livreur;
import fr.afcepf.anarmorix.entity.SocieteDeLivraison;
import fr.afcepf.anarmorix.entity.Tournee;
import fr.afcepf.anarmorix.exception.AnarmorixException;

/**
 * Classes contenant les fonctionnalités métier de {@link Livreur}.
 */
public interface IBusinessLivreur {

    /**
     * Méthode pour obtenir les tournées de la société de livraison du livreur.
     * @param paramSocieteDeLivraison societe de livraison à alimenter
     * @return la société de livraison avec ses tournees
     * @throws AnarmorixException une exception
     */
    SocieteDeLivraison setTournees(SocieteDeLivraison paramSocieteDeLivraison) throws AnarmorixException;
    /**
     * Méthode ajoutant les lignes de commandes d'une tournée (avec pour chaque ligne de commande son produit entièrement rempli.
     * @param paramTournee la {@link Tournee} à remplir
     * @return la tournee avec ses lignes de commandes
     * @throws AnarmorixException une exception
     */
    Tournee setLignesCommandes(Tournee paramTournee) throws AnarmorixException;
    /**
     * Méthode récupérant un set des exploitations à visiter d'une tournée.
     * @param paramTournee la tournée sélectionné
     * @return la collection des exploitation à visiter.
     * @throws AnarmorixException une exception
     */
    List<Exploitation> setExploitationAVisiter(Tournee paramTournee) throws AnarmorixException;

}