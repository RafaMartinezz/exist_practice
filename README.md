
# eXist Database XML Query Example

This Java project demonstrates how to connect to an eXist XML database using the XML:DB API. It performs an XPath query to retrieve and display all `<book>` entries from a specified database collection. The project provides a clear example of working with eXist databases in Java, covering essential actions such as establishing a database connection, configuring query services, and iterating over XML results.

## Project Structure

- **`Prueba.java`**: The main class responsible for:
  - Setting up the connection to the eXist XML database.
  - Executing an XPath query to retrieve all book records from a specified collection.
  - Iterating over and displaying each book entry found in the query results.

## How It Works

1. **Database Driver Loading**: The program dynamically loads the eXist database driver class (`org.exist.xmldb.DatabaseImpl`).
2. **Database Initialization and Registration**: A new `Database` instance is created and registered with `DatabaseManager`.
3. **Connection to the Collection**: The program connects to a specific collection, `Ejercicios`, in the eXist database using administrative credentials.
4. **XPath Query Execution**: An XPath query service is instantiated, and a query is performed to retrieve all `<book>` elements from the collection.
5. **Result Iteration and Output**: The results of the query are iterated over, and each entry's content is printed to the console.

## Prerequisites

- **eXist-db**: Ensure an eXist XML database instance is running and accessible, and that the database contains a collection (`Ejercicios`) with XML files.
- **Java XML:DB API**: The project relies on the XML:DB API, which is compatible with eXist-db.
- **JAR Files**: Include the eXist-db JAR files in the project's classpath to resolve dependencies for `org.exist.xmldb.DatabaseImpl` and related classes.

## Key Components

- **Connection String**: `xmldb:exist://localhost:8080/exist/xmlrpc/db/Ejercicios` — This specifies the location of the eXist database collection.
- **XPath Query Service**: Used to execute the XPath query to retrieve `<book>` elements.
- **Administrative Credentials**: Used to authenticate and authorize database access (username: `admin`, password: `admin`).

## Error Handling

- The code catches several potential exceptions:
  - `ClassNotFoundException`: If the eXist database driver class is missing.
  - `InstantiationException` and `IllegalAccessException`: If the driver class fails to instantiate.
  - `XMLDBException`: For general XML:DB API errors.

## Example Output

If the database collection contains book entries, running the program will print each book's XML content to the console.

Example:
```xml
<book>
    <title>Sample Book Title</title>
    <author>Author Name</author>
    <year>2022</year>
</book>
```

This output reflects the content of each `<book>` element retrieved from the eXist database.
