import java.lang.reflect.*;
public class JavapTool{
	public static void main(String ... arg){
		if(arg.length==0){
			System.out.println("Some class name expected:\nmyjavap CLASS_NAME");
		}
		else{
			if(arg.length==1){
				printClassInfo(arg[0]);
			}
		}
	}
	
	public static void printClassInfo(Object classobject){
		try{
			Class c= classobject.getClass();
			printClassInfo(c.getName());
		}
		catch(Exception e){
			System.out.println("Some unexpected error occured");
			e.printStackTrace();
		}
	}
	
	public static void printClassInfo(Class classVar){
		try{
			printClassInfo(classVar.getName());
		}
		catch(Exception e){
			System.out.println("Some unexpected error occured");
			e.printStackTrace();
		}
	}
	
	public static void printClassInfo(String className){
		try{
			Class c= Class.forName(className);
			/*
			int mod= c.getModifiers();
			if(Modifier.isPublic(mod))
				System.out.print("public ");
			if(Modifier.isFinal(mod))
				System.out.print("final ");
			if(Modifier.isAbstract(mod))
				System.out.print("abstract ");
			
			System.out.print(c+" ");*/
			
			//System.out.println(c.toString()+" ");
			System.out.println(c.toGenericString()+" ");//since jdk 1.8 only
			
			Class superClass= c.getSuperclass();
			if(superClass!=null && superClass!=Object.class)
				System.out.print("extends "+superClass.getName()+" ");
			
			Class superInterfaces[]= c.getInterfaces();
			if(superInterfaces.length>0){
				System.out.print("implements ");
				for(int i=0; i<superInterfaces.length;i++){
					System.out.print(superInterfaces[i].getName());
					if(i==superInterfaces.length-1)
						System.out.print(" ");
					else
						System.out.print(",");
				}
			}
			
			System.out.print("{\n");
			
			Field f[]= c.getFields();
			for(Field x: f)
				System.out.println("  "+x+";");
			
			Constructor con[]= c.getConstructors();
			for(Constructor x: con)
				System.out.println("  "+x+";");
			
			Method met[]= c.getMethods();
			for(Method x: met)
				System.out.println("  "+x+";");
			
			System.out.println("  static{};");
			
			System.out.println("}");
		}
		catch(ClassNotFoundException e){
			System.out.println("Error: class not found: "+className);
		}
		catch(Exception e){
			System.out.println("Some unexpected error occured");
			e.printStackTrace();
		}
	}
}