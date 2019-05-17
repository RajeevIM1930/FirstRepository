package dataStructures;

public class SingleTonEx {

	private static SingleTonEx s = null;

	public String str;

	private SingleTonEx() {
		this.str = "UP";
	}

	public static SingleTonEx getInstance() {
		if (s == null)
			s = new SingleTonEx();

		return s;

	}

	public static void main(String[] args) {
		SingleTonEx a = getInstance();
		SingleTonEx b = getInstance();
		a.str = a.str.toLowerCase();
		System.out.println(a.str);
		b.str = b.str.toUpperCase();
		System.out.println(a.str);

	}

}
