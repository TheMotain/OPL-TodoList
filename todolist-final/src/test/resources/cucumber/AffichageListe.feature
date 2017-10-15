@tag
Feature: Afficher Todo Liste
  Affichage des todo listes

  @tag1
  Scenario Outline: Afficher tous les liste
    Given J ai les todo listes <list1>, <list2>, <list3>, <list4>
    When Je veux regarder toutes les listes
    Then Toutes les listes sont affichees

    Examples: 
      | list1  | list2  | list3  | list4   |
      | work   | home   | todel  | display |

  @tag2
  Scenario Outline: Afficher contenu d une liste
    Given J ai une todo liste avec le nom <list>
    And J ai une tache <name> dans la liste
    When Je veux regarder toutes les listes
    Then La page home est affichee
    And Le contenu de tache <name> avec les attributs <id>, <description>, <creation_date>, <done> sont affiche

    Examples: 
      | list   | name     |  id  | description | creation_date | done  |
      | work   | meeting  |  0   | todo        |    2017-10-11 | false |
      | home   | lunch    |  1   | hello       |    2017-10-11 | true  |
      | home   | dinner   |  2   | toprepare   |    2017-10-11 | false |
      
  @tag3
  Scenario Outline: Formatage du contenu d'une liste par ligne de 5 taches
    Given j'ai une todoListe avec le nom <list>
    And j'ai <nbtask> taches qui lui sont ratachees
    When Je veux regarder toutes les listes
    Then La liste retournee contient <nbdisplayline>
    And Une ligne contient au maximum 5 taches
    
    Examples:
      | list    | nbtask  | nbdisplayline  |
      | work    | 1       | 1              |
      | home    | 2       | 1              |
      | todel   | 0       | 0              |
      | display | 12      | 3              |