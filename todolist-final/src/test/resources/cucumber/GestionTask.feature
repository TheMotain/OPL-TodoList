@tag
Feature: Gestion Item
  Creation ou modification d un task

  @tag1
  Scenario Outline: Creation d'une Task
    Given La liste <list> existe
    And Je veux creer un task avec le nom <task> dans la liste
    When Je remplis le formulaire avec le nom <task> et la description <description>
    And Je valide la creation
    Then La task est cree, la date du jour est mise automatiquement et le statut est a false
    And Je suis redirige vers la page des resultats

    Examples: 
      | list | task       | description |
      | work | createTask | null        |

  @tag2
  Scenario Outline: Finir une Task
    Given La task <task> existe dans la liste <list>
    And Son statut est a l'etat <initial>
    When Je veux finir la tache
    Then Le statut de la tache est done
    And Je suis redirige vers la page des resultats

    Examples: 
      | list | task   | initial |
      | home | lunch  | true    |
      | home | dinner | false   |

  @tag3
  Scenario Outline: Suppression d'une Task
    Given La task <task> existe dans la liste <list>
    When Je supprime la supprime
    Then Le task <task> n'existe plus presente dans la liste
		And Je suis redirige vers la page des resultats

    Examples: 
      | list   | task     |
      | work   | meeting  |
