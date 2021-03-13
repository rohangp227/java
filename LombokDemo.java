import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Builder @Getter @Setter @ToString
class Person{
	private int id;
	private String name;
}
class LombokDemo{
	public static void main(String ... args){
		//Person p= new Person();//when not using builder
		Person p= new Person(1,"Abc");
		System.out.println(p);
		JavapTool.printClassInfo(p);
		System.out.println("________________");
		JavapTool.printClassInfo(Person.builder());
	}
}