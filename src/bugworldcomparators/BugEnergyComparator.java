package bugworldcomparators;
import java.util.Comparator;
import bugworld.Bug;

public class BugEnergyComparator implements Comparator<Bug>{
	
	public int compare(Bug o1, Bug o2) {
		return o1.getStrength()-o2.getStrength();
	}
}