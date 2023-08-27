# Stock_PB_Ratio_Through_Selenium
This code is used to find the P/B ratios of the nifty50(national stock exchange of India Largecap 50) index stocks and display them on console.
Many investors use the price-to-book ratio (P/B ratio) to compare a firm's market capitalization to its book value and locate undervalued companies.
This code takes the ISIN number and stock ticker symbol from the csv file that we have downloaded and use these to search the stock and find the P/B ratio from the moneycontrol website(Website that gives the stock data), using the selenium automated testing framework.
## System Requirements
1. Install maven on your system [Maven Installation link](https://maven.apache.org/download.cgi).
2. IDE of your choice(VS Code preferrable)
3. Download the CSV file from the [Nifty50 file download link](https://archives.nseindia.com/content/indices/ind_nifty50list.csv), which we are going to use in the project. 
## Running the code in the local
1. First clone the repository to the desired location or directory in your local computer.
2. Open the project in the IDE(VS Code preferrable)
3. Run the command  "*mvn clean install*" in terminal in the root directory of the project , which will download the required packages
4. Initialize the pathString variable value in the "*src/Test/Java/UI/StockPBRatio.java*" with the path to the Nifty50 CSV file.[Example : Nifty50 CSV file path in my computer "C:\\Users\\yeshwanth\\Downloads\\ind_nifty50list.csv"]
5. After that the line should look like [String pathString = "C:\\Users\\yeshwanth\\Downloads\\ind_nifty50list.csv"].
6. Now press the run button in IDE, which runs the code and outputs the result to the console
