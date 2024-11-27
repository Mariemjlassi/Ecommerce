package com.project.ECommrce.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ECommrce.Entities.Commande;
import com.project.ECommrce.Entities.Panier;
import com.project.ECommrce.Repositories.CommandeRepository;
import com.project.ECommrce.Repositories.PanierRepository;

@Service
public class CommandeService implements ICommandeService{

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private PanierRepository panierRepository;
	
	@Override
	public Commande passerCommande(Long panierId, String nomClient, String prenomClient, int telephoneClient) {
		Panier panier = panierRepository.findById(panierId).orElseThrow(() -> new RuntimeException("Panier not found"));
	    
		Commande commande = new Commande();
		commande.setNomClient(nomClient);
		commande.setPrenomClient(prenomClient);
		commande.setTelephoneClient(telephoneClient);
		commande.setPanier(panier);
		return commandeRepository.save(commande);
	}

	@Override
	public List<Commande> getAllCommandes() {
		// TODO Auto-generated method stub
		return this.commandeRepository.findAll();
	}

	@Override
	public Commande getCommandeById(Long idCommande) {
		// TODO Auto-generated method stub
		return this.commandeRepository.findById(idCommande).orElseThrow();
	}

	@Override
	public Commande updateCommande(Long idCommande, String nomClient, String prenomClient, int telephoneClient) {
	    Commande commande = commandeRepository.findById(idCommande).orElseThrow(() -> new RuntimeException("Commande not found"));

	    commande.setNomClient(nomClient);
	    commande.setPrenomClient(prenomClient);
	    commande.setTelephoneClient(telephoneClient);

	    return commandeRepository.save(commande);
	}


	@Override
	public void deleteCommande(Long idCommande) {
		this.commandeRepository.delete(this.commandeRepository.findById(idCommande).orElseThrow());
		
	}

}
