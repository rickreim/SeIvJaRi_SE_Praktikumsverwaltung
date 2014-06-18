package Views.GuiElemente;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import ConfigParser.Debug;
import Models.Datenbank.SqlTableStudent;
import Views.Interfaces.EditBox;
import Views.Interfaces.EditBoxCtrl;

public class BoxElementStudentDetails extends JPanel implements EditBox{
		private JTextField jtf_matrikelnr;
		private JTextField jtf_firstname;
		private JTextField jtf_name;
		private JTextField jtf_stgr;
		private JTextField jtf_mail;
		private JTextArea jta_note;
	
		private EditBoxCtrl parent;
		private boolean addNewContract = false;
		
	public BoxElementStudentDetails(EditBoxCtrl parent){
		this.parent = parent;
		initComponents();
		setComponentNames();
		setComponentValues();
		setComponentEventHandler();
		setToolTip();
	}
	
	public BoxElementStudentDetails(EditBoxCtrl parent, boolean addNewContract){
		this.parent = parent;
		this.addNewContract = addNewContract;
		initComponents();
		setComponentNames();
		setComponentEventHandler();
		setToolTip();
	}
	
	@Override
	public void setComponentNames() {
		jtf_matrikelnr.setName(SqlTableStudent.TableNameDotMatrikelNummer);
		jtf_firstname.setName(SqlTableStudent.TableNameDotVorname);
		jtf_name.setName(SqlTableStudent.TableNameDotNachname);
		jtf_stgr.setName(SqlTableStudent.TableNameDotStudiengruppe);
		jtf_mail.setName(SqlTableStudent.TableNameDotEMail);
		jta_note.setName(SqlTableStudent.TableNameDotBemerkung);
	}

	@Override
	public void setComponentValues() {
		jtf_matrikelnr.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotMatrikelNummer));
		jtf_firstname.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotVorname));
		jtf_name.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotNachname));
		jtf_stgr.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotStudiengruppe));
		jtf_mail.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotEMail));
		jta_note.setText(parent.getStringValueForBoxElementEdit(SqlTableStudent.TableNameDotBemerkung));
	}
	
	public void clearComponentValues() {
		jtf_matrikelnr.setText("");
		jtf_firstname.setText("");
		jtf_name.setText("");
		jtf_stgr.setText("");
		jtf_mail.setText("");
		jta_note.setText("");
	}

	@Override
	public void setComponentEventHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refreshContent() {
		if(!addNewContract)
			setComponentValues();
		else
			clearComponentValues();
	}

	@Override
	public JComponent getJComponent() {
		return this;
	}

	@Override
	public Map<String, Object> getInputValues() {
		Map<String, Object> inputValues = new HashMap<String, Object>();
		
		inputValues.put(jtf_matrikelnr.getName(), jtf_matrikelnr.getText());
		inputValues.put(jtf_firstname.getName(), jtf_firstname.getText());
		inputValues.put(jtf_name.getName(), jtf_name.getText());
		inputValues.put(jtf_stgr.getName(), jtf_stgr.getText());
		inputValues.put(jtf_mail.getName(), jtf_mail.getText());
		inputValues.put(jta_note.getName(), jta_note.getText());
		return inputValues;
	}
	
	public void initComponents(){
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
					.addGap(153))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(9))
		);
		
		JLabel label_5 = new JLabel("Bemerkung");
		
		jta_note = new JTextArea();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(jta_note, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jta_note, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		jtf_matrikelnr = new JTextField();
		jtf_matrikelnr.setColumns(10);
		
		jtf_firstname = new JTextField();
		jtf_firstname.setColumns(15);
		
		jtf_name = new JTextField();
		jtf_name.setColumns(20);
		
		jtf_stgr = new JTextField();
		jtf_stgr.setColumns(15);
		
		jtf_mail = new JTextField();
		jtf_mail.setColumns(40);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(jtf_matrikelnr, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtf_firstname, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtf_name, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtf_stgr, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(jtf_mail, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addComponent(jtf_matrikelnr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtf_firstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtf_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jtf_stgr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jtf_mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("Matrikelnr.");
		
		JLabel label_1 = new JLabel("Vorname");
		
		JLabel label_2 = new JLabel("Nachname");
		
		JLabel label_3 = new JLabel("Studiengruppe");
		
		JLabel label_4 = new JLabel("E-Mail");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(7))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(label)
					.addGap(12)
					.addComponent(label_1)
					.addGap(12)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(label_3)
					.addGap(12)
					.addComponent(label_4)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	public void setToolTip(){
		if(Debug.isDebugMode()){
			setToolTipText(this.getClass().getCanonicalName());
			this.setBackground(Color.getHSBColor(ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255));
		}
	}

}
