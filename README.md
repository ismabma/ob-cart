# ob-cart

Había cosas que no me cuadraban en el enunciado y he cambiado:
- Si le pasas un id (En este caso lo he dejado por PathVariable) te enseña un producto, no un carrito, los carritos no tienen id, solo hay un carrito, no puedes tener varios.

- Si quieres añadir productos es un palo estar teniendo que meter la descripcion todo el rato asi que si el producto no existe lo haces por primera vez, luego es solo meter el id y la cantidad. (En ambos casos se hace por RequestBody ya que son mas de un parametro)


## Java version: 17
## Spring version: 2.7.5

