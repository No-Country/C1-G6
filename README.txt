Cliente:
Subir proyecto a github:
	1) git init
	2) git remote add origin https://github.com/[github-user-name]/[repository-name].git
	3) git branch -M main
	4) git add .
	4) git commit -m "****"
	5) git push -u origin main

Deploy del proyecto:
	1) npm install angular-cli-ghpages
	2) ng add angular-cli-ghpages
	3) ng deploy --base-href=https://[github-user-name].github.io/[repository-name]/

Servidor:
Crear repositorio en heroku:
  1-Entrar a https://www.heroku.com/
  2-Registrarse
  3-Click en nuevo para crear un repositorio
  4-Ir a configuración>revelar variables de configuración y añadir las siguientes:
    DATABASE_URL: mysql://link de la base de datos?zeroDateTimeBehavior=convertToNull
    USER : usuario base de datos
    PASSWORD : contraseña
Deploy de la api:
  Siga las intrucciones que aparecen en deploy>heroku git, en caso de que no sean claras:
   1-Descargar Heroku CLI
   2-Cambiar el nombre de la carpeta OrderUp dentro de server para que sea igual al nombre del repositorio
   3-Abrir git bash en la carpeta 
   4-heroku login
   5-git init
   6-git add .
   7-git commit -m "****"
   8- heroku git:remote -a repositorio
   9-heroku buildpacks:set heroku/java
   10-git push heroku master


