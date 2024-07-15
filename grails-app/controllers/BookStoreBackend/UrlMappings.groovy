package BookStoreBackend

class UrlMappings {
    static mappings = {

        //Authentication Routes
        "/"(controller: "login", action: "index")
        "/authenticate"(controller: "login", action: "authenticate")
        "/logout"(controller: "login", action: "logout")
        // Admin Routes
        "/admin"(controller: "admin", action: "index")
        "/admin/addUser"(controller: "admin", action: "addUser")
        "/admin/addBook"(controller: "admin", action: "addBook")
        "/admin/listUsers"(controller: "admin", action: "listUsers")
        "/admin/listBooks"(controller: "admin", action: "listBooks")
        //User Routes
        "/books"(controller: "user", action: "index")
        "/books/buyBook"(controller: "user", action: "buyBook")
        "/books/purchasedBooks"(controller: "user", action: "purchasedBooks")
        //General Routes Error and information Routes
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
