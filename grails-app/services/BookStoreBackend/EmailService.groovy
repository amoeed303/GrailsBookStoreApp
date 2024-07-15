package BookStoreBackend

import grails.gorm.transactions.Transactional
import grails.plugins.mail.MailService

@Transactional
class EmailService {
    UserService userService
    MailService mailService

    def sendDailyEmail() {

        def users = userService.getAllUsers()
        users.each { user ->
            try {
                sendEmailToUser(user.email)
            } catch (Exception e) {
                log.error("Error sending email to user: ${user.email}")
                throw new Exception("Error sending email to user: ${user.email}")
            }
        }
    }

    def sendEmailToUser(String email) {
        mailService.sendMail {
            to email
            subject "BookStoreBackend: New Books Available"
            body "Dear User,\nWe have added new books to our collection.Please visit our store to check them out.\nRegards,\nBookStore Team"

        }
    }
}