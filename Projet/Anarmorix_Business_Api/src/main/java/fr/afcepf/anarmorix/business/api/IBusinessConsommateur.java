package fr.afcepf.anarmorix.business.api;



import java.util.List;

import fr.afcepf.anarmorix.entity.Adherent;
import fr.afcepf.anarmorix.entity.Client;
import fr.afcepf.anarmorix.entity.Commande;
import fr.afcepf.anarmorix.entity.LigneCommande;
import fr.afcepf.anarmorix.entity.Packaging;
import fr.afcepf.anarmorix.exception.AnarmorixException;


public interface IBusinessConsommateur {
	
	 List<LigneCommande> afficherLigneCommande(Commande commande) throws AnarmorixException;
	 Client afficherClient(Commande commande) throws AnarmorixException;
	
	 
		
	

}
