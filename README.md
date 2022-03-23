# digitoVerificador
Lo primero que haré será crear un método de nombre main
Dentro de este método llamaré a una función que se llame "llamarFunciones", que como su nombre indica, se encargará de llamar a todas las funciones del programa
Crearé una función llamada "crearCarrito" y acá definiré un arreglo de n (variable) largo (1 <= n <= 20). Esta función devolverá un arreglo (carrito)
Otra función será asignarPrecioCarrito, este llenará el arreglo con el precio correspondiente a su posición, para esto usaré una variable auxiliar que me ayude a rellenar el arreglo.Recibirá como parametro el arreglo ya creado (carrito )y devolverá un arreglo con valores que parten de 500 y se incrementan en 150 dependiendo de la posición.
La siguiente función será agregarProductos, esta recibirá como parametros el carrito para así crear un arreglo (cantidadDeProductos)del mismo largo que el carrito con valores entre 1 y 15 y multiplicará lo que haya en cada posición del carrito con lo que haya en cantidadDeProductos y retornará un arreglo (preciosCarrito)
Crearé una función que se llame imprimirResultados que recibe como parametro a cantidadTotalDeProductos y llamará a la función imprimirCantidadDeProductos que recibirá como parametro a cantidadTotalDeProductos
La función precioTotalCarrito recibirá como parametro a preciosCarrito y sumará lo que hay en ese arreglo y la función cantidadTotalDeProductos también sumará lo que hay en cantidadDeProductos
Por ultimo, la función imprimirResultados llamará a la función imprimirDetalles, esta recibirá como parametro cantidadDeProductos, preciosCarrito y precioTotalCarrito e imprimirá la cantidad de productos que hay en cada celda con sus respectivos precios y también el precio total.
