package bookStoreBackend

import BookStoreBackend.EmailService

class EmailJob {

    EmailService emailService

     public static triggers = {
         cron name: 'EmailJob', startDelay: 1000L, cronExpression: '0 0 13 * * ?'
    }
    void execute() {
        try{
            emailService.sendDailyEmail()
        }catch (Exception e) {
            log.error("Error sending email: ${e.message}")
            throw new Exception("Error sending email: ${e.message}")
        }

    }
}