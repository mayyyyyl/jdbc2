# jdbc2

 ## Rendu du Tp5 et Tp6 Jdbc
 
 ### Lancer le projet
 
 Prérequis: créer une base de données compta et avoir lancé le script.sql (le script utilisé en cours était différent que celui présent dans le tp4 Jdbc, pas id auto-incrémenté sur les tables -> voir fichier compta.sql)
 
 
  - ` git clone https://github.com/mayyyyyl/jdbc2.git `
  -  ouvrir le dossier
  - dans resources > db.properties
        modifier les property suivantes afin de vous connecter à votre base de données:
        db.url=url de la bd
        db.user=user
        db.password=password
      
 
 ## Tp5 Utilisation des PreparedStatement

J'ai implémenté l'utilisation des PreparedStatement pour la classe FournisseurDaoJdbc
Le package testFournisseur "package fr.epsi.b32223g1.dal.testFournisseurJdbc;" est composé de plusieurs classes qui utilisent les méthodes de la classe FournisseurDaoJbdc.


L'insertion en base de données d'un fournisseur ayant comme nom "L'espace Création" se passe bien.


![Capture d'écran_20230222_203502](https://user-images.githubusercontent.com/90853285/220739939-2f36b971-a55f-4f8e-bb7b-07852bbef5c0.png)

 ## Tp6 Mise en place d’une DAO pour la gestion des Articles
 
 L'insertion des données et l'utilisation de la DAO se trouvent dans le package "package fr.epsi.b32223g1.dal.testArticleJdbc;"
 
 Les requêtes fonctionnent, la suppression du fournisseur "La Maison de la Peinture" aussi.
 
