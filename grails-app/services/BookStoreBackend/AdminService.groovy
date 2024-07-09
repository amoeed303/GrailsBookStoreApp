package BookStoreBackend

import grails.gorm.transactions.Transactional
@Transactional
class AdminService {

     def addUser(String firstName=" ", String lastName=" ", String email="test@gmail.com", String phone=" ",  String password=" ") {
         try{
             log.info("Adding user: $firstName $lastName $email $phone $password")
             new User(firstName: firstName, lastName: lastName, email: email, phone: phone, password: password).save(flush: true, failOnError: true);
         }
         catch (Exception e) {
             log.error("Error adding user: ${e.message}")
             throw new Exception("Error adding user: ${e.message}")
         }

    }

    def addBook( String bookName=" ", String bookAuthor=" ") {
        try{
            log.info("Adding book: $bookName $bookAuthor")
            new Book(bookName: bookName, bookAuthor: bookAuthor).save(flush: true, failOnError: true)
        }
        catch (Exception e) {
            log.error("Error adding book: ${e.message}")
            throw new Exception("Error adding book: ${e.message}")
        }

    }
    def getAllUsers() {
         return User.list()
    }
    def getAllBooks() {
        return Book.list()
    }
}