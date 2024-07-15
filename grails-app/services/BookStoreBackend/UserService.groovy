package BookStoreBackend

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def getAllBooks() {
        return Book.list();
    }

    def buyBook(User user, Long bookId) {
        Book book = Book.get(bookId)
        if (book) {
            new Purchase(user: user, book: book, purchaseDate: new Date()).save(flush: true)
        } else {
            throw new RuntimeException("Book not found")
        }
    }

    def getPurchasedBooks(String email) {
        User user = User.findByEmail(email)
        if (user) {
            def purchases = Purchase.findAllByUser(user)
            return purchases
        } else {
            []
        }
    }
def getAllUsers() {
        return User.list()
    }

    def getUserByEmail(String email = " ") {
        if (!email.trim()) {
            log.error("Email parameter is empty or null.")
            throw new IllegalArgumentException("Email parameter cannot be empty or null.")
        }

        try {
            User user = User.findByEmail(email)
            log.info("User findByEmail result: $user")
            if (user) {
                return user

            } else {
                log.warn("No user found with email: $email")
                return null
            }
        } catch (Exception e) {
            log.error("Error getting user by email: ${e.message}", e)
            throw new Exception("Error getting user by email: ${e.message}")
        }
    }
}