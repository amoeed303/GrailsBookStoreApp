package BookStoreBackend

class UserController {

    UserService userService

    def index() {
        def books = userService.getAllBooks()
        render(view: '/User/viewBooks', model: [books: books])
    }
//to be implemented in the next section
//with an update password button in the user view
    def changePassword() {
        def params = request.JSON
        User user = User.findByEmail(params.email)
        if (user) {
            user.password = params.newPassword
            user.save(flush: true)
            render status: 200, text: 'Password changed'
        } else {
            render status: 404, text: 'User not found'
        }
    }
//calls a userService method to buy a book
    def buyBook() {
        //gets hidden parameters as email and bookId to complete purchase
        String email = params.email
        Long bookId = params.bookId as Long
        User user = userService.getUserByEmail(email)
        if (user) {
            userService.buyBook(user, bookId)
            flash.message = 'Book purchased successfully'
            flash.type = 'success'
            session.flashDisplayed = false
            redirect(action: "index")
        } else {
            flash.message = 'User not found unable to but book'
            flash.type = 'error'
            flash.type = 'success'
            redirect(action: "index")
        }

    }

    def purchasedBooks() {
        String email = params.email
        User user = User.findByEmail(email)
        println(user)
        if (!user) {
            render status: 404, text: 'User not found'
            return
        }
        def purchasedBooks = userService.getPurchasedBooks(email)
        if (!purchasedBooks) {
            render status: 404, text: 'No purchased books found'
            return
        }
        render(view: '/User/viewPurchasedBooks', model: [purchases: purchasedBooks])
    }
}