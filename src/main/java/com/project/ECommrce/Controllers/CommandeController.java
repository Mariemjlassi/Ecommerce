package com.project.ECommrce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ECommrce.Entities.Commande;
import com.project.ECommrce.Entities.Panier;
import com.project.ECommrce.Services.ICommandeService;

@RestController
@RequestMapping("/api")
public class CommandeController {

	@Autowired
	private ICommandeService commandeService;
	
	@PostMapping(value="/passerCommande/{idPanier}")
	public ResponseEntity<Commande> placeOrder(@RequestParam Long panierId, @RequestParam String nomClient, @RequestParam String prenomClient, @RequestParam int telephoneClient) { 
		Commande newCommande = commandeService.passerCommande(panierId, nomClient, prenomClient, telephoneClient); 
		return new ResponseEntity<>(newCommande, HttpStatus.CREATED); }

	@GetMapping("/commande") 
	public List<Commande> getAllCommandes() { 
		
		return this.commandeService.getAllCommandes(); 
	}
	@DeleteMapping("/commande/{id}")
	 public ResponseEntity<String> deleteCommande(@PathVariable(value="id") Long id){
		 this.commandeService.deleteCommande(id);
		 return ResponseEntity.status(HttpStatus.OK).body("Commande deleted successfully");
	 }
	@PutMapping("/commande/{idCommande}/{idPanier}")
	public ResponseEntity<Commande> updateOrder(@RequestParam Long id, @RequestParam String nomClient, @RequestParam String prenomClient, @RequestParam int telephoneClient) { 
		Commande updatedCommande = commandeService.updateCommande(id, nomClient, prenomClient, telephoneClient);
		return new ResponseEntity<>(updatedCommande, HttpStatus.OK);
	}
}
