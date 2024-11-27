package com.project.ECommrce.Services;

import java.util.List;

import com.project.ECommrce.Entities.Commande;

public interface ICommandeService {
	public Commande passerCommande(Long panierId, String nomClient, String prenomClient, int telephoneClient);
	List<Commande> getAllCommandes();
	Commande getCommandeById(Long idCommande);
	public Commande updateCommande(Long idCommande, String nomClient, String prenomClient, int telephoneClient);
	void deleteCommande(Long idCommande);
}
