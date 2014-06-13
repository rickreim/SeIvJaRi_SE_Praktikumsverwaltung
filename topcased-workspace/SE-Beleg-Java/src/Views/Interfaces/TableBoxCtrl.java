package Views.Interfaces;

import java.awt.event.MouseListener;

public interface TableBoxCtrl {
	
	public Object[][] getTableData();
	public Object[] getTableHeader();
	
	public void tableRowClicked();
	public void tableRowDoubleClicked();
	
	public Object getValueFromPosition(int row, String column);
	public void setValueAtPosition(int row, String column, Object value);
	public int getColumnAliasIndex(String columnName);

}
