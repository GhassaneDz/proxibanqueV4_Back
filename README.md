# ProxiBanque Version 4                                                         30/07/2018
Nadir, Fabien et Faouzi
------------------------------------------------------------------------------------------

## I_Introduction

L’entreprise Proxibanque souhaite ouvrir une filière d’assurance automobile 
avantageuse pour ses clients, mais hésite à investir dans cette voie.
L’objectif de cette demande est de pouvoir déployer facilement la partie 
« frontend » de l’application comme écran de veille sur les tablettes en 
libre service dans toutes les agences

## II_Fonctionnalités

L'application a deux fonctionnalités principales. La première est la gestion des 
sondages (back-end), la seconde est un écran de veille qui propose aux clients 
de passage dans l'agence 
d'émettre un avis positif ou négatif à un sondage.
En cas d'avis négatif, le client a la possibilité d'écrire un commentaire et de 
le valider.
En cas d'avis positif, il est demandé au client de remplir son numéro d'identification 
afin d'être contacté ultérieurement.
Si ce dernier n'a pas de numéro d'identification, il est proposé au client de s'inscrire 
en renseignant son nom, prénom, téléphone et email.

## III_Installation
Les diagrammes de classes et sql sont dans le dossier "UML"
Pour utiliser ProxiBanque v.4 : 
/!\ IMPORTANT /!\
Déziper dans un dossier le fichier "Proxibanque_V4_BOUFAOULEN.zip"

------ Créer la base de donnée MySQL ------
1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Lancer admin MySQL
5) Importer le fichier demo.sql présent dans le dossier source BDD

------ Installer l'application FRONT ------
1) ouvrir une console
2) aller jusqu'au dossier source de proxibanque_V4_Front.
3) télécharger le gestionnaire de package npm et les dépendances bootstrap, 
jquery et popper.js
4) démarrer le serveur angular 
5) ouvrir un navigateur sur l'url http://localhost:4200/

------ Installer l'application BACK ------
1) ouvrir Eclipse
2) importer le dossier proxibanque_V4_Back 
3) démarrer le serveur TomCat
4) ouvrir un navigateur sur l'url http://localhost:8080/proxibanque/

## IV_Utilisation
#BackEnd
Au démarrage l'application ProxiBanqueV4 affiche une page listant tous les 
sondages présents en base de donnée.
Pour chaque sondage vous pouvez voir les détails du sondage (nombre d'avis 
positifs et négatifs ainsi que les commentaires éventuels) et cloturer le sondage actif.

Si un sondage est en cours, vous ne pourrez pas en démarrer un nouveau.
Il vous est alors proposé de cloturer le sondage en cours.

Sur la page de cloture de sondage, il vous est demandé d'indiquer une date de cloture 
qui nécessairement doit être postéruieur à la date de début du sondage.

Seuls les conseillers de clientèles peuvent se connecter. 

#Front
L'application propose deux pages principales.
Si aucun sondage n'est en cours, une page affiche un titre proposant d'obtenir un devis 
d’assurance auto.
Deux boutons existent (téléphone et mail) mais n'ont aucune fonctionnalités actuellement.
Si un sondage est en cours, une page propose au client de donner un avis positif ou 
négatif au sondage.
Pouce lever: avis positif, pouce baissé: avis négatif.

Si pouce levé est cliqué, il est proposé au client soit de s'identifier soit de s'inscrire 
afin d'être recontacter ultérieurement.
Si le pouce baissé est cliqué, il est proposé au client de laisser un commentaire et 
de le valider.


## V_EVOLUTIONS
    - Dans de futures versions, l'application proposera aux client lorsqu'il n'y a 
    pas de sondage en cours, d'indiquer leur numéro de téléphone ainsi que leur 
    email afin d'être recontacter.
    - il sera aussi possible de proposer aux gestionnaires une banque d'image à 
    mettre en lien avec les sondages créés