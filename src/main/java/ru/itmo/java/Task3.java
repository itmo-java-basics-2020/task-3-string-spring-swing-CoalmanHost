package ru.itmo.java;

import java.util.*;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray)
    {
        if (inputArray != null && inputArray.length > 0)
        {
            int[] res = new int[inputArray.length];
            res[0] = inputArray[inputArray.length - 1];
            for (int i = 0; i < inputArray.length - 1; i++)
            {
                res[i + 1] = inputArray[i];
            }
            return res;
        }
        return new int[0];
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray)
    {
        if (inputArray != null && inputArray.length > 0)
        {
            int max = inputArray[0];
            for (int i = 0; i < inputArray.length - 1; i++)
            {
                for (int j = i + 1; j < inputArray.length; j++)
                {
                    if (inputArray[i] * inputArray[j] > max)
                    {
                        max = inputArray[i] * inputArray[j];
                    }
                }
            }
            return  max;
        }
        return 0;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input)
    {
        if (input != null)
        {
            String s = input.toLowerCase();
            int count = 0;
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'b')
                {
                    count++;
                }
            }
            return (int)(((double)count/(double) s.length())*100);
        }
        return 0;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input)
    {
        if (input == null)
        {
            return false;
        }
        for (int i = 0; i < input.length() / 2; i++)
        {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input)
    {
        if (input != null)
        {
            if (input.length() == 0)
            {
                return "";
            }
            String res = "";
            char key = input.charAt(0);
            int count = 1;
            for (int i = 1; i < input.length(); i++)
            {
                if (input.charAt(i) == key)
                {
                    count++;
                    continue;
                }
                res += key;
                res += count;
                key = input.charAt(i);
                count = 1;
            }
            res += key;
            res += count;
            return res;
        }
        return "";
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two)
    {
        if (one == null || two == null || (one.isBlank() && two.isBlank()))
        {
            return false;
        }
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        for (char c : one.toCharArray())
        {
            if (!counter.containsKey(c))
            {
                counter.put(c, 1);
            }
            else
            {
                counter.put(c, counter.get(c) + 1);
            }
        }
        for (char c : two.toCharArray())
        {
            if (!counter.containsKey(c))
            {
                return false;
            }
            else
            {
                counter.put(c, counter.get(c) - 1);
                if (counter.get(c) == 0)
                {
                    counter.remove(c);
                }
            }
        }
        if (counter.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s)
    {
        if (s == null || s.length() == 0)
        {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++)
        {
            for (int j = i + 1; j < s.length(); j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m)
    {
        if (m == null || m.length == 0)
        {
            return new int[0][0];
        }
        if (m[0].length == 0)
        {
            return new int[0][m.length];
        }
        int[][] v = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                v[i][j] = m[j][i];
            }
        }
        return v;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator)
    {
        if (inputStrings == null || inputStrings.length == 0)
        {
            return "";
        }
        char sep = ' ';
        if (separator != null)
        {
            sep = separator;
        }
        String res = "";
        for (int i = 0; i < inputStrings.length - 1; i++)
        {
            res += inputStrings[i];
            res += sep;
        }
        res += inputStrings[inputStrings.length - 1];
        return res;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix)
    {
        if (inputStrings == null || inputStrings.length == 0 || prefix == null)
        {
            return 0;
        }
        int count = 0;
        for (String s : inputStrings)
        {
            if (prefix.length() <= s.length())
            {
                boolean withPrefix = true;
                for (int i = 0; i < prefix.length(); i++)
                {
                    withPrefix = withPrefix & (s.charAt(i) == prefix.charAt(i));
                }
                if (withPrefix)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
