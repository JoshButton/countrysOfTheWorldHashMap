package world;

import java.util.ArrayList;

public class State implements Comparable<State> {

	private String name;
	private String capital;
	private long population;
	private long area;
	private ArrayList<String> neigbours;

	public State(String name, String capital, long population, long area) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.area = area;
		neigbours = new ArrayList<String>();
	}

	public int compareTo(State arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getArea() {
		return area;
	}

	public void setNeighbour(String newNeighbour) {
		neigbours.add(newNeighbour);
	}

}
