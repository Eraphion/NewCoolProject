import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmElectroChangeListener implements ActionListener
{
	public void actionPerformed(ActionEvent arg0) 
	{
		Graphics.ElectroChanged();
	}

}
