package BookStoreBackend

import grails.gorm.transactions.Transactional
@Transactional
class UserService {

     def listBooks() {
        Book.findAll()
    }

    def buyBook(User user, Long bookId) {
        Book book = Book.get(bookId)
        if (book) {
            new Purchase(user: user, book: book, purchaseDate: new Date()).save(flush: true)
        }else{
            throw  new RuntimeException("Book not found")
        }
    }

    def getPurchasedBooks(String email) {
        User user = User.findByEmail(email)
        if (user) {
            Purchase.findAllByUser(user).collect { it.book }
        } else {
            []
        }
    }
}