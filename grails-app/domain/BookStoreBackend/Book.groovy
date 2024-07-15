package BookStoreBackend

class Book {
   
    String bookName
    String bookAuthor

    static constraints = {

        bookName nullable: true, blank: false,unique: true
        bookAuthor nullable: true, blank: false

    }
    static mapping = {

version false


    }
}

