package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.AddProduct;
import POM.HomePage;
import baseclass.BaseClass;
import excelFileUtility.ExcelUtility;
import javaUtility.JavaUtility;
import webDriverUtility.WebDriverUtility;
@Listeners(listeners.ListenerImplementation.class)
public class CreateProductTest extends BaseClass{ 
		 @Test(groups = "Smoke")
		
		 
		 public void CreateProduct()throws 
		InterruptedException, EncryptedDocumentException, IOException { 
		  // TODO Auto-generated method stub 
		   
		   
		  ExcelUtility eutil = new ExcelUtility(); 
		  WebDriverUtility wutil= new WebDriverUtility(); 
		  JavaUtility jutil = new JavaUtility(); 
		  String pname = eutil.getDataFromExcel("Product", 1, 
		2); 
		  String psize = eutil.getDataFromExcel("Product", 1, 
		3); 
		  String pprize = eutil.getDataFromExcel("Product", 
		1, 4); 
		   
		             HomePage hp = new HomePage(driver); 
		    hp.getProducts().click(); 
		    Thread.sleep(2000); 
		    hp.getGetproduct().click(); 
		    Thread.sleep(2000); 
		    AddProduct ap= new AddProduct(driver); 
		    
		     ap.getProductid(); 
		       
		ap.getProductName().sendKeys(pname); 
		       ap.getQuantity().clear(); 
		       ap.getQuantity().sendKeys(psize); 
		       ap.getPrice().clear(); 
		    //   ap.getQuantity().sendKeys(pprize); 
		       ap.getPrice().sendKeys(pprize); 
		       wutil.select(ap.getProductCategory(),2); 
		       wutil.select(ap.getVendorId(), 3); 
		    ap.getAddprodButton().click(); 
		    Thread.sleep(4000); 
		    hp.getClosemsg().click(); 
		     
		     
		    
		     
		    
		 
		   } 
		 
		   
		}


