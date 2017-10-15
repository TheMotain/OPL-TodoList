Dalencourt Alex et Su Hui.

Installation : mvn clean install
Run : mvn spring-boot:run
Run : exécuter le main de la classe SpringBootWebApplication.java
Tests : mvn tests
Connect :http://localhost:8080/

Installation :
Importer le projet maven sous eclipse.
Lancer la commande mvn clean install pour installer l'application
Pour tester l'application il nécessaire d'utiliser une machine physique du M5 ou d'utiliser le VPN.
En effet, l'application se connecte à une base postgresql hébergée sur le VPS fournit par le M5.
Il est donc nécessaire de faire partit du réseau pour pouvoir accéder à la base de données.

Pour l'exécution des tests une base de données embarquée est utilisée.

Liste des fonctionnalité réalisées :
- Créer une todo liste
- Supprimer une todo liste
- Créer un item représentant une tâche
- Cocher un item pour indiquer que la tâche a été réalisée
- Supprimer un item

L'outil d'ATDD choisi : Cucumber 

Organisation dans la double boucle ATDD + TDD par l'ordre :
- Créer le feature de ATDD
- Implémenter les step correspondant aux features créés
- Création en parallèle des signatures de méthodes (qui remonte une erreur non implémenté) afin que les steps puissent être compilés 
- Implémenter par la méthode TDD
- A la fin de l'implémentation TDD les tests correspondans aux steps passent tous au vert

Difficultés rencontrées : 
- Configuration générale de l'application
- Nous n'avons pas réussi à configurer cucumber pour réaliser des requête http
-> Cela nous a bloqué pour pouvoir tester la partie front end

Living documentation :
La documentation est faite par les feature.
Dans le répertoire src/test/resources/cucumber se trouve toutes les features
Les steps sont implémenté dans le répertoire src/test/java/fr/iagl/opl/steps

Couverture de test :
Le rapport de couverture est généré par le plugin jacoco.
Le rapport se trouve dans le zip Rapport_de_test (index.html).
