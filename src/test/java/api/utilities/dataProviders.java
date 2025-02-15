package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	
	  @DataProvider(name="Data")
	    public Object[][] getAllData() throws IOException {

	        // ✅ Fix: Use correct file path format
	        String path = System.getProperty("user.dir") + "/TestData/Userdata.xlsx"; 

	        XLUtility xl = new XLUtility(path);

	        int rownum = xl.getRowCount("Sheet1");
	        int colcount = xl.getCellCount("Sheet1",1);

	        // ✅ Fix: Use Object[][] instead of String[][] to support int and String values
	        Object[][] apidata = new Object[rownum][colcount];

	        for (int i = 1;i <= rownum; i++) { // Start from row 1 (assuming row 0 is headers)
	            for (int j =0;j < colcount; j++) { // Start from col 1
	                apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
	            }
	        }

	        return apidata;
	    }
	
	
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		
		String path=System.getProperty("user.dir") + "/TestData/Userdata.xlsx";
		XLUtility xl=new XLUtility(path);
		
        int rownum = xl.getRowCount("Sheet1");
         
        String apidata[]=new String[rownum];
        
        for(int i=1;i<=rownum;i++) {
        		 
        		 apidata[i-1]=xl.getCellData("Sheet1", i, 1);
        	 }
        
        return apidata;

	}
}


