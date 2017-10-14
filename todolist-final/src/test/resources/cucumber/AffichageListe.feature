@tag
Feature: Afficher Todo Liste
  Affichage des todo listes

  @tag1
  Scenario Outline: Afficher tous les liste
    Given J ai les todo listes <list1>, <list2>, <list3>
    When Je veux regarder toutes les listes
    Then Toutes les listes sont affichees

    Examples: 
      | list1  | list2  | list3  |
      | work   | home   | todel  |

  @tag2
  Scenario Outline: Afficher contenu d une liste
    Given J ai une todo liste avec le nom <list>
    And J ai une tache <task> dans la liste <list>
    When Je veux regarder toutes les listes
    Then Le contenu de tache <name> avec <description>, <creation_date>, <done> sont affiche

    Examples: 
      | list   | name     | description | creation_date | done  |
      | work   | meeting  | hello       |    2017-10-11 | false |
      | home   | lunch    | hello       |    2017-10-11 | false |
      | home   | dinner   | hello       |    2017-10-11 | false |