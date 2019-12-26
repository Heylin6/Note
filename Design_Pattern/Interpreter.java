//
//  解譯器模式
//
// https://ithelp.ithome.com.tw/articles/10208556

//用broser為例子實作看看這個模式(虛擬碼··· )
public class BrowserContext {

    private String text;
    public String browserText;

    public String getText(){

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }
}

//AbstractExpression
public abstract class AbstractExpression {

    abstract public void interpret(BrowserContext context);
}

//另外兩種Concrete interpreter
public class TerminalExprssion extends AbstractExpression {

    @Override
    public void interpret(BrowserContext context) {

        System.out.println("終端的解釋器");
    }
}

public class NonterminalExpression extends AbstractExpression{

    @Override
    public void interpret(BrowserContext context) {

        System.out.println("非終端的解釋器");
    }
}

public class Client {

    public void test(){

        BrowserContext context = new BrowserContext();
        //先用語法分析器，將詞句分類，選擇要用哪種解釋器解釋。

        /**
         * 做了各種分類
         */

        //兩種解釋器
        AbstractExpression nonterminal = new NonterminalExpression();
        AbstractExpression terminal = new TerminalExprssion();

        /**
         *不同的詞句要對應到對的解釋器
         */

        //終端的丟進終端解釋
        terminal.interpret(context);

        //非終端的丟進非終端解釋
        nonterminal.interpret(context);
    }
}

//
// 打印結果
//
// 終端的解釋器
// 非終端的解釋器
//