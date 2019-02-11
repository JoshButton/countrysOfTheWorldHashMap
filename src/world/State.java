package world;

import java.util.ArrayList;

public class State implements Comparable<State> {

	private String name;
	private String capital;
	private long population;
	private long area;
	private ArrayList<String> neighbours;

	State(String name, String capital, long population, long area) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.area = area;
		neighbours = new ArrayList<String>();
	}

	public int compareTo(State arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	String getName() {
		return name;
	}

	String getCapital() {
		return capital;
	}

	Long getPopulation() {
		return population;
	}

	Long getArea() {
		return area;
	}

	void setNeighbour(String newNeighbour) {
		neighbours.add(newNeighbour);
	}

	int getNoNeighbours(){
		return neighbours.size();
	}

	boolean isNeighbourOf(String country) {
			return neighbours.contains(country);
	}

	String getNeighbours() {
		return neighbours.toString().replace("[","").replace("]","");
	}
}
