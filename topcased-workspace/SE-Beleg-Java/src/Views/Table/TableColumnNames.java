package Views.Table;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableColumnNames {

	ResultSetMetaData sqlMetaInformation;
	ArrayList<String> columnAliasList;
	ArrayList<String> columnNameList;
	ArrayList<String> columnTableList;
	
	
	public TableColumnNames(ResultSetMetaData metaInformation){
		sqlMetaInformation = metaInformation;
		columnAliasList = new ArrayList<String>();
		columnNameList = new ArrayList<String>();
		columnTableList = new ArrayList<String>();
		fillColumnListFromSqlMetaInformation();
	}
	
	private void fillColumnListFromSqlMetaInformation(){
		try {
			for(int i = 1;i<=sqlMetaInformation.getColumnCount();i++){
				columnAliasList.add(sqlMetaInformation.getColumnLabel(i));
				columnNameList.add(sqlMetaInformation.getColumnName(i));
				columnTableList.add(sqlMetaInformation.getTableName(i)+'.'+sqlMetaInformation.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getColumnAliasNames(){

		String [] ColumnAliasNames;
		ColumnAliasNames  = new  String[columnTableList.size()];
		
		for (int i=0;i<columnTableList.size(); i++ ){
			ColumnAliasNames[i]=columnTableList.get(i);
		}
		
		return ColumnAliasNames;
		
		//return columnAliasList.toArray();
	}
	
	public Object[] getColumnNames(){
		return columnNameList.toArray();
	}
	
	public String[] getColumnNamesAsString(){

		String [] ColumnNames;
		ColumnNames  = new  String[columnNameList.size()];
		
		for (int i=0;i<columnNameList.size(); i++ ){
			ColumnNames[i]=columnNameList.get(i);
		}
		
		return ColumnNames;
		
		//return columnAliasList.toArray();
	}
	
	public int getColumnAliasNameIndex(String column){
		return columnAliasList.indexOf(column);
	}
	
	public int getColumnNameIndex(String column){
		return columnNameList.indexOf(column);
	}
	
	public int getColumnIndex(String columnName){
		int columnIndex = getColumnAliasNameIndex(columnName);
		if(columnIndex == -1) columnIndex = getColumnNameIndex(columnName);
		return columnIndex;
	}
	
	public String getColumnAliasNameByIndex(int index){
		return columnAliasList.get(index);
		
	}
	
	public String getColumnNameByIndex(int index){
		return columnNameList.get(index);
		
	}
	
	public void addColumn(String columnName,int position){
		try{
			columnAliasList.add(position, columnName);
			columnNameList.add(position, columnName);
			columnTableList.add(position, columnName);
		}catch(IndexOutOfBoundsException exception){
			exception.printStackTrace();
		}
	}
	
	public int getCountOfColumns(){
		return columnAliasList.size();
	}
	
}
