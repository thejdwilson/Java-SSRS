import java.io.IOException;

public class CreateSubscription
{
  public static void main(String[] args) throws InterruptedException, IOException
  {
    String server = "http://ssrs-server-name/Reportserver";
    String report = "/Report-Directory/Report-Name";
    String description = "Report-Name";
    String eventType = "TimedSubscription";
    String startTime = "02/24/2021 03:07pm";
    String deliveryFormat = "Email";
    String sendTo = "jdwilson@email.com";
    String renderFormat = "MHTML";
    String subject = "Users Report";
    String replyTo = "do-not-reply@email.com";
    String priority = "Normal";

    Process process = new ProcessBuilder()
        .inheritIO()
        .command(
            "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe",
            "-Command",
            "path\\to\\Create-SSRS-Subscription.ps1" +
            " '" + server + "' " +
            " '" + report + "' " +
            " '" + description + "' " +
            " '" + eventType + "' " +
            " '" + startTime + "' " +
            " '" + deliveryFormat + "' " +
            " '" + sendTo + "' " +
            " '" + renderFormat + "' " +
            " '" + subject + "' " +
            " '" + replyTo + "' " +
            " '" + priority + "' ").start();
    process.waitFor();
  }
}
