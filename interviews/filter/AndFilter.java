package interviews.filter;

public class AndFilter implements IFilter {

	private IFilter filter1;
	private IFilter filter2;

	public AndFilter(IFilter filter1, IFilter filter2) {
		this.filter1 = filter1;
		this.filter2 = filter2;
	}

	@Override
	public boolean filter(Person person) {
		return filter1.filter(person) && filter2.filter(person);
	}

}
