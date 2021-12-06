public class triangle
{
    protected float len; //длина строны
    public final void set_len(float l)
    {
        len = l;
    } //установить длину
    public final float perimeter()
    {
        return len * 3;
    }

    public final float area()
    {
        //вычисляется по формуле герона
        float p = len * 3 / 2;
        float a = Math.sqrt(p * (p - len) * (p - len) * (p - len));
        return a;
    }

    public final void show_perimeter()
    {
        System.out.print("Perimeter of the triangle is equal to ");
        System.out.print(this.perimeter());
        System.out.print("\n");
    }

    public final void show_area()
    {
        System.out.print("Area of a triangle is equal to ");
        System.out.print(this.area());
        System.out.print("\n");
    }
}
//класс призм
public class prism extends triangle
{
    private float h; //высота
    public final void set_h(float hh)
    {
        h = hh;
    } //установит значение высоты
    public final float volume()
    {
        return super.area() * h;
    }

    public final float area()
    {
        return super.area() * 2 + (h * len) * 3;
    }

    public final void show_volume()
    {
        System.out.print("The volume of the prism is ");
        System.out.print(this.volume());
        System.out.print("\n");
    }

    public final void show_area()
    {
        System.out.print("Area of a prism is equal to ");
        System.out.print(this.area());
        System.out.print("\n");
    }
}

package <missing>;

public class GlobalMembers
{
    public static void main(String[] args)
    {
        int N;
        System.out.print("Enter the count of triangles N: ");
        N = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));

        int M;
        System.out.print("Enter the number of prisms M: ");
        M = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));

        int i;
        triangle[] ar_tr = tangible.Arrays.initializeWithDefaultTriangleInstances(N); //массив объектов треугольников
        //ввод значения стороны треугольника
        float temp;
        for (i = 0; i < N; i++)
        {
            System.out.print("Enter the length of the triangle: ");
            temp = Float.parseFloat(ConsoleInput.readToWhiteSpace(true));
            ar_tr[i].set_len(temp);
        }
        //вывод данных (площадь и периметр) о треугольниках
        for (i = 0; i < N; i++)
        {
            ar_tr[i].show_area();
            ar_tr[i].show_perimeter();
        }
        prism[] ar_pr = tangible.Arrays.initializeWithDefaultPrismInstances(M); //массив объектов призм
        //ввод грани и высоты призмы
        for (i = 0; i < N; i++)
        {
            System.out.print("Enter the face and height of the prisms: ");
            temp = Float.parseFloat(ConsoleInput.readToWhiteSpace(true));
            ar_pr[i].set_len(temp);
            temp = Float.parseFloat(ConsoleInput.readToWhiteSpace(true));
            ar_pr[i].set_h(temp);
        }
        //вывод данных (площадь и объем) о призмах
        for (i = 0; i < M; i++)
        {
            ar_pr[i].show_area();
            ar_pr[i].show_volume();
        }
        //поиск среднего значения площади треугольников
        float sum = 0F;
        for (i = 0; i < N; i++)
        {
            sum += ar_tr[i].area();
        }
        float average = sum / N; //среднее значение
        //вывод количества треугольников площадь которых меньше средней
        int count = 0;
        for (i = 0; i < N; i++)
        {
            if (ar_tr[i].area() < average)
            {
                count++;
            }
        }
        System.out.print("\nThe count of triangles, whose area is less than the average: ");
        System.out.print(count);

        //поиск призмы с наибольшим объемом
        float max = ar_pr[0].volume();
        for (i = 1; i < M; i++)
        {
            if (max < ar_pr[i].volume())
            {
                max = ar_pr[i].volume();
            }
        }
        System.out.print("Value of the maximum volume of prisms: ");
        System.out.print(max);

        System.in.read();
    }
}
public final class Arrays
{
    public static triangle[] initializeWithDefaultTriangleInstances(int length)
    {
        triangle[] array = new triangle[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = new triangle();
        }
        return array;
    }

    public static prism[] initializeWithDefaultPrismInstances(int length)
    {
        prism[] array = new prism[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = new prism();
        }
        return array;
    }

    public static <T extends java.io.Closeable> void deleteArray(T[] array)
    {
        for (T element : array)
        {
            if (element != null)
                element.close();
        }
    }
}

public final class ConsoleInput
{
    private static boolean goodLastRead = false;
    public static boolean lastReadWasGood()
    {
        return goodLastRead;
    }

    public static String readToWhiteSpace(boolean skipLeadingWhiteSpace)
    {
        String input = "";
        char nextChar;
        while (Character.isWhitespace(nextChar = (char)System.in.read()))
        {

            if (!skipLeadingWhiteSpace)
            {
                input += nextChar;
            }
        }

        input += nextChar;


        while (!Character.isWhitespace(nextChar = (char)System.in.read()))
        {
            input += nextChar;
        }

        goodLastRead = input.length() > 0;
        return input;
    }

    public static String scanfRead()
    {
        return scanfRead(null, -1);
    }

    public static String scanfRead(String unwantedSequence)
    {
        return scanfRead(unwantedSequence, -1);
    }

    public static String scanfRead(String unwantedSequence, int maxFieldLength)
    {
        String input = "";

        char nextChar;
        if (unwantedSequence != null)
        {
            nextChar = '\0';
            for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
            {
                if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
                {

                    while (Character.isWhitespace(nextChar = (char)System.in.read()))
                    {
                    }
                }
                else
                {

                    nextChar = (char)System.in.read();
                    if (nextChar != unwantedSequence.charAt(charIndex))
                        return null;
                }
            }

            input = (new Character(nextChar)).toString();
            if (maxFieldLength == 1)
                return input;
        }

        while (!Character.isWhitespace(nextChar = (char)System.in.read()))
        {
            input += nextChar;
            if (maxFieldLength == input.length())
                return input;
        }

        return input;
    }
}
