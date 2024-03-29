package Views.GuiElemente;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import ConfigParser.Debug;
import Models.Datenbank.SqlTableCompanies;
import Views.Interfaces.BasicBox;
import Views.Interfaces.EditBox;
import Views.Interfaces.EditBoxCtrl;

/**
 * Implementiert eine EditBox, welche die Informationen einer Firma darstellt und die Bearbeitung des Datensatzes erm�glicht.
 */
public class BoxElementCompanyDetails extends JPanel implements EditBox{
		private JLabel jl_firmenname;
	    private JLabel jl_strasse;
	    private JLabel jl_plz;
	    private JTextField jtf_firmenname_value;
	    private JTextField jtf_strasse_value;
	    private JTextField jtf_plz_value;
	    private JLabel lblAnsprechpartner;
	    private JTextField jtf_ort_value;
	    private JTextField jtf_land_value;
	    private JTextField jtf_tel_value;
	    private JTextArea jta_bemerkung_value;
	    private JPanel pnl_contact;
	    
	    private GroupLayout groupLayout;

		private EditBoxCtrl controller;
		private boolean addNewContract = false;
		
	/**
	 * Initialisiert die Box und bringt sie zur Anzeige.
	 * @param controller	EditBoxCtrl Objekt, welche die Benutzereingaben verarbeitet und die Daten bereitstellt.
	 */
	public BoxElementCompanyDetails(EditBoxCtrl controller){
		this.controller = controller;
		initComponents();
		setComponentNames();
		setComponentValues();
		setComponentEventHandler();
		setToolTip();
	}
	
	/**
	 * Initialisiert die Box zum Anlegen eines neuen Datensatzes.
	 * @param controller			EditBoxCtrl Objekt, welche die Benutzereingaben verarbeitet.
	 * @param addNewContract		Flag um die Neuanlage von einer Firma zu signalisieren.
	 */
	public BoxElementCompanyDetails(EditBoxCtrl controller, boolean addNewContract){
		this.controller = controller;
		this.addNewContract = addNewContract;
		initComponents();
		setComponentNames();
		setComponentEventHandler();
		setToolTip();
	}
	
	/**
	 * L�scht den Inhalt aller Felder.
	 */
	public void clearComponentValues() {
		jtf_firmenname_value.setText("");
		jtf_strasse_value.setText("");
		jtf_plz_value.setText("");
		jtf_ort_value.setText("");
		jtf_land_value.setText("");
		jtf_tel_value.setText("");
	}
	
