package Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Search {
    public static void main(String[] args) {
        String excelLoc = "C:\Users\Acer\Downloads\4BeatsQ1";


        String currentDay = LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        try {
            FileInputStream file = new FileInputStream(excelLoc);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(currentDay);

            if (sheet == null) {
                System.out.println("No sheet found for " + currentDay);
                workbook.close();
                return;
            }







public class BaseDriverQ1 {

	static String google = "https://www.google.com";

	WebDriver driver;

	public void start() {

		String browser = System.getProperty("browser", "chrome");
		if (browser.contains("chrome")) {

			WebDriverManager.chromedriver().setup();

		}
		else if (browser.contains("firefox")) {

			WebDriverManager.firefoxdriver().setup();

		}

		 else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}



	}


for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row rowtoEdit = sheet.getRow(i);
                if (row == null) continue;

                Cell keywordCell = row.getCell(0);
                String searchitem = keywordCell.getStringCellValue();

                WebElement searchBox = driver.findElement(By.id("APjFqb"));
                searchBox.clear();
                searchBox.sendKeys(searchitem);
                searchBox.submit();


                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<WebElement> suggestions = driver.findElements(By.name("q"));

                String longSuggestion = "";
                String shortSuggestion = suggestions.get(0).getText();

                for (WebElement suggestion : suggestions) {
                    String option = suggestion.getText();
                    if (option.length() > longSuggestion.length()) {
                        longSuggestion = option;
                    }
                    if (option.length() < shortSuggestion.length()) {
                        shortSuggestion = option;
                    }
                }


                Cell longSuggestionCell = row.createCell(1);
                longSuggestionCell.setCellValue(longSuggestion);

                Cell shortSuggestionCell = row.createCell(2);
                shortSuggestionCell.setCellValue(shortSuggestion);
            }

            file.close();


            FileOutputStream saveNow = new FileOutputStream(excelLoc);
            workbook.write(saveNow);
            saveNow.close();

            workbook.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }




	@AfterSuite
	public void end()
	{

		driver.quit();

	}








}
