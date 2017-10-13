@tag
Feature: Gestion TODO List
  Creation suppression d une TODO liste

  @tag1
  Scenario Outline: Creation d une TODO Liste
    Given Je veux creer une TODO liste avec le nom <name>
    And La TODO liste <name> n'existe pas
    When Je remplis le formulaire
    And Valide la création
    Then La TODO liste <name> est creee

  @tag2
  Scenario Outline: Suppression d une TODO Liste
    Given La TODO liste <name> existe
    And Je veux supprimer la TODO liste <name>
    When Je clique sur le bouton supprimer de la TODO Liste <name>
    Then La TODO liste est supprimee

  @tag3
  Scenario Outline: Impossible de creer une TODO Liste qui existe deja
    Given La TODO liste <name> existe
    And Je veux creer une TODO Liste <name>
    When Je remplis le formulaire
    And Valide la création
    Then Une erreur est affichee <name> existe deja

    Examples: 
      | name  |
      | work1 |
      | work2 |
      | work3 |
