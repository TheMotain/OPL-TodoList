@tag
Feature: Gestion Item

Scenario Outline: Creation d'un Item
	Given J'ai cree un todo liste
	And Je clique sur un liste deja existe
	When Je clique le liste
	And Je remplis le formulaire avec <name>,<description>,<creation_date>,<done>
	And Je valide creation
	Then Un item <id> est cree
	
	

	
 

	
	
	
	
	
	
	
	
	Examples:
	|id|name           |descrioption |creation_date|done |
	|1 |acheter l'eau  |acheter l'eau|20171011     |false|