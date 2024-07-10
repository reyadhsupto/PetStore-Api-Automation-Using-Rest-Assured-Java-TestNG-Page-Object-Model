package api.utilities;


import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
//	public String path = System.getProperty("User.dir") + "//petstore_automation//TestData//userdata.xlsx";
	public String path = "G://RedDot_Internship//PetStore_API_RestAssured//petstore_automation//TestData//userdata.xlsx";
	
	@DataProvider(name = "Data")
	public String[][] get_all_data() throws IOException{
//		String path = System.getProperty("User.dir") + "//TestData/userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		System.out.println("--------------"+rownum+"-----------");
		
		int colcount = xl.getcellcount("Sheet1", 0);
		System.out.println("--------------"+colcount+"-----------");
		
		
		String apidata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j] = xl.getCellData("Sheet1",i,j);
				//System.out.println("--------------"+colcount+"-----------");
			}
		}
		return apidata;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException, InterruptedException{
//		String path = System.getProperty("User.dir") + 
		XLUtility xl = new XLUtility(path);
		int rownum = xl.getRowCount("Sheet1");
		String payloaddata[] = new String[rownum];
		
		for(int i=1;i<=rownum;i++) {
			payloaddata[i-1] = xl.getCellData("Sheet1", i, 1);
		}
		return payloaddata;
	}

}
