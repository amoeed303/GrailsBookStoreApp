package BookStoreBackend

import grails.converters.JSON

class UserController {

    UserService userService

    def index() {
        def books = userService.getAllBooks()
        render(view: '/User/viewBooks', model: [books: books])
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


    def buyBook() {
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
            flash.type='error'
            flash.type = 'success'
            redirect(action: "index")
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