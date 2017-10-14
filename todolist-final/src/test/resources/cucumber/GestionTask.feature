@tag
Feature: Gestion Item
  Creation ou modification d un task

  @tag1
  Scenario Outline: Creation d Un Task
    Given J ai cree une liste <list>
    And Je veux creer un task
    When Je clique le bouton creer un task
    And Je remplis le formulaire avec <task>, <description>, <creation_date>, <done>
    And Je valide creation
    Then Un task <task> est cree

    Examples: 
      | list | task    | description | creation_date | done  |
      | work | meeting | null        |      20171011 | false |

  @tag3
  Scenario Outline: Finir d Un Task
    Given Je veux finir <task> dans ma liste <list>
    And Task <task> a son etat initial <initial>
    When Je change son etat a <done>
    Then Je suis redirige vers le page de resultat

    Examples: 
      | list | task   | initial | done |
      | home | lunch  | false   | true |
      | home | dinner | true    | true |

  @tag4
  Scenario Outline: Suppression d Un Task
    Given J ai task <task> dans ma liste <list>
    When Je supprime task <task>
    Then Le task n'existe plus dans ma liste

    Examples: 
      | list   | task     |
      | school | homework |
