//
//  迭代器
// 
// Aggregate：集合的抽象類別（也稱作Collection）。
// Concrete Aggregate：具體的集合，要可以從這裡得到迭代器(Iterator)。
// Iterator：各種迭代器的介面，有必須要實現的幾種方法。
// Concrete Iterator：具體的迭代器（可以用各種不同方式遍歷集合）。
// 
//  Foreach就是一種迭代器
//
// https://ithelp.ithome.com.tw/articles/10207704

//Iterator pattern 發公司員工薪水

public interface Iterator {
    
    public Object First();
    public Object next();
    public boolean IsDone();
    public Object CurrentItem();
}

public interface Aggregate {

    public Iterator CreateIterator();
}

//員工
public class Employee {

    String name;
    String title;

    public Employee(String name,String title){

        this.name = name;
        this.title = title;
    }
}

//公司
public class CompanyA implements Aggregate{

    List<Employee> emplotees = new ArrayList<>();

    public class CompanyA(){

        //為了方便先預先放入員工
        employees.add(new Employee("小萱","業務"));
        employees.add(new Employee("小尉","工程師"));
        employees.add(new Employee("小陞","程序猿"));
        employees.add(new Employee("阿偉","專案管理"));
        employees.add(new Employee("小詩","吉祥物"));
        employees.add(new Employee("阿農","分析兼司機"));
    }

    @Override
    public Iterator CreateIterator() {
        return new CompanaAIterator(this);
    }    
}

//迭代器
public class CompanyAIterator implements Iterator{

    private CompanyA companyA;
    private int current = 0;

    public class CompanyAIterator(){

        this.companyA=companyA;
    }

    @Override
    public Object First() {
        return companyA.employees.get(current);
    }

    @Override
    public Object Next() {
        Object ret = null;
        current++;
        if( current < companyA.employees.size()){
            ret = companyA.employees.get(current);
        }

        return ret;
    }

    @Override
    public boolean IsDone() {
        return current >= companyA.employees.size() ? true : false ;
    }

    @Override
    public Object CurrentItem() {
        return companyA.employees.get(current);
    }
}

public class Test {

    @org.junit.jupiter.api.Test
    public void test(){

        CompanyA companyA = new CompanyA();

        Iterator iterator = companyA.CreateIterator();

        while(!iterator.IsDone()){
            System.out.println( ((Employee)iterator.CurrentItem()).name + " : " +  ((Employee)iterator.CurrentItem()).title + " 發薪水囉～");
            iterator.Next();
        }

    }
}

// 打印結果

// 小萱 : 業務 發薪水囉～
// 小尉 : 工程師 發薪水囉～
// 小陞 : 程序猿 發薪水囉～
// 阿偉 : 專案管理 發薪水囉～
// 小詩 : 吉祥物 發薪水囉～
// 阿農 : 分析兼司機 發薪水囉～
