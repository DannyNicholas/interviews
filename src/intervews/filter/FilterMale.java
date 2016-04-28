package intervews.filter;

public class FilterMale implements IFilter {

	@Override
	public boolean filter(Person person) {
		return (person.getSex() == "MALE");
	}

}
