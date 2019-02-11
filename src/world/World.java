/**
 This project demonstrates the use of HashMaps, namely LinkedHashMaps to preserve order because of the need for sorting.
 I wanted to add a menu and allow user input but the deadline came around too fast this week. I will add these and the extended challenge at
 a later date.
More information and updates can be found on the github: https://github.com/JoshButton/countrysOfTheWorldHashMap
 @author Joshua Button
 @version 0.1
 @date 06/02/2019
 @website www.joshuabutton.co.uk
 */

package world;
import java.io.*;
import java.util.*;

public class World  {
	private static Map<String,State> countries = new LinkedHashMap<>();
	private static Map<String,State> tempCountries = new LinkedHashMap<String,State>();

	public static void main(String[] args) {
	  loadData();
	  loadBorders();
	  System.out.println("Countries of the world in loaded order:");
	  printMap(countries);
	  populationSort(countries);
	  System.out.println("\nCountries of the world sorted by population:");
	  printMap(countries);
	  areaSort(countries);
	  System.out.println("\nCountries of the world sorted by area:");
	  printMap(countries);
	  System.out.println("\nSpain has " + neighbours("Spain") + " bordering country(s)");
	  System.out.println("\nSpain and France are neighbours: " + border("Spain", "France"));
	  System.out.println("\nSpain and New Zealand are neighbours: " + border("Spain", "New Zealand"));
	  System.out.println("\nList of Spain's bordering countries: " + getNeighbours("Spain"));
	}

	
	private static void loadData() {
		try {
			//open the file having states string as a name
			Scanner in = new Scanner(new FileReader("states.txt"));
			String s = ""; 
			//read the file line by line
			while (in.hasNextLine()) {
				// 's' is the string to parse, split is a string method that looks for the defined
				// separator characters and split the string in an array of substrings (tokens)
				// ":" contains the set of separator characters, in this case just the colon
				String[] token =  in.nextLine().split(":");
				// Now I expect to get 4 tokens: token[0] is the country, token[1] the capital,
				// token[2] the area, token[3] the population
				// trim() is A String method that remove spaces at the beginning and the end of a string
				String country = token[0].trim(); // first token is the country name 
				String capital = token[1].trim(); // then the capital
				String dim =  token[2].trim(); 
				String pop = token[3].trim();
				//Convert the string representation of area and population to numbers
				long area = Long.parseLong(dim);
				long population = Long.parseLong(pop);
				////System.out.println(country + " parsed");
				// At this point, country, capital, area and population
				// are the relevant data for a country
				// Now we need to add these data to a data structure
				
				///Add your code here below
				addState(country,capital,area,population);
				//System.out.println(countries.get(country).getName() + " " + countries.get(country).getPopulation());
				//end of your code
			}
		//Error management code, now don't worry about it 
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	private static void loadBorders() {
		try {
			Scanner in = new Scanner(new FileReader("borders.txt"));
			String s = "";

			while (in.hasNextLine()) {
				String[] token = in.nextLine().split(":");

				String country1 = token[0].trim(); // first token is the country name
				String country2 = token[1].trim(); // then the capital
				setBorder(country1,country2);
			}
			//Error management code, now don't worry about it
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	private static void addState(String state, String capital, long pop, long area) {
		countries.put(state,new State(state,capital,area,pop));
	}

	public static String getCapital(String s) { return countries.get(s).getCapital(); }

	public static long getPopulation(String s) { return countries.get(s).getPopulation(); }

	public static double getArea(String s) { return countries.get(s).getArea(); }

	private static void setBorder(String st1, String st2) {
		countries.get(st1).setNeighbour(st2);
		countries.get(st2).setNeighbour(st1);
	}

	private static void populationSort(Map<String, State> unsortedMap) {
		List<Map.Entry<String, State>> tempList = new LinkedList<Map.Entry<String, State>>(unsortedMap.entrySet());

		Collections.sort(tempList, (c1, c2) -> (c2.getValue().getPopulation()).compareTo(c1.getValue().getPopulation()));

		listToMap(tempList);
	}

	private static void areaSort(Map<String, State> unsortedMap) {
		List<Map.Entry<String, State>> tempList = new LinkedList<Map.Entry<String, State>>(unsortedMap.entrySet());

		Collections.sort(tempList, (c1, c2) -> (c2.getValue().getArea()).compareTo(c1.getValue().getArea()));

		listToMap(tempList);
	}

	private static void listToMap(List<Map.Entry<String, State>> list){
		for (Map.Entry<String, State> entry : list) {
			tempCountries.put(entry.getKey(), entry.getValue());
		}

		countries.clear();
		countries.putAll(tempCountries);
		tempCountries.clear();
	}

	private static void printMap(Map<String, State> mapToPrint) {
		int i = 1;
		for (State entry : mapToPrint.values()) {
			System.out.println(i + ": " + entry.getName() + ", Pop: " + entry.getPopulation() + ", Area: " + entry.getArea());
			i++;
		}
	}

	private static int neighbours(String state) {
		return countries.get(state).getNoNeighbours();
	}


	private static boolean border(String a, String b) {
		return countries.get(a).isNeighbourOf(b) || countries.get(b).isNeighbourOf(a);
	}

	private static String getNeighbours(String state) {
		return countries.get(state).getNeighbours();
	}
}