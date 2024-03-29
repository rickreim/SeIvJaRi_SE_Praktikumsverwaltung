package Views.GuiElemente;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ConfigParser.Debug;
import Views.Interfaces.BasicBox;
import Views.Interfaces.NaviMarkBoxCtrl;

/**
 * Implementiert eine BasicBox mit dem Button "markierte ausw�hlen".
 */
public class BoxElementBottomNaviMark extends JPanel implements BasicBox , MouseListener{
		private JButton jbn_mark;
		private NaviMarkBoxCtrl controller;
	
	/**
	 * Initialisiert die Box und bringt sie zur Anzeige.
	 * @param controller	NaviMarkBoxCtrl Objekt, welches die Nutzereingaben verarbeitet.
	 */
	public BoxElementBottomNaviMark(NaviMarkBoxCtrl controller){
		this.controller = controller;
		initComponents();
		setComponentNames();
		setComponentEventHandler();
		setToolTip();
	}
	
	@Override
	public void setComponentNames() {
		jbn_mark.setName("mark");
	
	}

	@Override
	public void setComponentEventHandler() {
		jbn_mark.addMouseListener(this);
	
	}

	@Override
	public JComponent getJComponent() {
		return this;
	}

	@Override
	public void initComponents() {
		jbn_mark = new JButton("markierte ausw\u00E4hlen");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jbn_mark)
					.addContainerGap(339, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jbn_mark)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() == jbn_mark)
			controller.buttonMarkClicked();
		
	}
	
	@Override
	public void setToolTip(){
		if(Debug.isDebugMode()){
			setToolTipText(this.getClass().getCanonicalName());
			this.setBackground(Color.getHSBColor(ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255));
		}
	}

	@Override
	public void setComponentValues() {}
	
	@Override
	public void refreshContent() {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
