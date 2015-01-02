public class JamesConfigTest {
	public static void main(String[] args) throws Exception {
		// CREATE CLIENT INSTANCES
		JamesTesteService redClient = new JamesTesteService("marllon", "localhost");
//		JamesTesteService greenClient = new JamesTesteService("green",
//				"localhost");
//		JamesTesteService blueClient = new JamesTesteService("blue",
//				"localhost");

		// CLEAR EVERYBODY'S INBOX
//		redClient.checkInbox(JamesTesteService.CLEAR_MESSAGES);
//		greenClient.checkInbox(JamesTesteService.CLEAR_MESSAGES);
//		blueClient.checkInbox(JamesTesteService.CLEAR_MESSAGES);
		Thread.sleep(500); // Let the server catch up

		// SEND A COUPLE OF MESSAGES TO BLUE (FROM RED AND GREEN)
//		redClient.sendMessage("marllon@localhost", "Testing blue from red",
//				"This is a test message");
//		greenClient.sendMessage("blue@localhost", "Testing blue from green",
//				"This is a test message");
		Thread.sleep(500); // Let the server catch up

		// LIST MESSAGES FOR BLUE (EXPECT MESSAGES FROM RED AND GREEN)
//		blueClient.checkInbox(JamesTesteService.SHOW_AND_CLEAR);
		redClient.checkInbox(JamesTesteService.SHOW_AND_CLEAR);
	}
}
