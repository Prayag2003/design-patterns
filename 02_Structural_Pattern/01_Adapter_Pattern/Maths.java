import java.util.*;

// basic math functionality implements MathProcessing
// + -->  plus , * --> multiply

// sort , search , advance functionality , calc average 

interface MathProcessing {
    public void mathFunction(String operation, Integer[] data);
}

class BasicMathProcessing implements MathProcessing {

    @Override
    public void mathFunction(String operation, Integer[] data) {
        if (operation == "+") {
            int sum = 0;
            for (Integer i : data) {
                sum += i;
            }
            System.out.println(sum);
        }
        if (operation == "*") {
            int product = 1;
            for (Integer i : data) {
                product *= i;
            }
            System.out.println(product);
        }
    }
}

class AdvanceMathProcessing {

    public void calculateAvg(List<Integer> ls) {
        int avg = 0;
        for (Integer i : ls) {
            avg += i;
        }
        avg /= ls.size();
        System.out.println(avg);
    }

    public void sortData(List<Integer> ls) {
        Collections.sort(ls);
        for (Integer i : ls) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public void searchData(List<Integer> ls, int key) {
        for (Integer integer : ls) {
            if (integer == key) {
                System.out.println(key + " is Found !");
            }
        }
        System.out.println(key + " is not Found !");
    }

    public void replace(List<Integer> ls, int key, int replacement) {
        for (Integer integer : ls) {
            if (integer == key) {
                integer = replacement;
            }
        }
        for (Integer integer : ls) {
            System.out.println(integer + " ");
        }
    }
}

class MathAdpater implements MathProcessing {
    AdvanceMathProcessing amp = new AdvanceMathProcessing();

    public void mathFunction(String operation, Integer[] data) {
        if (operation.equalsIgnoreCase("average")) {
            amp.calculateAvg(Arrays.asList(data));

        } else if (operation.equalsIgnoreCase("sort")) {
            amp.sortData(Arrays.asList(data));

        } else if (operation.equalsIgnoreCase("search")) {
            amp.searchData(Arrays.asList(data), 2);

        } else if (operation.equalsIgnoreCase("replace")) {
            amp.replace(Arrays.asList(data), 2, 3);
        }
    }
}

class Maths {
    public static void main(String[] args) {
        MathProcessing mp = new BasicMathProcessing();

        Integer[] arr = { 1, 6, 3, 4, 5 };
        System.out.println("Add");
        mp.mathFunction("+", arr);
        System.out.println();

        System.out.println("Product");
        mp.mathFunction("*", arr);
        System.out.println();

        MathProcessing mprocess = new MathAdpater();
        System.out.println("Sort");
        mprocess.mathFunction("sort", arr);

        System.out.println("Average");
        mprocess.mathFunction("average", arr);

    }
}