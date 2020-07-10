import java.util.ArrayList;
import java.util.List;



public class CompareObjectsTest {

    private static String[] test = {"One", "Two", "Two"};
    private static boolean Result;
    private static List<Object> objects;

    static {
        objects = new ArrayList<>();
        objects.add(new TestObject("One"));
        objects.add(new TestObject("Two"));
        objects.add(new TestObject("Two"));
    }

    public static void CompareObjectsTest() {
        System.out.println("Запуск теста класса CompareObjects");
        CompareMassive();
        compareToStringMassive();
        compareHashCodeMassive();
        compareArray();
        compareToStringArray();
        compareHashCodeArray();
    }

    public static void result() {
        if(Result==true)
            System.out.println("переменные равны");
        else
            System.out.println("переменные не равны");
    }
    public static void separate() {
        System.out.println("---------------------------------------------------------");
    }
    /**
     * сравнение переменных массива
     */

    public static void CompareMassive() {
        separate();
        System.out.println("Сравнение переменных массива");
        separate();
        Result=CompareObjects.compare(test[0],test[0]); //должно быть true
        result();
        Result=CompareObjects.compare(test[0],test[1]); //должно быть false
        result();
        Result=CompareObjects.compare(test[1],test[2]);//должно быть true
        result();
        Result=CompareObjects.compare(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    public static void compareToStringMassive() {
        System.out.println("Построчное сравнение переменных массива");
        separate();
        Result=CompareObjects.compareToString(test[0],test[0]); //должно быть true
        result();
        Result=CompareObjects.compareToString(test[0],test[1]); //должно быть false
        result();
        Result=CompareObjects.compareToString(test[1],test[2]);//должно быть true
        result();
        Result=CompareObjects.compareToString(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    public static void compareHashCodeMassive() {
        System.out.println("Сравнение хэш-кодов переменных массива");
        separate();
        Result=CompareObjects.compareHashCode(test[0],test[0]); //должно быть true
        result();
        Result=CompareObjects.compareHashCode(test[0],test[1]); //должно быть false
        result();
        Result=CompareObjects.compareHashCode(test[1],test[2]);//должно быть true
        result();
        Result=CompareObjects.compareHashCode(test[0],test[2]);// должно быть false
        result();
        separate();
    }

    /**
     * сравнение объектов ArrayList
     */

    public static void compareArray() {
        System.out.println("Сравнение объектов ArrayList");
        separate();
        Result=CompareObjects.compare(objects.get(0), objects.get(0)); //должно быть true
        result();
        Result=CompareObjects.compare(objects.get(0), objects.get(1)); //должно быть false
        result();
        Result=CompareObjects.compare(objects.get(1), objects.get(2));//должно быть true
        result();
        Result=CompareObjects.compare(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }

    public static void compareToStringArray() {
        System.out.println("Построчное сравнение объектов ArrayList");
        separate();
        Result = CompareObjects.compareToString(objects.get(0), objects.get(0)); //должно быть true
        result();
        Result = CompareObjects.compareToString(objects.get(0), objects.get(1)); //должно быть false
        result();
        Result = CompareObjects.compareToString(objects.get(1), objects.get(2));//должно быть true
        result();
        //System.out.println(objects.get(1).toString()); //CompareObjectsTest$TestObject@4554617c
        //System.out.println(objects.get(2).toString()); //CompareObjectsTest$TestObject@74a14482
        Result=CompareObjects.compareToString(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }

    public static void compareHashCodeArray() {
        System.out.println("Сравнение хэш-кодов объектов ArrayList");
        separate();
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(0)); //должно быть true
        result();
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(1)); //должно быть false
        result();
        Result=CompareObjects.compareHashCode(objects.get(1), objects.get(2));//должно быть true
        result();
        Result=CompareObjects.compareHashCode(objects.get(0), objects.get(2));// должно быть false
        result();
        separate();
    }

    private static class TestObject {
        public String number;

        public TestObject(String number) {
            this.number = number;
        }
    }
    /**
     * как я понял при работе с простым массивом или ArrayList без создания объекта и добавлением одного
     * простого элемента все эти методы работают правильно но если появляется объект то методы начинают сравнивать
     * ссылки на объекты и хэш коды а не их содержимое и выводят несоответствие
     */
}
