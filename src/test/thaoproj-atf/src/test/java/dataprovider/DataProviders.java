package dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;
import utils.Constants;

public class DataProviders {
	
  @DataProvider(name="loginData")
  public Object[][] dpMethod1(){
	  
	  return new Object[][] {
		  {"thao1","thao1@gmail.com","thao1@123"},
		  {"thao2","thao2@gmail.com","thao2@123"},
		  {"thao3","thao3@gmail.com","thao3@123"}
	  };
	  
  }
  
 
  @DataProvider(name="loginDataFromExcel")
  public Object[][] dpMethod2() throws IOException{
	Object[][] data =ExcelUtil.getExcelData(Constants.excelFileName, Constants.sheetName);
	return data;
  }
 
}
