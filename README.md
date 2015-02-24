tournoiMonGars
====================================
#### Projet JAVA EPF : UltimateTournament

Cette application a pour but de gérer un tournoi sportif. 
L'utilisateur est amené à choisir le type de tournoi (par élimination ou par poules), l'application va lui proposer des combinaisons de matchs parmi les équipes qu'il aura renseignées, et il devra ensuite saisir les scores de ces matchs.
En fonction des résultats, l'applicaion va éliminer des participants jusqu'à arriver à un gagnant.

###Fonctionnalités demandées implémentées
* Je suis capable de créer un nouveau tournoi en choisissant le nombre d'équipe et l'organisation de celui-ci.
>Implémenté complètement

* Je suis capable de modifier les informations relatives à chaque équipe du tournoi et ce à tout moment (dans des limites raisonnables bien sûr).
>Implémenté complètement : on peut modifier le nom de l'équipe, le nom de l'entraîneur, le nombre de joueurs à tout moment.

* Je suis capable de lancer mon tournoi et de saisir les informations sur les matchs à la volée.
>Implémenté complètement

* Je peux choisir l'organisation du tournoi parmi deux disponibles.
>Implémenté, il manque la sélection initiale des équipes pour chaque tour, les équipes sont tirées aléatoirement.

* Deux clients sont disponibles : Console et Swing. Le choix se fait au lancement de l'application.

* Gestion du nombre d'équipes impair
>Pas de gestion, choix imposé

* Erreurs personnalisées
>Les erreurs affichées à l'utilisateur s'affichent dans un JDialog personnalisé en fonction de l'erreur
