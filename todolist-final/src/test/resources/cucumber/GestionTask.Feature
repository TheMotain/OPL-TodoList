@tag
Feature: Gestion Item
  Creation ou modification d un task

  @tag1
  Scenario Outline: Creation d Un Task
    Given J ai cree une liste <liste>
    And Je veux creer un task
    When Je clique le bouton creer un task
    And Je remplis le formulaire avec <name>, <description>, <creation_date>, <done>
    And Je valide creation
    Then Un task <name est cree

    Examples: 
      | liste | name  | descrioption | creation_date | done  |
      | todo  | task1 | Hello        |      20171011 | false |

  @tag2
  Scenario Outline: Modification Un Task
    Given J ai cree un task <name> dans la liste <liste>
    And Je veux modifier un task
    When Je clique le bouton modifier un task
    And Je modifie son <name>, <description>, <creation_date>, <done>
    And Je valide modification
    Then Le task <name> est modifie

    Examples: 
      | liste | name  | descrioption | creation_date | done  |
      | todo  | task1 | Hello        |      20171011 | false |

  @tag3
  Scenario Outline: Suppression d Un Task
    Given J ai <total> task dans ma liste
    When Je finis <finished> task dans ma liste
    Then J ai <left> task dans ma liste

    Examples: 
      | total | delete | left |
      |     3 |      1 |    2 |
      |     5 |      1 |    4 |

  @tag4
  Scenario Outline: Finir Un Task
    Given J ai <total> task dans ma liste
    When Je supprime <delete> task
    Then J ai <left> task dans ma liste

    Examples: 
      | total | finished | left |
      |     3 |        1 |    2 |
      |     5 |        1 |    4 |
