Fonctionnement du projet

--------------------------------
Menu principal

Tout d'abord, nous avons 3 options principales disponibles pour l'utilisateur: "Connexion",
"S'inscrire en tant que résident" et "S'inscrire en tant que consommateur". Le choix est pris en considération en tapant
en entrée le numéro correspondant.

Si on tape "1", on accède à "Connexion", option pour laquelle l'utilisateur doit insérer son e-mail puis mot de passe
pour que le programme vérifie si un profil correspond existe. Si c'est le cas, il sera dirigé vers le menu du résident
ou consommateur dépendamment de son statut.

De la perspective d'un résident, si on tape "2", on accède à "S'inscrire en tant que résident" et les informations
suivantes sont exigées:
    -Nom
    -Prénom
    -Mot de passe
    -Numéro de telephone
    -Email
    -Adresse
    -Code unique fourni par la municipalité

Le dossier de l'utilisateur sera ensuite ajouté à une liste d'utilisateurs en attente de validation, puis il sera
redirigé vers le menu principal.

De la perspective d'un consommateur, si on tape "2", on accède à "S'inscrire en tant que consommateur" et les
informations suivantes sont exigées:
-Nom
-Adresse
-Mot de passe
-Email
-Numero de telephone
-Activiter
-Capaciter de traitment
-Le code unique fourni par la municipaliter

Le dossier de l'utilisateur sera ensuite ajouté à une liste d'utilisateurs en attente de validation, puis il sera
redirigé vers le menu principal.

-----------------------------
Menu du consomateur

On a le choix entre 2 actions étant "Revenir au menu principal" et "Notifier les résidents" auxquelles nous pouvons
accéder en tapant le numéro corespondant. Si on tape "0", l'utilisateur revient au menu principal et si on tape "1",
un message est demandé en entrée afin qu'il soit envoyé aux résident en guise de notification.

-----------------------------
Menu du résident

Le menu du résident offre les 7 actions suivantes:

    -Si on tape "0", on accède au menu principal
    -Si on tape "1" on accède à l'option "Enregistrer un bac" où l'on demande les informations suivantes:
        -Code qr
        -Adresse
        -Date d'émission
        -Le type du bac
    Le bac est ensuite ajouté puis enregistré à la liste.

    -Si on tape "2", on accède à "Afficher l'état des mes bacs" affichant le type, l'ID et le niveau de remplissage de
    chaque bac possédé par le résident.

    -Si on tape "3", on accède à la section "Métriques" où toute la base de données du contenu des bacs du résident est
    pré-calculées
Si on tape 4 on accede "Voir l'état de traitement des déchets municipaux"
    pour chaque lots de dechet en traitment on afiche:
        -le Numero
        -le type de dechet
        -Date de passage des camions
        -Staut
        -les consomateur qui rentre dans le processus
Si on tape 5 on accede "Signaler un problème à MunicipInfo"
    vous demande de rentrer un message qui seras transmis
Si on tape 6 on accede "Trouver un consommateur"
    un nouveaus menus s'affiche avec 3 options
        Si on tape 0 on accede "Retour menu Resident"
            Retourne au menus de resident
        Si on tape 1 on accede "Chercher pas nom"
            si on trouve le consomateur on afiche sont nom
            puis un menus s'afiche 
                -soit on tape 0 pour revenir au menu resident 
                -soit on tape 1 pour donner une note
        Si on tape 2 on accede "Chercher par type"
            Afiche une list des nom des consomateur qui traite se type de dechet



