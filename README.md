# Application Web de Gestion des Stocks RentalHive
Nadir is here !!!
RentalHive est une entreprise spécialisée dans la location de matériel de construction. Ce projet implique le développement d'une application web de gestion des stocks basée sur Spring Boot, dans le but de moderniser la gestion des stocks et d'améliorer l'efficacité des processus de location d'équipement.

## Aperçu du Projet

RentalHive gère actuellement son inventaire de manière traditionnelle avec des fichiers papier et des tableurs, ce qui entraîne des erreurs fréquentes et des retards. Pour remédier à ces défis, RentalHive a décidé de développer une application web utilisant Spring Boot pour une gestion efficace des stocks.

L'objectif principal de l'application est d'autoriser les employés de RentalHive, y compris les responsables des stocks et les agents de location, à gérer facilement l'inventaire, à surveiller la disponibilité de l'équipement, à gérer les locations et à générer des rapports détaillés.

## Scénarios d'Utilisation

- **En tant que responsable du stock :**
  - Je veux pouvoir ajouter de nouveaux équipements au stock avec des détails tels que le nom, la quantité disponible et le coût de location par jour.
  - Je veux pouvoir mettre à jour les informations d'un équipement existant, y compris la quantité disponible et le coût de location.

- **En tant qu'utilisateur :**
  - Je veux pouvoir rechercher un équipement spécifique dans le stock pour connaître sa disponibilité et son coût de location.
  - Je veux pouvoir voir l'historique des locations pour un équipement spécifique.

## Exigences Supplémentaires

### Tests Unitaires

- En tant que développeur, je veux créer des tests unitaires pour chaque classe afin de garantir le bon fonctionnement des fonctionnalités de base.
- Les tests unitaires doivent couvrir des cas tels que l'ajout d'équipements, la mise à jour des informations, la recherche d'équipements, l'enregistrement des locations, etc.
- Les tests unitaires doivent être exécutés automatiquement lors de chaque construction du projet pour assurer la stabilité du code.

### Migration de Base de Données avec Liquibase

- En tant que développeur, je veux utiliser Liquibase pour gérer les changements de schéma de base de données de manière versionnée.
- Chaque nouvelle version de l'application doit être accompagnée d'un script Liquibase pour mettre à jour la base de données existante.
- Les scripts Liquibase doivent être écrits de manière à pouvoir être exécutés automatiquement lors du déploiement de la nouvelle version de l'application.
- Les migrations doivent être testées sur un environnement de test avant d'être appliquées à la base de données de production pour éviter tout impact indésirable.

## Démarrage

Pour commencer avec l'Application Web de Gestion des Stocks RentalHive, suivez ces étapes :

1. **Cloner le Répertoire :**
```bash
   git clone https://github.com/spirithuntt/RentalHive
```
  Construire et Exécuter l'Application :
```bash
   cd RentalHive
   mvn spring-boot:run
```
Exécuter les Tests Unitaires :
   ```bash
mvn test
```
Migration de la Base de Données :

Assurez-vous d'avoir Liquibase installé et configuré.
Exécutez le script de migration Liquibase pour la dernière version.
Accéder à l'Application :

Ouvrez un navigateur web et allez sur http://localhost:8080 pour accéder à l'Application Web de Gestion des Stocks RentalHive.
Maintenant, RentalHive est équipée d'une application web robuste pour gérer efficacement l'inventaire de son matériel de construction.




