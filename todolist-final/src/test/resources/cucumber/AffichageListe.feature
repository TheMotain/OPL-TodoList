@tag
Feature: Afficher Todo Liste
  Affichage des todo listes

  @tag1
  Scenario Outline: Afficher tous les liste
    Given J ai une todo liste avec le nom <list>
    When Je veux regarder tous les listes
    And Tous les listes avec le nom<list> sont a afficher
    Then Tous les listes avec le nom<list> sont affiche

    Examples: 
      | list   |
      | work   |
      | home   |
      | school |

  @tag2
  Scenario Outline: Afficher contenu d une liste
    Given J ai une todo liste avec le nom <list>
    And J ai une tache <task> dans la liste <list>
    When Je clique sur la liste <list>
    Then Le contenu de tache <name> avec <description>, <creation_date>, <done> sont affiche

    Examples: 
      | list   | name     | description | creation_date | done  |
      | work   | meeting  | hello       |      20171011 | false |
      | home   | lunch    | hello       |      20171011 | false |
      | home   | dinner   | hello       |      20171011 | false |
      | school | homework | hello       |      20171011 | false |
