# juegos-back
Persistencia y reglas de los juegos

## API
Las reglas de los juegos se exponen a través de un servicio desplegado en Heroku

* URL base: https://juegos-back-b39a6e4b40aa.herokuapp.com
* Ruta para Espada, Escudo o Dragón: /eed/fight?userChoice=DRAGON
  * Cada elección del juego se identifica por una palabra, por lo que los posibles valores de userChoice son:
  * SWORD para espada que mata a DRAGON
  * SHIELD para escudo que vence a SWORD
  * DRAGON para dragón que destruye al escudo
* Ruta para Lotería: /lottery?attempt=22&digitLength=2
  * attempt es el número de la suerte, el que elige el usuario como número ganador y debe ser de longitud digitLength
  * Por ejemplo: digitLength=2 generará aleatoriamente un número de dos dígitos
  * Si attempt=22 y el número generado es 22, entonces fue el número ganador
* Ruta para Adivina el número: /guess?attempt=0&maxNum=1
  * attempt es el número elegido por el usuario
  * El número por adivinar se generará aleatoriamente y estará entre 0 y maxNum
  * Por ejemplo: maxNum=1000, por lo tanto el número aleatorio estará entre 0 y 1000
  * Si attempt=700 y es igual al número generado, el usuario habrá adivinado correctamente
