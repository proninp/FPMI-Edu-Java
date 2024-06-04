package section5;

import java.util.ArrayList;
import java.util.List;

public class ArraysFpmi {
    /**
     * 5.1 Поиск первого значения
     * @param arr массив
     * @param x искомое значение
     * @return  возвращает индекс первого вхождения числа x в массив arr.
     * Если число не входит в массив – возвращается -1.
     */
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * 5.2 Поиск последнего значения
     * @param arr массив
     * @param x искомое значение
     * @return  возвращает индекс последнего вхождения числа x в массив arr.
     * Если число не входит в массив – возвращается -1.
     */
    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * 5.3 Поиск максимального
     * @param arr массив
     * @return возвращает наибольшее по модулю (то есть без учета знака) значение массива arr
     */
    public static int maxAbs(int[] arr) {
        if (arr == null || arr.length == 0)
            return Integer.MIN_VALUE;
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxNum))
                maxNum = arr[i];
        }
        return maxNum;
    }

    /**
     * 5.4 Подсчет позитива
     * @param arr массив
     * @return количество положительных элементов
     */
    public static int countPositive(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                count++;
        }
        return count;
    }

    /**
     * 5.5 Палиндром
     * @param arr массив
     * @return возвращает true, если массив arr является палиндромом,
     * то есть справа-налево и наоборот читается одинаково
     */
    public static boolean palindrom(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i])
                return false;
        }
        return true;
    }

    /**
     * 5.6 Реверс
     * @param arr массив
     */
    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    /**
     * 5.7 Возвратный реверс
     * @param arr массив
     * @return массив, в котором значения массива arr записаны задом наперед
     */
    public static int[] reverseBack(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = arr.length -1; i >= 0 ; i--) {
            res[arr.length - i - 1] = arr[i];
        }
        return res;
    }

    /**
     * 5.8 Объединение
     * @param arr1 первый массив
     * @param arr2 второй массив
     * @return объедиенный массив (arr1 + arr2)
     */
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }

    /**
     * 5.9 Все вхождения
     * @param arr массив
     * @param x искомый элемент
     * @return массив индексов вхождений элемента x
     */
    public static int[] findAll(int[] arr, int x) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == x)
//                res.add(i);
//        }
//        return res.stream().mapToInt(Integer::intValue).toArray();
        int resultLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                resultLen++;
        }
        int[] result = new int[resultLen];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] == x)
                result[j++] = i;
        }
        return result;
    }

    /**
     * 5.10 Удалить негатив
     * @param arr массив
     * @return возвращает новый массив, в котором записаны все элементы массива arr кроме отрицательных
     */
    public static int[] deleteNegative(int[] arr) {
        int resultLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                resultLen++;
        }
        int[] result = new int[resultLen];
        if (resultLen == 0)
            return result;
        for (int i = 0, j = 0; i < arr.length ; i++) {
            if (arr[i] > 0)
                result[j++] = arr[i];
        }
        return result;
    }

    /**
     * 5.11 Добавление в массив
     * @param arr массив
     * @param x что нужно добавить
     * @param pos позиция на которую добавить x
     * @return новый массив
     */
    public static int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        result[pos] = x;
        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }

    /**
     * 5.12 Добавление массива в массив
     * @param arr массив
     * @param ins массив, который нужно добавить
     * @param pos позиция с которой нужно добавить
     * @return новый массив, содержащий все элементы массива arr, в позицию pos будут вставлены значения массива ins
     */
    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0, j = pos; i < ins.length; i++) {
            result[j++] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }
        return result;
    }
}
