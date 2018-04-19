package edu.gcccd.csis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SelfAwareTest {
    private static File tmp;

    // Create tmp file .. runs before each and every test methods
    @Before
    public void setUp() throws Exception {
        tmp = File.createTempFile("tmp", ".tmp");
    }

    // Delete tmp file .. runs after each and every test methods
    @After
    public void tearDown() throws Exception {
        assertTrue(tmp.delete());
    }

    // Test that Strings provided in the StringArray ReservedWords are found and correctly counted in a given String
    @Test
    public void occurrences() throws Exception {
        try {
            final SelfAware sa = new SelfAware();
            int k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(0, k);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[0] + " ");
            k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(1, k);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[9] + " ");
            k = sa.occurrences((tmp.getAbsolutePath()));
            assertEquals(2, k);

            Path p = Paths.get(tmp.getAbsolutePath());
            String fileAsString = new String(Files.readAllBytes(p));
            System.out.println(fileAsString);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[9] + " ");
            k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(3, k);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[9] + " ");
            k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(4, k);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[20] + " ");
            k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(5, k);

            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[26] + " ");
            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[14] + " ");
            sa.append(tmp.getAbsolutePath(), Language.ReservedWords[5] + " ");
            k = sa.occurrences(tmp.getAbsolutePath());
            assertEquals(8, k);


            // a few more appends followed by asserts just like that ...
            // ...
        } catch (IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }

    }

    // Test that append successfully and correctly adds a given string to a file
    @Test
    public void append() throws Exception {
        try {
            assertNotNull(tmp);
            final SelfAware sa = new SelfAware();

            final long size0 = Files.size(Paths.get(tmp.toURI()));
            final String s = "// Hello World";
            sa.append(tmp.getAbsolutePath(), s);
            final long size1 = Files.size(Paths.get(tmp.toURI()));
            assertEquals(size0 + s.length(), size1);


            final Path path = Paths.get(tmp.toURI());
            final String compare = path.toString();

            System.out.print(compare);
            // now verify that the correct string was appended to the file
            // ...
            String tmpToString = new String(Files.readAllBytes(path));
            assertTrue(tmpToString.endsWith(s));
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}