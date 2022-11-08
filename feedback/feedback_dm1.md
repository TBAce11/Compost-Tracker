# Feedback DM1

> **Ecolowkey**  
> Ismail SIMO (20153280)  
> Farouk KHEDER (20066734)  
> Tarik BENAKEZOUH (20184524)  
> Christie Kongandji EMBEYA (20170397)  

## Cadre du projet

- Bonne description du projet. Le cadre du projet bien défini
- L'échéancier ne décrit pas suffisamment la planification du projet
  - Les semaines liées au jalon visé (ici jalon 1) doivent afficher les taches détaillées (nom, court descriptif, dépendance, membres assignés à la tâche). Pour les semaines à venir, seuls le nom des taches et leurs dépendances sont nécessaires.

## Compréhension du domaine

### Glossaire

La plupart des termes sont manquants.

- Bineco*
- Résident*
- Activités*
- Bacs*
- Type de bacs
- État des bacs
- Signaler un problème*
- Métriques écologiques*
- Capteurs

### Persona

Un bon point de départ. Les objectifs doivent se rapprocher de l'application.

## Modélisation du domaine

### Cas d'utilisation

Il faut un diagramme décrivant tous les CUs. Le diagramme ne respecte pas le formalisme UML (difficile à interpréter).

- Vous avez très bien considéré Résident et Consommateur comme des spécialisations d'Utilisateur.
- Vous avez identifié de bons cas d'utilisation.
- Il manque un autre acteur pour le capteur.  
- Qu'est-ce que l'acteur API ? Cela devrait être discuté.
- Les préconditions, les postconditions et les scénarios ne sont pas bien développés.  

## Analyse

### Risques

- Certains risques sont bien écrits.  
- Suggestions:
  - Projet trop couteux
  - Temps alloué insuffisant
  - Politique empêche la réalisation du projet

### Exigences non-fonctionnelles

Bonnes exigences non fonctionnelles identifiées. Cependant, à mon avis, le premier élément n'est pas une exigence non fonctionnelle. Il doit être mentionné dans une autre section (Contraintes conceptuelles). Autres exigences non fonctionnelles à prendre en compte:

- Fiabilité
- Légalité (s'assurer de respecter les lois sur la collecte de données, l'usage des données de la ville)
- Efficacité (atteinte des objectifs)
- etc.

### Ressources

À réviser.

- Pour les matériels nécessaires, il faut mentionner :
  - Capteurs pour scanner le contenu des bacs
  - Serveur pour héberger les données et programmes
  - Téléphone si application mobile
  - etc.
  
- Pour les solutions de stockage, il faut mentionner:
  - Le type de la base de données et les avantages
  - Stockage partagé: Une partie des données résident dans les serveurs (base de données) de la ville et l'autre sur les serveurs de Bineco
  - etc.

### Contraintes conceptuelles

Bien.

### Contraintes physiques
  
- Vous avez mentionné certains éléments. Merci! Il faut développer et ajouter quelques éléments sur: (par exemple)
  - Spécification des appareils et outils utilisés pour interagir avec l'application
  - Choix du lecteur doit être compatible avec les capteurs (via internet, Bluetooth)
  - etc.

### Métriques

C'est bien d'avoir et de justifier plus de métriques:

- min 3 métriques pour résidence
- min 3 métriques pour ville
- max 10 métriques au total

### Prototype

Très bien

## Rapport

- Le rapport nécessite un peu plus de travail.
- Il semble que certaines feuilles de style manquent. De plus, certaines images ne tiennent pas correctement dans la page.
- Certaines images manquent.
- Manque le rôle de chaque membre

## Git

Bon usage de Git jusqu'à présent.

- Ajoutez un README
