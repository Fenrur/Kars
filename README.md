# Kars 🏎️

## Explication du projet

Le projet Kars est un projet pédagogique réalisé dans le cadre du cours **optimisation de base de données**

## Decomposition du projet

### Frontend

Application frontend en Next.js

#### Fichier d'environement

Pour démarrer l'application, il faut créer un fichier `.env` à la racine du projet frontend.

```
BACKEND_URL=URL HTTP DU BACKEND
```

#### Installer les dépendances

```bash
npm install
```

#### Démarrer en mode developpement

```bash
npm run dev
```

### Backend

Application en Kotlin, développé avec le Framework quarkus et une base de données PostgreSQL.

Nous avons choisis [JOOQ](https://www.jooq.org) pour le system de requêtage de la base de données.
Il nous offre une interface de requetage similaire aux SQL natif, en plus sécurisé et type-safe.
Ce qui nous permets d'optimiser nos requêtes et de les rendre plus robustes car nous en avons le controle total.

#### Génération des classes JOOQ

##### Prérequis

Avoir un context docker démarré

```bash
gradlew jooqCodegen
```

#### Démarrer l'application en mode développement

```bash
gradlew quarkusDev
```