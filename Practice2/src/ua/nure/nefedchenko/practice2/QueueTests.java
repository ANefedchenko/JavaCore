package ua.nure.nefedchenko.practice2;

import java.util.Iterator;

public class QueueTests {

    public static void main(String[] args) {
        System.out.println("TEST1");
        test1();
        System.out.println();
        System.out.println("TEST2");
        test2();
        System.out.println();
        System.out.println("TEST3");
        test3();
        System.out.println();
        System.out.println("TEST4");
        test4();
        System.out.println();
        System.out.println("TEST5");
        test5();
        System.out.println();
        System.out.println("TEST6");
        test6();
        System.out.println();
        System.out.println("TEST7");
        test7();
        System.out.println();
        System.out.println("TEST8");
        test8();
        System.out.println();
        System.out.println("TEST9");
        test9();
        System.out.println();
        System.out.println("TEST10");
        test10();
        System.out.println();
    }

    public static void test1() {

        Queue queue = new QueueImpl();
        Class c = queue.getClass();

        // must be 1
        System.out.println(c.getInterfaces().length);

        // must be Queue
        System.out.println(c.getInterfaces()[0].getSimpleName());

        // must be 1
        System.out.println(c.getInterfaces()[0].getInterfaces().length);

        // must be Container
        System.out.println(c.getInterfaces()[0].getInterfaces()[0].getSimpleName());

        // must be 1
        System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces().length);

        // must be java.lang.Iterable
        System.out.println(c.getInterfaces()[0].getInterfaces()[0].getInterfaces()[0].getName());

		/* an output must be as the following:
		*************************************
		1
		Queue
		1
		Container
		1
		java.lang.Iterable
		*************************************
		*/
    }

    public static void test2() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue);
        System.out.println(queue.size());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.size());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println(queue);
        System.out.println(queue.size());

		/* an output must be as the following:
		*************************************
		[A, B, C]
		3
		[]
		0
		[A, B, C]
		3
		*************************************
		*/
    }

    public static void test3() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.print(queue.dequeue());
        System.out.println();
        System.out.print(queue);

		/* an output must be as the following:
		*************************************
		ABC
		[]
		*************************************
		*/
    }

    public static void test4() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        for (Object element : queue) {
            System.out.print(element);
        }

		/* an output must be as the following:
		*************************************
		ABC
		*************************************
		*/
    }

    public static void test5() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        it = queue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }

		/* an output must be as the following:
		*************************************
		ABC
		ABC
		*************************************
		*/
    }

    public static void test6() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Iterator it = queue.iterator();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        it.remove();
        System.out.println(queue);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[]
		*************************************
		*/
    }

    public static void test7() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Iterator it = queue.iterator();

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        it.remove();
        System.out.println(queue);

        it = queue.iterator();

        System.out.println(it.next());
        it.remove();
        System.out.println(queue);

        it = queue.iterator();

        System.out.println(it.next());
        it.remove();
        System.out.println(queue);

		/* an output must be as the following:
		*************************************
		A
		B
		C
		[A, B]
		A
		[B]
		B
		[]
		*************************************
		*/
    }

    public static void test8() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Iterator it = queue.iterator();
        System.out.println(it.next());
        it.remove();
        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println("exception");
        }

		/* an output must be as the following:
		*************************************
		A
		exception
		*************************************
		*/
    }

    public static void test9() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        Iterator it = queue.iterator();
        try {
            it.remove();
        } catch (IllegalStateException ex) {
            System.out.println("exception");
        }

		/* an output must be as the following:
		*************************************
		exception
		*************************************
		*/
    }

    public static void test10() {

        Queue queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println(queue.top());

		/* an output must be as the following:
		*************************************
		A
		*************************************
		*/
    }

}
