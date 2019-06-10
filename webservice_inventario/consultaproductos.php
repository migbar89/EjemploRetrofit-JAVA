<?PHP



$connection = mysqli_connect("localhost","root","","inventario") or die("Error " . mysqli_error($connection));
//$connection = mysqli_connect("localhost","root","root","pagos-prestamista") or die("Error " . mysqli_error($connection));


  $getData="SELECT * FROM producto";
  //$getData="SELECT * FROM appprestamos.prestamo p inner join cliente c on c.clienteid=p.cliente_clienteid where activo=1; ";


  //echo 'consulta';
    $qur = $connection->query($getData);
    $cantidad=0;

    while($r = mysqli_fetch_assoc($qur))
    {
      $id=$r['id'];
      $nombre=$r['nombre'];
      $precio=$r['precio'];
      $categoria=$r['categoria'];


        $msg[] = array('id'=>$id,
        'nombre'=>$nombre,
        'precio'=>$precio,
        'categoria'=>$categoria




        );

    }
    $json = $msg;

    header('content-type: application/json');
    echo json_encode($json);




    @mysqli_close($conn);



?>
