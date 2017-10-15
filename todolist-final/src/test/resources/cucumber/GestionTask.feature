@tag
Feature: Gestion Item
  Creation ou modification d un task

  @tag1
  Scenario Outline: Creation d Un Task
    Given J ai cree une liste <list>
    And Je veux creer un task avec le nom <task>
    When Je clique le bouton et remplis le formulaire avec <task>, <description>, <creation_date>, <done>
    And Je valide creation
    Then Je suis redirige vers la page de task

    Examples: 
      | list | task    | description | creation_date | done  |
      | work | meeting | null        | null          | false |

  @tag2
  Scenario Outline: Finir d Un Task
    Given Je veux finir le task <task> dans ma liste <list>
    And Task <task> a son etat initial <initial>
    When Je change son etat a <done>
    Then Je suis redirige vers la page de resultat

    Examples: 
      | list | task   | initial | done |
      | home | lunch  | false   | true |
      | home | dinner | true    | true |

  @tag3
  Scenario Outline: Suppression d Un Task
    Given J ai task <task> dans ma liste <list>
    When Je supprime task <task>
    Then Le task n'existe plus dans ma liste

    Examples: 
      | list   | task     |
      | school | homework |
