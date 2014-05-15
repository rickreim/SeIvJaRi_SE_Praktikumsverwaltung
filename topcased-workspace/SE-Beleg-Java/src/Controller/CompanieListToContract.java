package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import Praktikumsverwaltung.Praktikumsverwaltung;

public class CompanieListToContract extends ListController{
	
	private String srcSqlQuery = "select ID as ID, Name as Name, Street as Strasse, ZIP as PLZ, Town as Ort, Country as Land, Phone_Cental as 'Tel.', Notes as Bemerkung from companies";
	private Views.CompanieListToContract view;
	private ChangeableController calledController;
	
	public CompanieListToContract(ChangeableController calledController){
		super();
		this.calledController = calledController;
		setModel(new Models.CompanieList(srcSqlQuery));
		
		setView(view = new Views.CompanieListToContract(this));
	}
	

	@Override
	public void display() {
		// TODO Auto-generated method stub
		view.display();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(e.getComponent().getName()){
		case "table": 	if (e.getClickCount() == 2) {
							Object companieId;
							
							if((companieId = view.getColumnValueFromSelectedRow("ID")) != null){
							CompanieSingle newFrame = new CompanieSingle(companieId);
							Praktikumsverwaltung.addFrameToForeground(newFrame);
							}
						}else{
							view.setFlag();
						}
						break;
						
		case "setMarkedRow": 	calledController.change("company",view.getColumnValueFromSelectedRow("ID").toString());
								view.dispose();
								break;
										
		case "anlegen":					CompanieEmptySingle newEmptyFrame = new CompanieEmptySingle();
										Praktikumsverwaltung.addFrameToForeground(newEmptyFrame);
										break;
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		Document searchField = arg0.getDocument();
		
		try {
			String searchValue = searchField.getText(0,searchField.getLength());
			((Models.CompanieList)model).setSearchFilter(searchValue);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void insertUpdate(DocumentEvent arg0) {
		Document searchField = arg0.getDocument();
		try {
			String searchValue = searchField.getText(0,searchField.getLength());
			((Models.CompanieList)model).setSearchFilter(searchValue);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void removeUpdate(DocumentEvent arg0) {
		Document searchField = arg0.getDocument();
		try {
			String searchValue = searchField.getText(0,searchField.getLength());
			((Models.CompanieList)model).setSearchFilter(searchValue);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() instanceof JTextField){
			JTextField anzDatensaetze = (JTextField)(arg0.getSource());
			if(anzDatensaetze.getName().equals("anzDatensaetze")){
				model.setcolumnLimitAndRefreshViews(Integer.parseInt(anzDatensaetze.getText()));
				view.setTableRowsCount(Integer.parseInt(anzDatensaetze.getText()));
			}
			
		}
	}
	
	


}
