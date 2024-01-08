/*
 * Sap xep mang sinh vien
 */
import java.util.*;
class StudentSort
{
	public static void main (String[] s)
    {
    	Student[] st =new Student[5];
    	st[0]=new Student("Vy",27);
    	st[1]=new Student("Hoa",17);
    	st[2]=new Student("Nam",21);
    	st[3]=new Student("Loan",22);
    	st[4]=new Student("Anh",25);
    	Arrays.sort(st);
    	System.out.println ("The sorted students by age:");
//		for (int i = 0; i<st.length; i++)
//			System.out.println (st[i].name +"\t"+st[i].age);
        for (Student student : st) System.out.println(student.name + "\t" + student.age);
    }
}
class Student implements Comparable
{
	String name;
	int age;
	Student (String name, int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object o)
	{
		Student st=(Student) o;
		if (age<st.age)
			return -1;
		else
			if (age>st.age )
				return 1;
			else
				return 0;
	}
	
}
