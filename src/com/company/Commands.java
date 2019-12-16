package com.company;

/**
 * Class qui gère les commandes
 */

public class Commands {
//    [#1] help
//- cette commande doit afficher toutes les commandes possibles de votre application ainsi que le formalisme (décrit ci-dessous pour chaque commande)
//
//[#2] exit
//- cette commande permet de sortir de la boucle infinie de votre application, et donc de terminer son exécution. C'est grâce à cette commmande exit que vous pouvez quitter votre application normalement.
//
//
//
//            [#3] adduser <firstname> <lastname> <day> <month> <year>
//- La commande doit créer en mémoire un nouvel utilisateur. Un utilisateur devra être considéré comme déjà existant si le nom ET le prénom d'un utilisateur correspondent parfaitement au nom ET prénom dans la commande. Dans ce cas un message d'erreur affiche que l'utilisateur existe déjà.
//            - La commande doit vérifier que le jour de naissance est entre 1 et 31 (on ne vérifiera pas les dates comme le 29 février;) ), que le mois est entre 1 et 12.
//            - La commande vérifiera également que les 3 derniers paramètres sont bien des valeurs numériques entières, sinon affichera un message d'erreur.
//
//            [#4] edituser <firstname> <lastname>
//- la commande recherche un utilisateur avec exactement le patronyme rentré. Si l'utilisateur existe, alors la commande demande le nouveau nom (si on entre une chaine vide, alors pas de changement de nom), demande ensuite le nouveau prénom (si chaine vide, pas de changement) et va demander ensuite chaque champ du jour, mois, année de naissance (toujours avec la possibilité de ne pas changer la valeur en appuyant sur entrée pour laisser une chaine vide).
//            - la commande va ensuite vérifier les nouvelles informations entrées (comme le fait adduser) et enregistrer les modifications de l'utilisateur DANS LE MEME OBJET (on modifie l'utilisateur, on n'en créé pas de nouveau). SI une erreur est survenue dans la saisie des nouvelles valeurs (ex : le nouveau nom et le nouveau prénom existent deja, ou bien une nouvelle date de naissance qui n'est pas un entier) alors on ne modifie pas l'utilisateur et on affiche un message d'erreur.
//- si l'utilisateur recherché n'existe pas dans la liste, alors on affiche un message d'erreur.
//            - si l'utilisateur est en cours d'emprunt, alors on ne pourra pas le modifier et un message d'erreur sera affiché
//
//            [#5] removeuser <firstname> <lastname>
//- cette commande recherche un utilisateur avec le meme nom ET prénom rentrés et va le supprimer de la liste.
//- si l'utilisateur recherché n'existe pas, alors on affiche un message d'erreur comme quoi il est introuvable.
//            - si l'utilisateur existe, il est supprimé de la liste en mémoire, et on affiche un message de réussite de l'effacement.
//- si l'utilisateur est en cours d'emprunt de livre, alors l'effacement de cet utilisateur ne pourra pas se faire et un message d'erreur sera affiché
//
//[#6] listusers
//- affiche tous les utilisateurs
//
//
//
//[#7] addbook <title> <ref> <year> <publisher>
//- cherche d'abord un livre qui porte la meme référence (ou le même titre ET la même année ET le même distributeur). Si un livre avec la meme référence (ou le même titre ET la même année ET le même éditeur) existe deja dans la mémoire, alors on affiche un message d'erreur (avec les infos du livre existant par exemple)
//
//[#8] editbook <ref>
//- cette commande va rechercher une référence de livre dans les données et si elle le trouve va demander de remplacer toutes les infos qui y sont liées (comme dans la commande edituser).
//            - si la référence de livre n'est pas trouvée, alors on affiche un message d'erreur.
//- pour chaque champ de valeur, on peut laisser une chaine vide pour indiquer qu'on ne change pas la valeur (comme expliqué dans la commande edituser).
//
//            [#9] removebook <ref>
//- cette commande recherche une référence de livre et la supprime de la liste en mémoire.
//- si la référence n'est pas trouvée, un message d'erreur s'affiche.
//            - si la référence existe, il faut vérifier que personne n'a actuellement emprunté le livre. Si c'est le cas, un message d'erreur affichera que ce livre ne peut pas être supprimé car il est en cours d'emprunt.
//
//[#10] listbooks
//- affiche tous les livres
//
//
//
//[#11] borrowbook <firstname> <lastname> <ref>
//- cette commande prend en paramètre le prénom et le nom d'un utilisateur ainsi que la référence du livre à emprunter
//            - si l'utilisateur n'existe pas on affiche une erreur.
//            - si la référence du livre n'existe pas on affiche une erreur.
//            - si le livre a déjà été emprunté par qqun on affiche une erreur.
//- dans tous les autres cas, on stocke l'emprunt de ce livre par cet utilisateur avec la date du jour (mettre une valeur aléatoire pour le jour, le mois et l'année histoire d'avoir des dates différentes par emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt)
//
//            [#12] returnbook <ref>
//- cette commande prend en paramètre la référence d'un livre
//            - si cette référence n'existe pas, alors on affiche une erreur
//            - si ce livre n'a pas été emprunté, on affiche une erreur
//            - si ce livre est actuellement emprunté, alors on met a jour l'objet emprunt associé pour mettre la date du rendu (mettre une date aléatoire mais qui soit supérieure à la date d'emprunt)
//            - afficher le récapitulatif de l'emprunt (utilisateur, ref livre, date d'emprunt, date de rendu)
//
//            [#13] listborrows
//- cette commande affiche la liste des emprunts
//- vous êtes libres du formalisme d'affichage mais toutes les informations doivent apparaitre
//            - nom et prénom de l'utilisateur, titre du livre + référence (il faut donc aller chercher le titre à partir de la référence stockée dans l'emprunt), date de début d'emprunt, date de rendu ou vide si pas encore rendu.
//
//
//
//            [#14] save
//- cette commande va sauvegarder toutes vos données liés aux utilisateurs, livres et emprunts sur le disque dur dans des fichiers.
//- vous êtes libres de sauvegarder un seul fichier qui contient toutes les données ou bien un fichier par utilisateur, un fichier par livre, un fichier par emprunt, ou bien toute combinaison intermédiaire.
//- le format des données à l'intérieur des fichiers peut etre du texte pur ou tout autre format qui vous semble plus pratique à manipuler.
//            - vous aurez un bonus sur l'évaluation si vous sauvegardez dans vos fichiers les objets RAM sérialisés (cf. sérialisation et désérialisation des objets Java)
//
//            [#15] restore
//- cette commande va détecter la présence des fichiers sauvegardés précédemment (si ils existent) et va les ouvrir en lecture et récupérer les informations contenues dedans pour créer de nouveaux objets en mémoire (utilisateur, livre, emprunt).
}
