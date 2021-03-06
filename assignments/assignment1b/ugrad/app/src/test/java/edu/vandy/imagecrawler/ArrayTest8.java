package edu.vandy.imagecrawler;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.vandy.utils.Array;
import edu.vandy.utils.ArrayCollector;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Test program for the Java 8 features in the Array class.
 */
public class ArrayTest8 {
    /**
     * Maximum test size.
     */
    private final int mMaxTestSize = 25;

    /**
     * A list of mMaxTestSize random integers.
     */
    private final List<Long> mRandomInput =
        new Random().longs(mMaxTestSize, 0, Long.MAX_VALUE)
                    .boxed()
                    .collect(toList());

    /**
     * Test the Array implementation of forEach().
     */
    @Test
    public void testArrayForEach() {
        Array<Long> a1 = new Array<>(mRandomInput);
        Array<Long> a2 = new Array<>();
        int originalSize = a1.size();

        a1.forEach(a2::add);

        assertEquals(originalSize, a2.size());
        assertEquals(a1.size(), a2.size());
    }

    /**
     * Test the Array implementation of replaceAll().
     */
    @Test
    public void testArrayReplaceAll() {
        Array<Long> array = new Array<>();

        // Add all the random input to the queue.
        array.addAll(mRandomInput);

        // Add one to each element.
        array.replaceAll(i -> i + 1);
       
        for (int i = 0; i < mRandomInput.size(); i++)
            assertEquals(mRandomInput.get(i),
                         Long.valueOf(array.get(i) - 1));
    }
}
