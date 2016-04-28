package intervews.filter;

public class FilterAge implements IFilter {

	@Override
	public boolean filter(Person person) {
		return (person.getAge() > 42);
	}

}
