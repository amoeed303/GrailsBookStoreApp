package BookStoreBackend

class LoginController {
    UserService userService
    Admin admin = new Admin()

    def index() {
        render(view: "/login/login")
    }

    def authenticate() {
        String email = request.getParameter("email")
        String password = request.getParameter("password")
        boolean isAdmin = request.getParameter("isAdmin") ? Boolean.valueOf(request.getParameter("isAdmin")) : false
        if (isAdmin) {
            if (email == admin.email && password == admin.password) {
                session.isAdmin = true
                session.adminName = admin.name
                redirect(controller: "admin", action: "index")
            } else {
                flash.message = "Invalid admin credentials"
                redirect(action: "index")
            }
        } else {
            User user = userService.getUserByEmail(email)
            if (user && user.email == email && user.password == password) {
                session.user = user
                session.userFirstName = user.firstName
                session.userEmail = user.email
                redirect(controller: "user", action: "index")
            } else {
                flash.message = "Invalid user credentials"
                redirect(action: "index")
            }
        }
    }

    def logout() {
        session.invalidate()
        redirect(action: "index")
    }
}