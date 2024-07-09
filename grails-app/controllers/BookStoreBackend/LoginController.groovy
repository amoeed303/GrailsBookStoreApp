package BookStoreBackend


class LoginController {
    UserService userService

    def index() {
render(view: "/login/login")
    }

        def authenticate() {
            String email = request.getParameter("email")
            String password = request.getParameter("password")
            boolean isAdmin = request.getParameter("isAdmin")?Boolean.valueOf(request.getParameter("isAdmin")):false

            println(isAdmin)
            if (isAdmin) {
                if (email == "admin@gmail.com" && password == "admin123") {
                    session.isAdmin = true
                    redirect(controller: "admin", action: "index")
                } else {
                    flash.message = "Invalid admin credentials"
                    redirect(action: "index")
                }
            } else {
                User user = userService.getUserByEmail(email)

                if (user && user.email==email && user.password==password) {

                    session.user = user
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