package BookStoreBackend

class Purchase {

    Book book;
    User user;
    Date purchaseDate;
    static belongsTo = [user: User]

    static constraints = {

        book nullable: false
        user nullable: false
        purchaseDate nullable: false

    }
}