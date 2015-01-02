import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class JamesTesteService extends javax.mail.Authenticator {
	public static final int SHOW_MESSAGES = 1;
	public static final int CLEAR_MESSAGES = 2;
	public static final int SHOW_AND_CLEAR = SHOW_MESSAGES + CLEAR_MESSAGES;

	protected String from;
	protected Session session;
	protected PasswordAuthentication authentication;

	public JamesTesteService(String user, String host) {
		this(user, host, false);
	}

	public JamesTesteService(String user, String host, boolean debug) {
		from = user + '@' + host;
		authentication = new PasswordAuthentication(user, user);
		Properties props = System.getProperties();
//		props.put("mail.user", user);
//		props.put("mail.host", host);
		props.put("mail.debug", debug ? "true" : "false");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "467");
		props.put("mail.pop3.host", host);
		props.put("mail.pop3.port", "468");
		
		session = Session.getInstance(props, this);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}

	public void sendMessage(String to, String subject, String content)
			throws MessagingException {
		System.out.println("SENDING message from " + from + " to " + to);
		System.out.println();
		MimeMessage msg = new MimeMessage(session);
		msg.addRecipients(Message.RecipientType.TO, to);
		msg.setSubject(subject);
		msg.setText(content);
		Transport t = session.getTransport("smtp");
		t.connect("localhost", from, "marllon");
        t.sendMessage(msg, msg.getAllRecipients());
	}

	public void checkInbox(int mode) throws MessagingException, IOException, InterruptedException {
		if (mode == 0)
			return;
		boolean show = (mode & SHOW_MESSAGES) > 0;
		boolean clear = (mode & CLEAR_MESSAGES) > 0;
		String action = (show ? "Show" : "") + (show && clear ? " and " : "")
				+ (clear ? "Clear" : "");
		System.out.println(action + " INBOX for " + from);
		Store store = session.getStore();
		store.connect("localhost", 468, "marllon@localhost","marllon");
		Thread.sleep(500);
		Folder root = store.getDefaultFolder();
		Folder inbox = root.getFolder("inbox");
		inbox.open(Folder.READ_WRITE);
		Message[] msgs = inbox.getMessages();
		if (msgs.length == 0 && show) {
			System.out.println("No messages in inbox");
		}
		for (int i = 0; i < msgs.length; i++) {
			MimeMessage msg = (MimeMessage) msgs[i];
			if (show && msg != null) {
				System.out.println("    From: " + ((msg.getFrom() != null && msg.getFrom().length > 0) ? msg.getFrom()[0] : ""));
				System.out.println(" Subject: " + msg.getSubject());
				System.out.println(" Content: " + msg.getContent());
			}
			if (clear) {
				msg.setFlag(Flags.Flag.DELETED, true);
			}
		}
		inbox.close(true);
		store.close();
		System.out.println();
	}

}
