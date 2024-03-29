import javax.swing.*;

public class Prakt_MainWindow extends JFrame{
	
	JDesktopPane InnerDesktop;
	static int offeneFensterAnzahl = 0;
	static final int xOffset = 30, yOffset = 30;
	
	public Prakt_MainWindow(){
		
		super("MainFrame");
		InnerDesktop = new JDesktopPane();
		setContentPane(InnerDesktop);
		
	}
	
	public void addInternalFrame(JInternalFrame iFrame){
		//JInternalFrame iFrame = new JInternalFrame(name,true,true,true,true);
		//iFrame.setSize(300, 300);

		
	
		if (((offeneFensterAnzahl*xOffset+iFrame.getWidth())> this.getContentPane().getHeight())
				||(offeneFensterAnzahl*yOffset+iFrame.getWidth())> this.getContentPane().getWidth())
			offeneFensterAnzahl=0;
		++offeneFensterAnzahl;
		iFrame.setTitle(iFrame.getTitle()+" #"+offeneFensterAnzahl);
		iFrame.setLocation(xOffset*offeneFensterAnzahl, yOffset*offeneFensterAnzahl);
		iFrame.setVisible(true);
		InnerDesktop.add(iFrame);
		InnerDesktop.moveToFront(iFrame);
		
		try{
			iFrame.setSelected(true);
		}catch(java.beans.PropertyVetoException e){}
	}
	
	public static void main(String args[]){
		Prakt_MainWindow mWindow = new Prakt_MainWindow(); 
		mWindow.setJMenuBar(new Prak_TopMenu(mWindow));
		
		//mWindow.addInternalFrame(new Prakt_Startseite(mWindow));
		//mWindow.addInternalFrame(new Prakt_ViewFirmen());
		mWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mWindow.setSize(800, 800);
		mWindow.setVisible(true);
	}

}
