import java.util.HashMap;


public class MapTest {
    static private int fails=0;
    static private HashMap<String, String> map = new HashMap<String, String>();


    public static void testMap() {
        System.out.println("Запуск теста класса Map");
        countElementsInMap();
        deleteValueFromMapTest();
    }

    public static void Search(int result){
        if (result>=1)
            System.out.println("Совпадений: "+ result);
        else{
            System.out.println("Совпадений нет, ошибка");
            fails++;
        }
    }
    public static void countElementsInMap(){
        CompareObjectsTest.separate();
        int result;
        result=Map.countElementsInMap("Дмитров","Алексей");
        Search(result);
        result=Map.countElementsInMap("Дмитров","Алексей");
        Search(result);
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        result=Map.countElementsInMap("Ярмолов","Алексей");
        Search(result);
        result=Map.countElementsInMap("Карасев","Дмитрий");
        Search(result);
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        result=Map.countElementsInMap("Андреев","Андрей");
        Search(result);
        result=Map.countElementsInMap("Смирнов","Владимир");
        Search(result);
        result=Map.countElementsInMap("Ерохин","Сергей");
        Search(result);
        result=Map.countElementsInMap("Андреев","Андрей");
        Search(result);
        System.out.println("Ошибок во время поиска: "+ fails);
        // убрал пробелы в ключе и значении,ключ в hashmap уникальный, не годится для имен и фамилий с повторами
    }
    public static void Delete(HashMap map,String value){
        CompareObjectsTest.separate();
        int HashMapSize = map.size();
        System.out.println("Удаляем по значению value '"+value+("'"));
        try {
            System.out.println(Map.deleteValueFromMap(map, value)); // возникает concurrent modification exception
        } catch (Exception e) {
            System.out.println("Произошла какая то ошибка");
        } finally {
            if (map.size() == HashMapSize - 1) {
                System.out.println("Элемент удален из таблицы");
            }
        }
        CompareObjectsTest.separate();
    }

    public static void HashMap() {
        map.clear();
        map.put("qq", "qq");
        map.put("ww", "aa");
        map.put("ee", "dd");
        map.put("gg", "hh");
    }
    public static void deleteValueFromMapTest() {
        String value1 = "qq";  //выдает ошибку
        String value2 = "aa";  //выдает ошибку
        String value3 = "dd";  //выдает ошибку
        String value4 = "hh";  //все работает

        HashMap();
        Delete(map,value1);
        HashMap();
        Delete(map,value2);
        HashMap();
        Delete(map,value3);
        HashMap();
        Delete(map,value4);
        //удаляет только последний элемент в таблице

        }
}
