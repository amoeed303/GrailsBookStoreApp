package BookStoreBackend

import grails.plugins.mail.MailService

class AdminController {
    AdminService adminService
    MailService mailService

    def index() {
        render(view: "/admin/index")
    }


    def addUser() {
        def firstName = request.getParameter("firstName")
        def lastName = request.getParameter("lastName")
        def email = request.getParameter("email")
        def phone = request.getParameter("phone")
        def password = request.getParameter("password")
        if (firstName && lastName && email && phone && password) {
            try {
                adminService.addUser(firstName, lastName, email, phone, password)
                flash.message = "User added successfully."
                //send email to newly created user with login credentials
                //to be sent
                //email and password
                //app password :https://myaccount.google.com/apppasswords?pli=1&rapt=AEjHL4OOWj0KAyfpqRfRkR-X8U2wI9YI0x7s1lTGq5L_5bjftF1PtXmFpMCtGLHrmNeP1s35NwXFIj31W0-zsodiHbAG_5szI-Oyy6KI4vJtWBE_01Y1o6M
                mailService.sendMail {
                    to email
                    subject "Successful Account Creation"
                    body "Your account has been created successfully with email: $email and password: $password"
                }
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