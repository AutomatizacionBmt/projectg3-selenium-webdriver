# language: es

Característica: Web UI - Redmine - Users
  Como un usuario,
  Yo deseo crear un nuveo usuario satisfactoriamente

  #TAREA
  #1.- Crear un modelo "RedmineUser" para guardar la información del usuario
  #2.- Mapear todos los elementos en el page object "RedmineUserPage"
  #3.- Crear los métodos en "RedmineUserPage" para crear un usuario y verificar que ha sido creado.
  #4.- Implementar los step definitions en la clase "WebRemineUsersStedDefs"

  @gui
  Escenario: Crear un nuevo usuario satisfactoriamente
    Dado Yo voy a la pagina de login de Redmine
    Y Yo inicio sesion con mis credenciales usuario "user" y password "bitnami1"
    Entonces Yo deberia visualizar en la pagina de inicio mi usuario "user"
    Cuando Yo registro un usuario
      | username      | user          |
      | firstname     | userFirstName |
      | lastname      | userLastName  |
      | email         | @mail.com     |
      | language      | English       |
      | administrator | true          |
      | password      | 12345678      |
    Entonces El usuario fue registrado satisfactoriamente