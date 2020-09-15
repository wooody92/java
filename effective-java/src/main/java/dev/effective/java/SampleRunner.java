package dev.effective.java;

//import dev.effective.java.chapter1.test.TestImplementsClass;
import dev.effective.java.chapter1.test.TestExtendClass;
import dev.effective.java.chapter1.test.TestInterface;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        TestImplementsClass test1 = new TestImplementsClass();
//        test1.print();

        TestExtendClass test2 = new TestExtendClass();
        test2.print();

        TestInterface.getLowerType();
    }
}
