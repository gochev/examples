import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MainHighLevelFluentAPi {
	public static void main(String[] args) {
		IntegerProperty num1 = new SimpleIntegerProperty(1);
		IntegerProperty num2 = new SimpleIntegerProperty(2);
		
		NumberBinding sum = num1.add(num2);
		
		System.out.println(sum.getValue());
		
		num1.setValue(2);
		
		System.out.println(sum.getValue());
		
		num2.setValue(3);
		System.out.println(sum.getValue());
		
		num1.setValue(5);
		System.out.println(sum.getValue());
		
	}
}