	/**
	 * Erm�glicht das Einf�gen einer BasicBox um z.B. die Ansprechpartner der Firma anzuzeigen.
	 * @param contactBox	BasicBox Objekt welches neben den Informationen angezeigt werden soll.
	 */
	public void setContactBox(BasicBox contactBox){
		JPanel newPanel = (JPanel)contactBox.getJComponent();
		groupLayout.replace(pnl_contact, newPanel);
		pnl_contact = newPanel;
		pnl_contact.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, null));
		groupLayout.layoutContainer(this);
	}
	
	@Override
	public void setComponentNames() {
		jtf_firmenname_value.setName(SqlTableCompanies.Firmenname);
		jtf_strasse_value.setName(SqlTableCompanies.Strasse);
		jtf_plz_value.setName(SqlTableCompanies.PLZ);
		jtf_ort_value.setName(SqlTableCompanies.Ort);
		jtf_land_value.setName(SqlTableCompanies.Land);
		jtf_tel_value.setName(SqlTableCompanies.Telefonnummer);
		jta_bemerkung_value.setName(SqlTableCompanies.Bemerkung);
	}

	@Override
	public void setComponentValues() {
		jtf_firmenname_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Firmenname));
		jtf_strasse_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Strasse));
		jtf_plz_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.PLZ));
		jtf_ort_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Ort));
		jtf_land_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Land));
		jtf_tel_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Telefonnummer));
		jta_bemerkung_value.setText(controller.getStringValueForBoxElementEdit(SqlTableCompanies.Bemerkung));
	}
	
	@Override
	public void refreshContent() {
		if(!addNewContract)
			setComponentValues();
		else
			clearComponentValues();

		if(pnl_contact instanceof BasicBox)
			((BasicBox)pnl_contact).refreshContent();
	}

	@Override
	public JComponent getJComponent() {
		return this;
	}

	@Override
	public Map<String, Object> getInputValues() {
		Map<String, Object> inputValues = new HashMap<String, Object>();
		inputValues.put(jtf_firmenname_value.getName(), getSubstringFromInputString(jtf_firmenname_value.getText(),30));
		inputValues.put(jtf_strasse_value.getName(), getSubstringFromInputString(jtf_strasse_value.getText(),30));
		inputValues.put(jtf_plz_value.getName(), getSubstringFromInputString(jtf_plz_value.getText(),10));
		inputValues.put(jtf_ort_value.getName(), getSubstringFromInputString(jtf_ort_value.getText(),20));
		inputValues.put(jtf_land_value.getName(), getSubstringFromInputString(jtf_land_value.getText(),12));
		inputValues.put(jtf_tel_value.getName(), getSubstringFromInputString(jtf_tel_value.getText(),20));
		inputValues.put(jta_bemerkung_value.getName(), getSubstringFromInputString(jta_bemerkung_value.getText(),100));
		return inputValues;
	}

	private String getSubstringFromInputString(String inputString, int maxLenght) {
		int length = inputString.length();
		return (String) inputString.subSequence(0, (length<maxLenght)?length:maxLenght);
	}
	
	@Override
	public void initComponents(){
		jl_firmenname = new javax.swing.JLabel();
        jl_plz = new javax.swing.JLabel();
        jl_strasse = new javax.swing.JLabel();
        jtf_firmenname_value = new javax.swing.JTextField();
        jtf_strasse_value = new javax.swing.JTextField();
        jtf_plz_value = new javax.swing.JTextField();

        jl_firmenname.setText("Firmenname");

        jl_plz.setText("PLZ");

        jl_strasse.setText("Stra\u00DFe");

        pnl_contact = new JPanel();
        pnl_contact.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, null));
        
        lblAnsprechpartner = new JLabel("Ansprechpartner");
        
        jtf_ort_value = new JTextField();
        
        jtf_land_value = new JTextField();
        
        JLabel jl_ort = new JLabel();
        jl_ort.setText("Ort");
        
        JLabel jl_land = new JLabel();
        jl_land.setText("Land");
        
        JLabel lblTel = new JLabel("Tel.");
        
        jtf_tel_value = new JTextField();
        jtf_tel_value.setColumns(10);
        
        JLabel lblBemerkung = new JLabel("Bemerkung");
        
        jta_bemerkung_value = new JTextArea();
        jta_bemerkung_value.setLineWrap(true);
        jta_bemerkung_value.setRows(10);
        jta_bemerkung_value.setColumns(30);
        groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jl_firmenname, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jl_strasse, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jl_plz, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jl_ort, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jl_land, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblBemerkung))
        			.addGap(9)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jtf_firmenname_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_strasse_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_plz_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_ort_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_land_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_tel_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jta_bemerkung_value, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(58)
        					.addComponent(lblAnsprechpartner, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(57)
        					.addComponent(pnl_contact, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(jl_firmenname)
        					.addGap(11)
        					.addComponent(jl_strasse)
        					.addGap(17)
        					.addComponent(jl_plz)
        					.addGap(15)
        					.addComponent(jl_ort)
        					.addGap(17)
        					.addComponent(jl_land)
        					.addGap(16)
        					.addComponent(lblTel)
        					.addGap(16)
        					.addComponent(lblBemerkung))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(20)
        					.addComponent(jtf_firmenname_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)
        					.addComponent(jtf_strasse_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(jtf_plz_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(9)
        					.addComponent(jtf_ort_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(11)
        					.addComponent(jtf_land_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(10)
        					.addComponent(jtf_tel_value, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(8)
        					.addComponent(jta_bemerkung_value, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(23)
        					.addComponent(lblAnsprechpartner)
        					.addGap(1)
        					.addComponent(pnl_contact, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
        			.addGap(6))
        );
        setLayout(groupLayout);
	}
	
	@Override
	public void setComponentEventHandler() {}
	
	@Override
	public void setToolTip(){
		if(Debug.isDebugMode()){
			setToolTipText(this.getClass().getCanonicalName());
			this.setBackground(Color.getHSBColor(ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255, ThreadLocalRandom.current().nextFloat()%255));
		}
	}
}
