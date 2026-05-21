// Contador de productos agregados al carrito
let totalCarrito = 0;


// Se ejecuta cada vez que el usuario cambia el valor del <select>
function filtrarMascotas() {
  // Obtiene el elemento <select> del HTML
  const selector = document.getElementById('filtro-especie');

  // Lee la opción que eligió el usuario, por ejemplo: "perro", "gato", "todas"
  const valorElegido = selector.value;

  // Objeto que traduce el valor interno al texto visible en pantalla
  const textos = {
    todas:    'Todas las mascotas',
    perro:    'Perros',
    gato:     'Gatos',
    erizo:    'Erizos',
    pudu:     'Pudúes',
    pinguino: 'Pingüinos'
  };

  // Actualiza el texto del <span id="texto-mostrando"> según lo que eligió el usuario
  // textContent cambia el texto sin interpretar etiquetas HTML
  document.getElementById('texto-mostrando').textContent = textos[valorElegido];

  // querySelectorAll devuelve todas las tarjetas de mascota como una lista
  const tarjetas = document.querySelectorAll('.tarjeta-mascota');

  // forEach recorre cada tarjeta de la lista
  // En cada vuelta, "tarjeta" representa una tarjeta distinta
  tarjetas.forEach(function(tarjeta) {

    // dataset.tipo lee el atributo data-tipo que pusimos en el HTML
    // Por ejemplo: <div data-tipo="perro"> → tarjeta.dataset.tipo === "perro"
    if (valorElegido === 'todas' || tarjeta.dataset.tipo === valorElegido) {
      tarjeta.classList.remove('oculta'); // la muestra
    } else {
      tarjeta.classList.add('oculta'); // la oculta
    }
  });
}


// Se ejecuta al hacer click en un botón "Adoptar"
// Recibe el id de la mascota y el botón que fue clickeado
function adoptar(id, boton) {

  // Cambia el texto del botón
  boton.textContent = 'Adoptado';

  // classList.add agrega una clase CSS al elemento sin borrar las que ya tiene
  // La clase .adoptado está en el CSS y pone el botón gris
  boton.classList.add('adoptado');

  // Busca el contenedor del avatar por su id: "avatar-1", "avatar-2", etc.
  const avatar = document.getElementById('avatar-' + id);

  // Agrega la clase .adoptado al avatar, esto activa el overlay gris con el corazón
  avatar.classList.add('adoptado');

  // Agrega la clase .saltando, que en el CSS mueve el avatar hacia arriba con translateY
  avatar.classList.add('saltando');

  // setTimeout espera 200ms y luego quita la clase .saltando
  // Como el CSS tiene transition, el avatar baja solo de forma suave
  // 200ms = 0.2 segundos
  setTimeout(function() {
    avatar.classList.remove('saltando');
  }, 200);
}


// Se ejecuta al hacer click en "Agregar al carrito"
function agregarAlCarrito() {

  // Suma 1 al total
  totalCarrito++;

  // Busca el elemento del contador en el header y actualiza el número visible
  const contador = document.getElementById('contador-carrito');
  contador.textContent = totalCarrito;
}


// Se ejecuta al hacer click en "Donar al Refugio"
// alert() abre un cuadro de diálogo nativo del navegador con el mensaje
// \n es un salto de línea dentro del mensaje
function donar() {
  alert('¡Gracias por donar a Patitas a la Obra! 🐾\nTu generosidad ayuda a nuestras mascotas.');
}