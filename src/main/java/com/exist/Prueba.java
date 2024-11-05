package com.exist;

import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import org.xmldb.api.*;

/**
 * This class demonstrates how to connect to an eXist database using the XML:DB
 * API.
 * It performs an XPath query to retrieve all books within a specific
 * collection.
 */
public class Prueba {
    /**
     * Main entry point for the program. Establishes a connection to the eXist
     * database
     * and executes an XPath query.
     *
     * @param args Command-line arguments (not used).
     * @throws ClassNotFoundException if the database driver class cannot be found.
     * @throws InstantiationException if there is an error instantiating the driver
     *                                class.
     * @throws IllegalAccessException if access to the driver class is denied.
     * @throws XMLDBException         if an XML:DB error occurs.
     */
    public static void main(String args[])
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
        // Define the class name of the eXist database driver
        String driver = "org.exist.xmldb.DatabaseImpl";

        // Dynamically loads the database driver class
        Class cl = Class.forName(driver);

        // Creates a new instance of the database driver
        Database database = (Database) cl.newInstance();

        // Set property to create the database if it does not exist
        database.setProperty("create-database", "true");

        // Register the database with the DatabaseManager
        DatabaseManager.registerDatabase(database);

        // Obtain a reference to the target collection from the eXist database
        Collection col = DatabaseManager.getCollection("xmldb:exist://localhost:8080/exist/xmlrpc/db/Ejercicios",
                "admin", "admin");

        // Retrieve the XPath query service from the collection
        XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");

        // Configure the query service properties for better result formatting
        service.setProperty("pretty", "true"); // Formats output to be more readable
        service.setProperty("encoding", "ISO-8859-1"); // Sets character encoding for results

        // Execute an XPath query to retrieve all <book> elements
        ResourceSet result = service.query("for $b in //libro return $b");

        // Iterate over the query results
        ResourceIterator it = result.getIterator();

        // Loop through the resources, outputting each one’s content
        while (it.hasMoreResources()) {
            Resource resource = it.nextResource();
            // Print the content of each <book> element to the console
            System.out.println(resource.getContent());
        }
    }
}
