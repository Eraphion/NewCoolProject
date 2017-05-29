import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ElectroListListener implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent arg0) 
	{
		Graphics.ElectroListSelected();
	}

}
