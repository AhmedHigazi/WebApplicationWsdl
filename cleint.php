  <html>
<body>
  <div style="height:30%; margin-top:10% ;width: 30% ; margin-left:300px ; background-color: blue" >
    <br><br><br>
    <form action="" method="GET" >
      <label for="type_id">Search by ID : </label>
      <input type="radio" name="type" id="type_id" value="id"><tr>
      <label for="type_name">Search by Named : </label>
      <input type="radio" name="type" id="type_name" value="Name">
      <label for="type_name">All : </label>
      <input type="radio" name="type" id="type_all" value="All">
      <br><br>
      <input type="text" name="key">
      <input type="submit">
  </form>          
</div>         
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
<?php
  require_once ( "lib/nusoap.php" ) ;
  $wsdl_url ="http://localhost:8080/bakryWebApplication/NewWebService?WSDL";
  $client = new soapClient($wsdl_url , TRUE);
    if(isset($_GET['type'])){
      if($_GET['type'] == 'id'){
        $id = $_GET['key'];
        $param = array("id" => $id);
        $result = $client->call("getperson" , $param);
       // print_r($result);
       $person = array_shift($result);
       echo "
       <table border='1'>
         <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Age</th> 
         </tr>
        <tr>
            <td>".$person['id']."</td>
            <td>".$person['Name']."</td>
            <td>".$person['Address']."</td>
            <td>".$person['Age']."</td>
         </tr>
       </table>
       ";
    }else if($_GET['type'] == 'Name'){
        $Name = $_GET['key'];
        $param = array("Name" => $Name);
        $result = $client->call("getpersons" , $param);
       // print_r($result);
        
        echo "
       <table border='1'>
         <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Age</th> 
         </tr>";
         foreach($result['return'] as $person){
        echo "<tr>
            <td>".$person['id']."</td>
            <td>".$person['Name']."</td>
            <td>".$person['Address']."</td>
            <td>".$person['Age']."</td>
         </tr>";

       }
        echo "</table>";
    }
    else if($_GET['type'] == 'All'){
        $Name = $_GET['key'];
        $result = $client->call("getAll");
       // print_r($result);
        
        echo "
       <table border='1'>
         <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Age</th> 
         </tr>";
         foreach($result['return'] as $person){
        echo "<tr>
            <td>".$person['id']."</td>
            <td>".$person['Name']."</td>
            <td>".$person['Address']."</td>
            <td>".$person['Age']."</td>
         </tr>";

       }
        echo "</table>";
    }
  }
 
?>                                              