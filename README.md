# TP1_HTTPServlet
<div style="text-align:center;">
<img src="https://cdn.educba.com/academy/wp-content/uploads/2022/09/Servlet-JSP.jpg.webp" alt="Logo Markdown" width="800" height="500">
</div>

### Synthèse: 

Dans ce TP on a travailler un système de lotterie qui permet de donner des gains aux utilisateurs qui saisissent leurs noms en clavier, on stocke les résultats dans notre base de données ce qui va nous permettre de consulter les résultats.

On a construit une blacklist pour que les utilisateurs qu'elle contient seront empêchés d'accéder aux services de l'application. 

Si l'utilisateur entre un nom plusieurs fois, le gain lui est associé se met à jour à chaque fois.

L'utilisateur a la possibilité de supprimer un nom de la base de donnée.

Ce qu'on a vu dans ce TP: 

- Utiliser l'outil JDBC afin de stocker les résultat dans notre base données MySQL.
- Créer l'application avec les deux outils JSP et HTML.
- Implémenter et utiliser tous les méthodes HTTPServlet.
- Gérer les erreurs 4xx et 5xx en ajoutant des balises dans le fichier web.xml.

### Déploiement du projet: 
Pour Déployer ce projet vous dever créer un projet web dans votre IDE. 

- **la servlet** vous devez la mettre dans `/src/main/java`
- les fichiers **html et jsp** doivent être mis dans `/src/main/webapp`
- et le fichier **web.xml** doit être mis dans `/src/main/webapp/WEB-INF`
- N'oubliez pas que vous devez avoir MySQL et mysql connector et que vous devez adapter cette ligne
   `Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","2003KAWTAR");` dans la servlet au nom de votre database, votre nom d'utilisateur et votre password.
