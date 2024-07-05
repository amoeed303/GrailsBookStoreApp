package BookStoreBackend

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BookSpec extends Specification implements DomainUnitTest<Book> {

     void "test domain constraints"() {
        when:"Valid domain instance is created"
        Book domain = new Book()
        //TODO: Set domain props here
        domain.bookName = "Intro to DataScience"
         domain.bookAuthor = "Abdul Moeed"
          
        then:"Valid boook"
        domain.validate()==true
     }
     void "test domain constraints for bookName"() {
        when:"bookName is null"
        Book domain = new Book()
        domain.bookName = null
        domain.bookAuthor = "Abdul"
         then:"bookName is null"
         domain.validate()==false
         domain.errors['bookName'] == ['Property [bookName] of class [class BookStoreBackend.Book] cannot be null']
        }

        void "test domain constraints for bookAuthor"() {
        when:"bookAuthor is null"
         Book domain = new Book()
         domain.bookName = "Intro to DataScience"
         domain.bookAuthor = null
         then:"bookAuthor is null"  
         domain.validate()==false
         domain.errors['bookAuthor'] == ['Property [bookAuthor] of class [class BookStoreBackend.Book] cannot be null']
        }
}
