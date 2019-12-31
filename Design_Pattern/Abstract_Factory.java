//
//  抽象工廠模式
//
// https://ithelp.ithome.com.tw/articles/10208955

// BMW 和 Audi 都有 Jeep 和 SUV，用抽象工廠實現

// Audi 的介面

public abstract class Audi {
    
    private String brand;
    private String type;

    public Audi(){

        this.brand = "Audi";
    }

    public String getBrand() {

        return brand;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }
}

// BMW 的介面
public abstract class BMW {

    private String brand;
    private String type;

    public BMW(){

        this.brand = "BMW";
    }

    public String getBrand() {

        return brand;
    }

    public String getType() {

        return type;
    }
    
    public void setType(String type) {

        this.type = type;
    }

}

// Audi 的產品
public class AudiSUV extends Audi {

    public AudiSUV() {

        super();
        setType("SUV");
    }
}

public class AudiJeep extends Audi{

    public AudiJeep() {

        super();
        setType("Jeep");
    }
}

// BMW 的產品
public class BMWSUV extends BMW {

    public BMWSUV() {

        super();
        setType("SUV");
    }
}

public class BMWJeep extends BMW{

    public BMWJeep() {

        super();
        setType("Jeep");
    }
}

// 抽象工廠可以製作某品牌的 Jeep 或是 SUV
public abstract class AbstractFactory {

    public abstract Audi createAudi();
    public abstract BMW createBMW();
}

// Jeep 工廠
public class JeepFactory extends AbstractFactory {

    @Override
    public Audi createAudi() {

        return new AudiJeep();
    }

    @Override
    public BMW createBMW() {

        return new BMWJeep();
    }
}

// SUV 工廠
public class SUVFactory extends AbstractFactory {

    @Override
    public Audi createAudi() {

        return new AudiSUV();
    }

    @Override
    public BMW createBMW() {

        return new BMWSUV();
    }
}


public class Test {
    
    public void test(){

        AbstractFactory factorySUV = new SUVFactory();
        System.out.println("----- SUV Factory -----");

        Audi suvAudi = factorySUV.createAudi();
        System.out.println(suvAudi.getBrand() + "的" + suvAudi.getType());

        BMW suvBMW = factorySUV.createBMW();
        System.out.println(suvBMW.getBrand() + "的" + suvBMW.getType());



        AbstractFactory factoryJeep = new JeepFactory();
        System.out.println("----- Jeep Factory -----");

        Audi jeepAudi = factoryJeep.createAudi();
        System.out.println(jeepAudi.getBrand() + "的" + jeepAudi.getType());

        BMW jeepBMW = factoryJeep.createBMW();
        System.out.println(jeepBMW.getBrand() + "的" + jeepBMW.getType());
    }
}

//
// 打印結果
//
// ----- SUV Factory -----
// Audi的SUV
// BMW的SUV
// ----- Jeep Factory -----
// Audi的Jeep
// BMW的Jeep
//