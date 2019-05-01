<?php
require_once('connectDB.php');
class Person{
	// Array fields
	const ID = 0;
	const CREATED_DATE = 1;
	const MODIFIED_DATE = 2;
	const USERNAME = 3; 
	const FIRST = 4; 
	const LAST = 5; 
	const PASSWORD = 6; 

	protected $table_name = 'person'; 
	protected $data_array = array(); 
	protected $db_data_types = array(); 
	protected $db_field_names = array(); 
	protected $is_new = true; 

	public function __construct(){
		$this->data_array[self::ID] = ''; 
		$this->data_array[self::CREATED_DATE] = 'now()';
		$this->data_array[self::MODIFIED_DATE] = 'now()'; 
		$this->data_array[self::USERNAME] = ''; 
		$this->data_array[self::FIRST] = ''; 
		$this->data_array[self::LAST] = '';
		$this->data_array[self::PASSWORD] = ''; 

		$this->db_data_types[self::ID] = 'int'; 
		$this->db_data_types[self::CREATED_DATE] = 'datetime';
		$this->db_data_types[self::MODIFIED_DATE] = 'datetime';
		$this->db_data_types[self::USERNAME] = 'text';
		$this->db_data_types[self::FIRST] = 'text'; 
		$this->db_data_types[self::LAST] = 'text'; 
		$this->db_data_types[self::PASSWORD] = 'text';

		$this->db_field_names[self::ID] = 'id';
		$this->db_field_names[self::CREATED_DATE] = 'created_date';
		$this->db_field_names[self::MODIFIED_DATE] = 'modified_date';
		$this->db_field_names[self::USERNAME] = 'username'; 
		$this->db_field_names[self::FIRST] = 'first';
		$this->db_field_names[self::LAST] = 'last'; 
		$this->db_field_names[self::PASSWORD] = 'password'; 
	}

	public function setValues($data_array){

	}

	public function updateRecord(){

		

		// // Generate field(s) str clause
		// foreach ($this->db_field_names as $key => $field_name) {
		// 	$fields .= $field_name

		// }
		// //store information in database
		// $sql = "INSERT INTO mindfulness ($dbFields)
		// VALUES ($values)";

		// //Example:
		// // $sql = "INSERT INTO mindfulness (firstname, lastname, email)
		// // VALUES ('John', 'Doe', 'john@example.com')";


		// if ($conn->query($sql) === TRUE){

		// }
	}

	public function recordExists($id){
		// check if record exists
		$sql = "SELECT * FROM $this->table_name WHERE id=$id";

		$mySQLResult = $conn->query($sql);
		print_r($mySQLResult);

	}
}
?>