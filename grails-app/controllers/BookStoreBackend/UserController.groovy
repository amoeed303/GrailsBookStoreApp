package BookStoreBackend
import grails.converters.JSON

class UserController {

   UserService userService

def index(){
    render(view: "/User/index")
}

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
    def viewBooks() {
       def books = userService.getAllBooks()
        render (view: '/User/viewBooks', model: [books: books])
    }

    def buyBook() {
        def params = request.JSON
        User user = User.findByEmail(params.email)
        if (user) {
            userService.buyBook(user, params.bookId)
            render status: 200, text: 'Book purchased'
        } else {
            render status: 404, text: 'User not found'
        }
    }

    def purchasedBooks() {
        def params = request.JSON
        User user = User.findByEmail(params.email)
        if (!user) {
            render status: 404, text: 'User not found'
            return
        }
        render userService.getPurchasedBooks(params.email) as JSON
    }
}