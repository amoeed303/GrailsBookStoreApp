package BookStoreBackend
import grails.converters.JSON

class UserController {

   UserService userService
 def login() {
        def params = request.JSON
     boolean  isAdmin=params.isAdmin?:false
     if(isAdmin){
         if(params.email=="admin" && params.password=="admin123"){
             render status: 200, text: 'Admin.gsp Login successful'
     }else{
            render status: 401, text: 'Admin.gsp Login failed'
         }
         }
     else {
         User user = User.findByEmailAndPassword(params.email, params.password)
         if (user) {
             render status: 200, text: 'User Login successful'
         } else {
             render status: 401, text: 'Login failed'
         }
     }
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
        render userService.listBooks() as JSON
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