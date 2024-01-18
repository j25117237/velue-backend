package com.velue.uti;

public class ImageToBase64Converter {

	/*
	 * public static void main(String[] args) { // String imagePath =
	 * "/path/to/your/image.jpg"; String jdbcUrl =
	 * "jdbc:mysql://localhost:3306/velue"; String username = "root"; String
	 * password = "acsa"; String base64Image = null;
	 *
	 * String imagePath = "d:/images/1432.jpg";
	 *
	 * try { // Read the image file as a byte array File imageFile = new
	 * File(imagePath); byte[] imageData = new byte[(int) imageFile.length()]; try
	 * (FileInputStream fis = new FileInputStream(imageFile)) { fis.read(imageData);
	 * }
	 *
	 * // Convert the byte array to Base64 encoding base64Image =
	 * Base64.getEncoder().encodeToString(imageData);
	 *
	 * // System.out.println("Base64 encoded image:");
	 * //System.out.println(base64Image);
	 *
	 * } catch (IOException e) { e.printStackTrace(); } /// update db //start
	 *
	 *
	 *
	 * String newBase64Image = base64Image; // int productIdToUpdate = 1; // The
	 * product_id of the product to update
	 *
	 * try { // Load the MySQL JDBC driver
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 *
	 * // Establish the database connection Connection connection =
	 * DriverManager.getConnection(jdbcUrl, username, password);
	 *
	 * // Convert the Base64 string to a byte array byte[] newImageData =
	 * Base64.getDecoder().decode(newBase64Image);
	 *
	 * // Prepare the SQL update statement with a parameter for the BLOB String
	 * updateQuery = "UPDATE product SET image = ? "; PreparedStatement
	 * preparedStatement = connection.prepareStatement(updateQuery);
	 *
	 * // Set the BLOB parameter and product_id in the update statement
	 * preparedStatement.setBytes(1, newImageData); // preparedStatement.setInt(2,
	 * productIdToUpdate);
	 *
	 * // Execute the SQL update statement to update the data int rowsAffected =
	 * preparedStatement.executeUpdate();
	 *
	 * // System.out.println("Rows affected: " + rowsAffected);
	 * //System.out.println("Image updated successfully!");
	 *
	 * // Close the resources preparedStatement.close(); connection.close(); } catch
	 * (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
	 *
	 * //end }
	 */
}

