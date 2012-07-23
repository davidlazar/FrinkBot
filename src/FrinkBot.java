/*
Author: David Lazar
*/
import org.jibble.pircbot.*;
import frink.parser.*;

public class FrinkBot extends ConfigurablePircBot {
    private Frink interp;

    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.startsWith("~ ")) {
            try {
                String result = interp.parseString(message.substring(2));
                String lines[] = result.split("\n");
                // TODO long lines are truncated
                for (String line : lines)
                    sendMessage(channel, line);
            } catch (frink.errors.FrinkEvaluationException fee) {
                sendMessage(channel, "Operation denied.");
            }
        }
    }

    public void onDisconnect() {
        int reconnectDelay = 30; // seconds
        while (!isConnected()) {
            try {
                this.log("*** Attempting to reconnect to server.");
                reconnect();
                // rejoin channels, if specified
                if (this.getConfiguration().containsKey("Channels")) {
                    joinChannel(this.getConfiguration().getString("Channels"));
                }
            }
            catch (Exception e) {
                this.log("*** Failed to reconnect to server. Sleeping " + reconnectDelay + " seconds.");
                try {
                    Thread.sleep(reconnectDelay * 1000);
                } catch (Exception ignored) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: frinkbot <config>");
            System.exit(1);
        }

        FrinkBot bot = new FrinkBot();
        // Initialize Frink interpretor
        bot.interp = new Frink();
        bot.interp.parseString("2 in -> feet");
        bot.interp.setRestrictiveSecurity(true);

        bot.initBot(args[0]);
    }
}
