import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DiskListListener implements ListSelectionListener  {

	public void valueChanged(ListSelectionEvent arg0) 
	{	
		Graphics.ListSelected();
	}

}
