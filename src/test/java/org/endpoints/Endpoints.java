package org.endpoints;

public class Endpoints {
	
	/**
	 * @Date 30-05
	 */

	//BASE URL FOR THE PET STORE SWAGGER
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	/**
	 * @Date 30-05
	 */
	//ENDPOINTS FOR THE USER CRUD OPERTAIONS
	
	public static String user_create_url = base_url + "/user";
	public static String user_read_url   = base_url + "/user/{username}";
	public static String user_update_url = base_url + "/user/{username}";
	public static String user_delete_url = base_url + "/user/{username}";
	
	/**
	 * @Date 31-05
	 */
	//ENDPOINTS FOR THE STORE CRUD OPERATIONS
	
	public static String store_create_url = base_url + "/store/order";
	public static String store_read_url   = base_url + "/store/order/{orderId}";
	public static String store_delete_url = base_url + "/store/order/{orderId}";
	
}
