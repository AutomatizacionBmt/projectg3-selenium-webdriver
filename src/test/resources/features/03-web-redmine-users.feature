# language: es

Característica: Web UI - Redmine - Users
  Como un usuario,
  Yo deseo crear un nuveo usuario satisfactoriamente

  #TAREA
  #1-  Crear el escenario de prueba -> OK
  #2.- Crear un modelo "RedmineUser" para guardar la información del usuario -> OK
  #3.- Mapear todos los elementos en el page object "RedmineUserPage" -> OK
  #4.- Crear los métodos en "RedmineUserPage" para 'crear un usuario' (OK) y verificar que ha sido creado (OK).
  #5.- Implementar los step definitions en la clase "WebRemineUsersStepDefs"

  @gui
  Escenario: Crear un nuevo usuario satisfactoriamente
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | username      | user          |
      | firstname     | userFirstName |
      | lastname      | userLastName  |
      | email         | @mail.com     |
      | language      | English       |
      | administrator | false         |
      | password      | 12345678      |
    Entonces El usuario fue registrado satisfactoriamente
    Y el usuario deberia visualizarce en la lista de usuarios

  @gui
  Escenario: Crear un nuevo usuario y eliminarlo
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Y Yo registro un usuario
      | username      | user          |
      | firstname     | userFirstName |
      | lastname      | userLastName  |
      | email         | @mail.com     |
      | language      | English       |
      | administrator | false         |
      | password      | 12345678      |
    Y El usuario fue registrado satisfactoriamente
    Cuando Yo elimino el usuario de la lista de usuarios
    Entonces el usuario no deberia visualizarce en la lista de usuarios

  @gui
  Escenario: Crear un nuevo usuario y no eliminarlo
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Y Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Y Yo registro un usuario
      | username      | user          |
      | firstname     | userFirstName |
      | lastname      | userLastName  |
      | email         | @mail.com     |
      | language      | English       |
      | administrator | false         |
      | password      | 12345678      |
    Y El usuario fue registrado satisfactoriamente
    Cuando Yo no elimino el usuario de la lista de usuarios
    Entonces el usuario deberia visualizarce en la lista de usuarios