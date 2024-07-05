package BookStoreBackend




class AdminController {
  AdminService adminService
def index(){
    render(view: "/admin/index")
}
    def addUser(){

            def firstName = request.getParameter("firstName")
            def lastName = request.getParameter("lastName")
            def email = request.getParameter("email")
            def phone = request.getParameter("phone")
            def password = request.getParameter("password")
        if(firstName&&lastName&&email&&phone&&password){
            try{
                adminService.addUser(firstName, lastName, email, phone,password)
                flash.message = "User added successfully."
                redirect(action: 'listUsers')
            } catch (Exception e) {
                // Handle any exceptions thrown by adminService.addUser()
                render status: 500, text: "Error adding user: ${e.message}"
            }
        } else {
            // Render the form view
            render(view: '/admin/addUser')
        }
    }



    def addBook() {
        def bookName = request.getParameter("bookName")
        def bookAuthor = request.getParameter("bookAuthor")
        if (bookName && bookAuthor) {
            try {
                adminService.addBook(bookName, bookAuthor)
                flash.message = "Book added successfully."
                redirect(action: 'listBooks')
            } catch (Exception e) {
                render status: 500, text: "Error adding book: ${e.message}"
            }
        } else {
            // Render the addBook form view
            render(view: '/admin/addBook')
        }
    }
    def listUsers() {
        def users = adminService.getAllUsers()
        render(view: '/admin/listUsers', model: [users: users])
    }

    def listBooks() {
        def books = adminService.getAllBooks()
        render(view: '/admin/listBooks', model: [books: books])
    }
}