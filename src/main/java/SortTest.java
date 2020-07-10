public class SortTest {



    public static void testSort() {
        System.out.println("Запуск теста класса Sort");
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {1, 2, 3, 4, 5};
        Sort.reverseSort(arr1);
            if (arr1.equals(arr2))
                System.out.println("Массивы равны");
            else
                System.out.println("Массивы не равны");
    }
}