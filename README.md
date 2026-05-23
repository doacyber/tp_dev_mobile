# TP Développement Mobile - Android

Ce dépôt contient les travaux pratiques réalisés pour le cours de Développement Mobile Android.

## Contenu du projet

Le projet est une application de gestion de bibliothèque permettant de lister, ajouter, modifier et supprimer des livres, avec une persistance locale des données.

### Travaux Pratiques (Labs)

- **Lab 5 : Navigation et Fiche Détail**
  - Mise en place de la navigation entre l'écran principal et l'écran de détail.
  - Affichage des informations complètes d'un livre.
  - Fichier : `app/src/main/java/com/example/bibliotheque/DetailActivity.java`

- **Lab 6 : Formulaire d'ajout et de modification**
  - Création d'un formulaire pour saisir les informations d'un livre (titre, auteur, genre, etc.).
  - Gestion de l'ajout de nouveaux livres et de la modification de livres existants.
  - Fichiers clés : `AddEditActivity.java`, `activity_add_edit.xml`

- **Lab 7 : Persistance locale avec Room**
  - Intégration de la bibliothèque Room pour la base de données locale.
  - Définition de l'entité `Livre`, du DAO (`LivreDao`) et de la base de données (`AppDatabase`).
  - Persistance des données entre les sessions de l'application.

## Structure du Projet

- `app/src/main/java/com/example/bibliotheque/` : Code source Java.
- `app/src/main/res/layout/` : Fichiers de mise en page XML.
- `app/build.gradle` : Configuration des dépendances (Room, Navigation, etc.).
