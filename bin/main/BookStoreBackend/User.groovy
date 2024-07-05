package BookStoreBackend


class User {
    String firstName
    String lastName
    String email
    String phone
    String password

    static hasMany = [books: Book]

    static constraints = {
        email unique: true, email: true
        password password: true, blank: false
        //insert regex for phone

    }
    static mapping = {

        version false

            // Ensure fields are nullable if necessary
            firstName nullable: true
            lastName nullable: true
            email nullable: false
            phone nullable: true
            password nullable: false



    }
}
