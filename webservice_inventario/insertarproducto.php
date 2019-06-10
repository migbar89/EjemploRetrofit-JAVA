<?php
    //echo 'prueba de servicio web';
    //open connection to mysql db

    $connection = mysqli_connect("localhost","root","","inventario") or die("Error " . mysqli_error($connection));
    //

    if ($_SERVER['REQUEST_METHOD'] == 'POST')
    {

        //$json_str = file_get_contents('php://input');

        //$json_obj = json_decode($json_str,true);

        //echo $json_obj;

        $nombre= $_POST['nombre'];
        $precio= $_POST['precio'];
        $categoria= $_POST['categoria'];



        $sql = "INSERT INTO producto (nombre, precio,categoria)
         VALUES ('$nombre','$precio', '$categoria')";
         if( $connection->query($sql)==true)
                 {
                     echo 'registro insertado correctamente';
                 }
                  else
                     echo 'Error al insertar';


       }

  header("Status: 200");
http_response_code(200);
    mysqli_close($connection);



 ?>
