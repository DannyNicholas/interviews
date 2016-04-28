package intervews.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterList {

	public List<Person> filter(List<Person> people, IFilter filter) {

		List<Person> filterList = new ArrayList<>();

		for (Person aPerson : people) {
			if (filter.filter(aPerson)) {
				filterList.add(aPerson);
			}
		}

		return filterList;
	}

}
