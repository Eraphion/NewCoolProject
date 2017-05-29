import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Report extends JDialog{
	private JTextArea text;
	private JScrollPane scroll;
	Report(String str)
	{
		text = new JTextArea(str);
		text.setEditable(false);
		scroll = new JScrollPane();
		scroll.getViewport().add(text);
		this.getContentPane().add(scroll);
		this.setSize(600,500);
		this.setLocation(500, 0);
		this.setModal(true);
		this.setResizable(false);
		this.setTitle("Об архивах");
	}
}
