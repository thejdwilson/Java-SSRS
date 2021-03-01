import java.io.IOException;

public class DeleteSubscription
{
  public static void main(String[] args) throws IOException, InterruptedException
  {
    String server = "http://report_server/Reportserver";
    String report = "/Directory1/Report1";
    String description = "Report1";
    String owner = "jdwilson";

    Process process = new ProcessBuilder()
        .inheritIO()
        .command(
            "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe",
            "-Command",
            "path\\to\\Delete-SSRS-Subscription.ps1" +
            " '" + server + "' " +
            " '" + report + "' " +
            " '" + description + "' " +
            " '" + owner + "' " ).start();
    process.waitFor();
  }
}
