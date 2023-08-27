package UI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//This class reads the records from the csv files and put them inside a map<string,string>
public class Stock {
	BufferedReader bf;
	int i = 0;
	String line = "";
	String splitBy = ",";
	Map<String, String> stock = new HashMap<String, String>();


	public Stock(String str) throws FileNotFoundException {
		this.bf = new BufferedReader(new FileReader(str));;
	}

	public Map<String, String> extractStocks() throws IOException {
	while((line=bf.readLine())!=null) // returns a Boolean value

	{
		if (i == 0) {
			++i;
			continue;
		}
		String[] stockRecord = line.split(splitBy); // use comma as separator
		stock.put(stockRecord[2], stockRecord[4]);
	}
	return stock;
	}

}
