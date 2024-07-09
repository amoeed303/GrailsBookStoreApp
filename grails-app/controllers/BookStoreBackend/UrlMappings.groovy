package BookStoreBackend

class UrlMappings {
    static mappings = {


        "/"(controller: "login", action: "index")
        "/authenticate"(controller: "login", action: "authenticate")
        "/logout"(controller: "login", action: "logout")
        // Admin routes
        "/admin"(controller: "admin", action: "index")
        "/admin/addUser"(controller: "admin", action: "addUser")
        "/admin/addBook"(controller: "admin", action: "addBook")
        "/admin/listUsers"(controller: "admin", action: "listUsers")
        "/admin/listBooks"(controller: "admin", action: "listBooks")
        //User Routes
        "/User"(controller: "user", action: "index")
        "/User/viewBooks"(controller: "user", action: "viewBooks")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
